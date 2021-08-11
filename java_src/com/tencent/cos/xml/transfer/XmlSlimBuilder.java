package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.model.tag.CompleteMultipartUpload;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class XmlSlimBuilder {
    public static String buildCompleteMultipartUpload(CompleteMultipartUpload completeMultipartUpload) throws IOException, XmlPullParserException {
        if (completeMultipartUpload == null) {
            return null;
        }
        StringWriter xmlContent = new StringWriter();
        XmlSerializer xmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        xmlSerializer.setOutput(xmlContent);
        xmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        xmlSerializer.startDocument("UTF-8", null);
        xmlSerializer.startTag("", "CompleteMultipartUpload");
        if (completeMultipartUpload.parts != null) {
            for (CompleteMultipartUpload.Part part : completeMultipartUpload.parts) {
                if (part != null) {
                    xmlSerializer.startTag("", "Part");
                    addElement(xmlSerializer, "PartNumber", String.valueOf(part.partNumber));
                    addElement(xmlSerializer, "ETag", part.eTag);
                    xmlSerializer.endTag("", "Part");
                }
            }
        }
        xmlSerializer.endTag("", "CompleteMultipartUpload");
        xmlSerializer.endDocument();
        return removeXMLHeader(xmlContent.toString());
    }

    private static void addElement(XmlSerializer xmlSerializer, String tag, String value) throws IOException {
        if (value != null) {
            xmlSerializer.startTag("", tag);
            xmlSerializer.text(value);
            xmlSerializer.endTag("", tag);
        }
    }

    private static String removeXMLHeader(String xmlContent) {
        if (xmlContent == null || !xmlContent.startsWith("<?xml")) {
            return xmlContent;
        }
        return xmlContent.substring(xmlContent.indexOf("?>") + 2);
    }
}
