package org.pwrd.paho.client.mqttv3.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleCatalog extends MessageCatalog {
    private ResourceBundle bundle = ResourceBundle.getBundle("org.pwrd.paho.client.mqttv3.internal.nls.messages");

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.MessageCatalog
    public String getLocalizedMessage(int id) {
        try {
            return this.bundle.getString(Integer.toString(id));
        } catch (MissingResourceException e) {
            return "MqttException";
        }
    }
}
