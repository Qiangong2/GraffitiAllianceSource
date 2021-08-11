package org.pwrd.paho.client.mqttv3;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;
import org.pwrd.paho.client.mqttv3.util.Debug;

public class MqttConnectOptions {
    public static final boolean CLEAN_SESSION_DEFAULT = true;
    public static final int CONNECTION_TIMEOUT_DEFAULT = 30;
    public static final int KEEP_ALIVE_INTERVAL_DEFAULT = 60;
    public static final int MQTT_VERSION_3_1 = 3;
    public static final int MQTT_VERSION_3_1_1 = 4;
    public static final int MQTT_VERSION_DEFAULT = 0;
    protected static final int URI_TYPE_LOCAL = 2;
    protected static final int URI_TYPE_SSL = 1;
    protected static final int URI_TYPE_TCP = 0;
    private int MqttVersion = 0;
    private boolean cleanSession = true;
    private int connectionTimeout = 30;
    private int keepAliveInterval = 60;
    private char[] password;
    private String[] serverURIs = null;
    private SocketFactory socketFactory;
    private Properties sslClientProps = null;
    private String userName;
    private String willDestination = null;
    private MqttMessage willMessage = null;

    public char[] getPassword() {
        return this.password;
    }

    public void setPassword(char[] password2) {
        this.password = password2;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName2) {
        if (userName2 == null || !userName2.trim().equals("")) {
            this.userName = userName2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setWill(MqttTopic topic, byte[] payload, int qos, boolean retained) {
        String topicS = topic.getName();
        validateWill(topicS, payload);
        setWill(topicS, new MqttMessage(payload), qos, retained);
    }

    public void setWill(String topic, byte[] payload, int qos, boolean retained) {
        validateWill(topic, payload);
        setWill(topic, new MqttMessage(payload), qos, retained);
    }

    private void validateWill(String dest, Object payload) {
        if (dest == null || payload == null) {
            throw new IllegalArgumentException();
        }
        MqttTopic.validate(dest, false);
    }

    /* access modifiers changed from: protected */
    public void setWill(String topic, MqttMessage msg, int qos, boolean retained) {
        this.willDestination = topic;
        this.willMessage = msg;
        this.willMessage.setQos(qos);
        this.willMessage.setRetained(retained);
        this.willMessage.setMutable(false);
    }

    public int getKeepAliveInterval() {
        return this.keepAliveInterval;
    }

    public int getMqttVersion() {
        return this.MqttVersion;
    }

    public void setKeepAliveInterval(int keepAliveInterval2) throws IllegalArgumentException {
        if (keepAliveInterval2 < 0) {
            throw new IllegalArgumentException();
        }
        this.keepAliveInterval = keepAliveInterval2;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout2) {
        if (connectionTimeout2 < 0) {
            throw new IllegalArgumentException();
        }
        this.connectionTimeout = connectionTimeout2;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public void setSocketFactory(SocketFactory socketFactory2) {
        this.socketFactory = socketFactory2;
    }

    public String getWillDestination() {
        return this.willDestination;
    }

    public MqttMessage getWillMessage() {
        return this.willMessage;
    }

    public Properties getSSLProperties() {
        return this.sslClientProps;
    }

    public void setSSLProperties(Properties props) {
        this.sslClientProps = props;
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    public void setCleanSession(boolean cleanSession2) {
        this.cleanSession = cleanSession2;
    }

    public String[] getServerURIs() {
        return this.serverURIs;
    }

    public void setServerURIs(String[] array) {
        for (String str : array) {
            validateURI(str);
        }
        this.serverURIs = array;
    }

    protected static int validateURI(String srvURI) {
        try {
            URI vURI = new URI(srvURI);
            if (!vURI.getPath().equals("")) {
                throw new IllegalArgumentException(srvURI);
            } else if (vURI.getScheme().equals("tcp")) {
                return 0;
            } else {
                if (vURI.getScheme().equals("ssl")) {
                    return 1;
                }
                if (vURI.getScheme().equals("local")) {
                    return 2;
                }
                throw new IllegalArgumentException(srvURI);
            }
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(srvURI);
        }
    }

    public void setMqttVersion(int MqttVersion2) throws IllegalArgumentException {
        if (MqttVersion2 == 0 || MqttVersion2 == 3 || MqttVersion2 == 4) {
            this.MqttVersion = MqttVersion2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public Properties getDebug() {
        Properties p = new Properties();
        p.put("MqttVersion", new Integer(getMqttVersion()));
        p.put("CleanSession", Boolean.valueOf(isCleanSession()));
        p.put("ConTimeout", new Integer(getConnectionTimeout()));
        p.put("KeepAliveInterval", new Integer(getKeepAliveInterval()));
        p.put("UserName", getUserName() == null ? "null" : getUserName());
        p.put("WillDestination", getWillDestination() == null ? "null" : getWillDestination());
        if (getSocketFactory() == null) {
            p.put("SocketFactory", "null");
        } else {
            p.put("SocketFactory", getSocketFactory());
        }
        if (getSSLProperties() == null) {
            p.put("SSLProperties", "null");
        } else {
            p.put("SSLProperties", getSSLProperties());
        }
        return p;
    }

    public String toString() {
        return Debug.dumpProperties(getDebug(), "Connection options");
    }
}
