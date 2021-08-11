package org.pwrd.paho.client.mqttv3;

import java.util.Hashtable;
import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.pwrd.paho.client.mqttv3.internal.ClientComms;
import org.pwrd.paho.client.mqttv3.internal.ConnectActionListener;
import org.pwrd.paho.client.mqttv3.internal.ExceptionHelper;
import org.pwrd.paho.client.mqttv3.internal.LocalNetworkModule;
import org.pwrd.paho.client.mqttv3.internal.NetworkModule;
import org.pwrd.paho.client.mqttv3.internal.SSLNetworkModule;
import org.pwrd.paho.client.mqttv3.internal.TCPNetworkModule;
import org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPublish;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttSubscribe;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttUnsubscribe;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;
import org.pwrd.paho.client.mqttv3.persist.MemoryPersistence;
import org.pwrd.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.pwrd.paho.client.mqttv3.util.Debug;

public class MqttAsyncClient implements IMqttAsyncClient {
    private static final String CLASS_NAME = MqttAsyncClient.class.getName();
    private static final String CLIENT_ID_PREFIX = "paho";
    private static final long DISCONNECT_TIMEOUT = 10000;
    private static final char MAX_HIGH_SURROGATE = 56319;
    private static final char MIN_HIGH_SURROGATE = 55296;
    private static final long QUIESCE_TIMEOUT = 30000;
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String clientId;
    protected ClientComms comms;
    private MqttClientPersistence persistence;
    private String serverURI;
    private Hashtable topics;

    public MqttAsyncClient(String serverURI2, String clientId2) throws MqttException {
        this(serverURI2, clientId2, new MqttDefaultFilePersistence());
    }

    public MqttAsyncClient(String serverURI2, String clientId2, MqttClientPersistence persistence2) throws MqttException {
        this(serverURI2, clientId2, persistence2, new TimerPingSender());
    }

