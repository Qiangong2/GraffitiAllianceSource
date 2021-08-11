package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.Delete;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.MqttTopic;
import org.xmlpull.v1.XmlPullParserException;

public final class DeleteMultiObjectRequest extends ObjectRequest {
    private Delete delete = new Delete();

    public DeleteMultiObjectRequest(String bucket, List<String> deleteObjectList) {
        super(bucket, null);
        this.delete.deleteObjects = new ArrayList();
        setObjectList(deleteObjectList);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("delete", null);
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildDelete(this.delete));
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null");
        }
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath() {
        return MqttTopic.TOPIC_LEVEL_SEPARATOR;
    }

    public void setQuiet(boolean quiet) {
        this.delete.quiet = quiet;
    }

    public void setObjectList(String object) {
        if (object != null) {
            if (object.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                object = object.substring(1);
            }
            Delete.DeleteObject deleteObject = new Delete.DeleteObject();
            deleteObject.key = object;
            this.delete.deleteObjects.add(deleteObject);
        }
    }

    public void setObjectList(String object, String versionId) {
        if (object != null) {
            if (object.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                object = object.substring(1);
            }
            Delete.DeleteObject deleteObject = new Delete.DeleteObject();
            deleteObject.key = object;
            if (versionId != null) {
                deleteObject.versionId = versionId;
            }
            this.delete.deleteObjects.add(deleteObject);
        }
    }

    public void setObjectList(List<String> objectList) {
        if (objectList != null) {
            int size = objectList.size();
            for (int i = 0; i < size; i++) {
                Delete.DeleteObject deleteObject = new Delete.DeleteObject();
                String object = objectList.get(i);
                if (object.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                    deleteObject.key = object.substring(1);
                } else {
                    deleteObject.key = object;
                }
                this.delete.deleteObjects.add(deleteObject);
            }
        }
    }

    public void setObjectList(Map<String, String> objectListWithVersionId) {
        if (objectListWithVersionId != null) {
            for (Map.Entry<String, String> entry : objectListWithVersionId.entrySet()) {
                Delete.DeleteObject deleteObject = new Delete.DeleteObject();
                String object = entry.getKey();
                String versionId = entry.getValue();
                if (object.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                    deleteObject.key = object.substring(1);
                } else {
                    deleteObject.key = object;
                }
                if (versionId != null) {
                    deleteObject.versionId = versionId;
                }
                this.delete.deleteObjects.add(deleteObject);
            }
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean isNeedMD5() {
        return true;
    }

    public Delete getDelete() {
        return this.delete;
    }
}
