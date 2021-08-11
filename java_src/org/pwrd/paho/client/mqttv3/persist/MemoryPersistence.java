package org.pwrd.paho.client.mqttv3.persist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.pwrd.paho.client.mqttv3.MqttClientPersistence;
import org.pwrd.paho.client.mqttv3.MqttPersistable;
import org.pwrd.paho.client.mqttv3.MqttPersistenceException;

public class MemoryPersistence implements MqttClientPersistence {
    private Hashtable data;

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void close() throws MqttPersistenceException {
        this.data.clear();
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public Enumeration keys() throws MqttPersistenceException {
        return this.data.keys();
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public MqttPersistable get(String key) throws MqttPersistenceException {
        return (MqttPersistable) this.data.get(key);
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void open(String clientId, String serverURI) throws MqttPersistenceException {
        this.data = new Hashtable();
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void put(String key, MqttPersistable persistable) throws MqttPersistenceException {
        this.data.put(key, persistable);
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void remove(String key) throws MqttPersistenceException {
        this.data.remove(key);
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void clear() throws MqttPersistenceException {
        this.data.clear();
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public boolean containsKey(String key) throws MqttPersistenceException {
        return this.data.containsKey(key);
    }
}