    public MqttAsyncClient(String serverURI2, String clientId2, MqttClientPersistence persistence2, MqttPingSender pingSender) throws MqttException {
        log.setResourceName(clientId2);
        if (clientId2 == null) {
            throw new IllegalArgumentException("Null clientId");
        }
        int clientIdLength = 0;
        int i = 0;
        while (i < clientId2.length() - 1) {
            if (Character_isHighSurrogate(clientId2.charAt(i))) {
                i++;
            }
            clientIdLength++;
            i++;
        }
        if (clientIdLength > 65535) {
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        MqttConnectOptions.validateURI(serverURI2);
        this.serverURI = serverURI2;
        this.clientId = clientId2;
        this.persistence = persistence2;
        if (this.persistence == null) {
            this.persistence = new MemoryPersistence();
        }
        log.fine(CLASS_NAME, "MqttAsyncClient", "101", new Object[]{clientId2, serverURI2, persistence2});
        this.persistence.open(clientId2, serverURI2);
        this.comms = new ClientComms(this, this.persistence, pingSender);
        this.persistence.close();
        this.topics = new Hashtable();
    }

    protected static boolean Character_isHighSurrogate(char ch) {
        return ch >= 55296 && ch <= 56319;
    }

    /* access modifiers changed from: protected */
    public NetworkModule[] createNetworkModules(String address, MqttConnectOptions options) throws MqttException, MqttSecurityException {
        log.fine(CLASS_NAME, "createNetworkModules", "116", new Object[]{address});
        String[] serverURIs = options.getServerURIs();
        String[] array = serverURIs == null ? new String[]{address} : serverURIs.length == 0 ? new String[]{address} : serverURIs;
        NetworkModule[] networkModules = new NetworkModule[array.length];
        for (int i = 0; i < array.length; i++) {
            networkModules[i] = createNetworkModule(array[i], options);
        }
        log.fine(CLASS_NAME, "createNetworkModules", "108");
        return networkModules;
    }

    private NetworkModule createNetworkModule(String address, MqttConnectOptions options) throws MqttException, MqttSecurityException {
        String[] enabledCiphers;
        log.fine(CLASS_NAME, "createNetworkModule", "115", new Object[]{address});
        SocketFactory factory = options.getSocketFactory();
        switch (MqttConnectOptions.validateURI(address)) {
            case 0:
                String shortAddress = address.substring(6);
                String host = getHostName(shortAddress);
                int port = getPort(shortAddress, 1883);
                if (factory == null) {
                    factory = SocketFactory.getDefault();
                } else if (factory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                NetworkModule netModule = new TCPNetworkModule(factory, host, port, this.clientId);
                ((TCPNetworkModule) netModule).setConnectTimeout(options.getConnectionTimeout());
                return netModule;
            case 1:
                String shortAddress2 = address.substring(6);
                String host2 = getHostName(shortAddress2);
                int port2 = getPort(shortAddress2, 8883);
                SSLSocketFactoryFactory factoryFactory = null;
                if (factory == null) {
                    factoryFactory = new SSLSocketFactoryFactory();
                    Properties sslClientProps = options.getSSLProperties();
                    if (sslClientProps != null) {
                        factoryFactory.initialize(sslClientProps, null);
                    }
                    factory = factoryFactory.createSocketFactory(null);
                } else if (!(factory instanceof SSLSocketFactory)) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                NetworkModule netModule2 = new SSLNetworkModule((SSLSocketFactory) factory, host2, port2, this.clientId);
                ((SSLNetworkModule) netModule2).setSSLhandshakeTimeout(options.getConnectionTimeout());
                if (factoryFactory == null || (enabledCiphers = factoryFactory.getEnabledCipherSuites(null)) == null) {
                    return netModule2;
                }
                ((SSLNetworkModule) netModule2).setEnabledCiphers(enabledCiphers);
                return netModule2;
            case 2:
                return new LocalNetworkModule(address.substring(8));
            default:
                return null;
        }
    }

    private int getPort(String uri, int defaultPort) {
        int portIndex = uri.lastIndexOf(58);
        if (portIndex == -1) {
            return defaultPort;
        }
        return Integer.parseInt(uri.substring(portIndex + 1));
    }

    private String getHostName(String uri) {
        int schemeIndex = uri.lastIndexOf(47);
        int portIndex = uri.lastIndexOf(58);
        if (portIndex == -1) {
            portIndex = uri.length();
        }
        return uri.substring(schemeIndex + 1, portIndex);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect(Object userContext, IMqttActionListener callback) throws MqttException, MqttSecurityException {
        return connect(new MqttConnectOptions(), userContext, callback);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect() throws MqttException, MqttSecurityException {
        return connect(null, null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions options) throws MqttException, MqttSecurityException {
        return connect(options, null, null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions options, Object userContext, IMqttActionListener callback) throws MqttException, MqttSecurityException {
        if (this.comms.isConnected()) {
            throw ExceptionHelper.createMqttException(32100);
        } else if (this.comms.isConnecting()) {
            throw new MqttException(32110);
        } else if (this.comms.isDisconnecting()) {
            throw new MqttException(32102);
        } else if (this.comms.isClosed()) {
            throw new MqttException(32111);
        } else {
            Logger logger = log;
            String str = CLASS_NAME;
            Object[] objArr = new Object[8];
            objArr[0] = Boolean.valueOf(options.isCleanSession());
            objArr[1] = new Integer(options.getConnectionTimeout());
            objArr[2] = new Integer(options.getKeepAliveInterval());
            objArr[3] = options.getUserName();
            objArr[4] = options.getPassword() == null ? "[null]" : "[notnull]";
            objArr[5] = options.getWillMessage() == null ? "[null]" : "[notnull]";
            objArr[6] = userContext;
            objArr[7] = callback;
            logger.fine(str, "connect", "103", objArr);
            this.comms.setNetworkModules(createNetworkModules(this.serverURI, options));
            MqttToken userToken = new MqttToken(getClientId());
            ConnectActionListener connectActionListener = new ConnectActionListener(this, this.persistence, this.comms, options, userToken, userContext, callback);
            userToken.setActionCallback(connectActionListener);
            userToken.setUserContext(this);
            this.comms.setNetworkModuleIndex(0);
            connectActionListener.connect();
            return userToken;
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect(Object userContext, IMqttActionListener callback) throws MqttException {
        return disconnect(QUIESCE_TIMEOUT, userContext, callback);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect() throws MqttException {
        return disconnect(null, null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect(long quiesceTimeout) throws MqttException {
        return disconnect(quiesceTimeout, null, null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect(long quiesceTimeout, Object userContext, IMqttActionListener callback) throws MqttException {
        log.fine(CLASS_NAME, "disconnect", "104", new Object[]{new Long(quiesceTimeout), userContext, callback});
        MqttToken token = new MqttToken(getClientId());
        token.setActionCallback(callback);
        token.setUserContext(userContext);
        try {
            this.comms.disconnect(new MqttDisconnect(), quiesceTimeout, token);
            log.fine(CLASS_NAME, "disconnect", "108");
            return token;
        } catch (MqttException ex) {
            log.fine(CLASS_NAME, "disconnect", "105", null, ex);
            throw ex;
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public void disconnectForcibly() throws MqttException {
        disconnectForcibly(QUIESCE_TIMEOUT, DISCONNECT_TIMEOUT);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public void disconnectForcibly(long disconnectTimeout) throws MqttException {
        disconnectForcibly(QUIESCE_TIMEOUT, disconnectTimeout);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public void disconnectForcibly(long quiesceTimeout, long disconnectTimeout) throws MqttException {
        this.comms.disconnectForcibly(quiesceTimeout, disconnectTimeout);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public boolean isConnected() {
        return this.comms.isConnected();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public String getClientId() {
        return this.clientId;
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public String getServerURI() {
        return this.serverURI;
    }

    /* access modifiers changed from: protected */
    public MqttTopic getTopic(String topic) {
        MqttTopic.validate(topic, false);
        MqttTopic result = (MqttTopic) this.topics.get(topic);
        if (result != null) {
            return result;
        }
        MqttTopic result2 = new MqttTopic(topic, this.comms);
        this.topics.put(topic, result2);
        return result2;
    }

    public IMqttToken checkPing(Object userContext, IMqttActionListener callback) throws MqttException {
        log.fine(CLASS_NAME, "ping", "117");
        MqttToken token = this.comms.checkForActivity();
        log.fine(CLASS_NAME, "ping", "118");
        return token;
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String topicFilter, int qos, Object userContext, IMqttActionListener callback) throws MqttException {
        return subscribe(new String[]{topicFilter}, new int[]{qos}, userContext, callback);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String topicFilter, int qos) throws MqttException {
        return subscribe(new String[]{topicFilter}, new int[]{qos}, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String[] topicFilters, int[] qos) throws MqttException {
        return subscribe(topicFilters, qos, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String[] topicFilters, int[] qos, Object userContext, IMqttActionListener callback) throws MqttException {
        if (topicFilters.length != qos.length) {
            throw new IllegalArgumentException();
        }
        String subs = "";
        for (int i = 0; i < topicFilters.length; i++) {
            if (i > 0) {
                subs = String.valueOf(subs) + ", ";
            }
            subs = String.valueOf(subs) + "topic=" + topicFilters[i] + " qos=" + qos[i];
            MqttTopic.validate(topicFilters[i], true);
        }
        log.fine(CLASS_NAME, "subscribe", "106", new Object[]{subs, userContext, callback});
        MqttToken token = new MqttToken(getClientId());
        token.setActionCallback(callback);
        token.setUserContext(userContext);
        token.internalTok.setTopics(topicFilters);
        this.comms.sendNoWait(new MqttSubscribe(topicFilters, qos), token);
        log.fine(CLASS_NAME, "subscribe", "109");
        return token;
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String topicFilter, Object userContext, IMqttActionListener callback) throws MqttException {
        return unsubscribe(new String[]{topicFilter}, userContext, callback);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String topicFilter) throws MqttException {
        return unsubscribe(new String[]{topicFilter}, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] topicFilters) throws MqttException {
        return unsubscribe(topicFilters, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] topicFilters, Object userContext, IMqttActionListener callback) throws MqttException {
        String subs = "";
        for (int i = 0; i < topicFilters.length; i++) {
            if (i > 0) {
                subs = String.valueOf(subs) + ", ";
            }
            subs = String.valueOf(subs) + topicFilters[i];
            MqttTopic.validate(topicFilters[i], true);
        }
        log.fine(CLASS_NAME, "unsubscribe", "107", new Object[]{subs, userContext, callback});
        MqttToken token = new MqttToken(getClientId());
        token.setActionCallback(callback);
        token.setUserContext(userContext);
        token.internalTok.setTopics(topicFilters);
        this.comms.sendNoWait(new MqttUnsubscribe(topicFilters), token);
        log.fine(CLASS_NAME, "unsubscribe", "110");
        return token;
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public void setCallback(MqttCallback callback) {
        this.comms.setCallback(callback);
    }

    public static String generateClientId() {
        return CLIENT_ID_PREFIX + System.nanoTime();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.comms.getPendingDeliveryTokens();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, byte[] payload, int qos, boolean retained, Object userContext, IMqttActionListener callback) throws MqttException, MqttPersistenceException {
        MqttMessage message = new MqttMessage(payload);
        message.setQos(qos);
        message.setRetained(retained);
        return publish(topic, message, userContext, callback);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, byte[] payload, int qos, boolean retained) throws MqttException, MqttPersistenceException {
        return publish(topic, payload, qos, retained, null, null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, MqttMessage message) throws MqttException, MqttPersistenceException {
        return publish(topic, message, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, MqttMessage message, Object userContext, IMqttActionListener callback) throws MqttException, MqttPersistenceException {
        log.fine(CLASS_NAME, "publish", "111", new Object[]{topic, userContext, callback});
        MqttTopic.validate(topic, false);
        MqttDeliveryToken token = new MqttDeliveryToken(getClientId());
        token.setActionCallback(callback);
        token.setUserContext(userContext);
        token.setMessage(message);
        token.internalTok.setTopics(new String[]{topic});
        this.comms.sendNoWait(new MqttPublish(topic, message), token);
        log.fine(CLASS_NAME, "publish", "112");
        return token;
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttAsyncClient
    public void close() throws MqttException {
        log.fine(CLASS_NAME, "close", "113");
        this.comms.close();
        log.fine(CLASS_NAME, "close", "114");
    }

    public Debug getDebug() {
        return new Debug(this.clientId, this.comms);
    }
}
