package com.tencent.cos.xml.transfer;

import android.util.Xml;
import com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult;
import com.tencent.cos.xml.model.tag.CosError;
import com.tencent.cos.xml.model.tag.InitiateMultipartUpload;
import com.tencent.cos.xml.model.tag.ListParts;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlSlimParser {
    public static void parseCompleteMultipartUploadResult(InputStream inputStream, CompleteMultipartUploadResult result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Location")) {
                        if (!tagName.equalsIgnoreCase("Bucket")) {
                            if (!tagName.equalsIgnoreCase("Key")) {
                                if (tagName.equalsIgnoreCase("ETag")) {
                                    xmlPullParser.next();
                                    result.eTag = xmlPullParser.getText();
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                result.key = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            result.bucket = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.location = xmlPullParser.getText();
                        break;
                    }
            }
        }
    }

    public static void parseInitiateMultipartUploadResult(InputStream inputStream, InitiateMultipartUpload result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Bucket")) {
                        if (!tagName.equalsIgnoreCase("Key")) {
                            if (tagName.equalsIgnoreCase("UploadId")) {
                                xmlPullParser.next();
                                result.uploadId = xmlPullParser.getText();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            result.key = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.bucket = xmlPullParser.getText();
                        break;
                    }
            }
        }
    }

    public static void parseListPartsResult(InputStream inputStream, ListParts result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        result.parts = new ArrayList();
        ListParts.Owner owner = null;
        ListParts.Initiator initiator = null;
        ListParts.Part part = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Bucket")) {
                        if (!tagName.equalsIgnoreCase("Encoding-type")) {
                            if (!tagName.equalsIgnoreCase("Key")) {
                                if (!tagName.equalsIgnoreCase("UploadId")) {
                                    if (!tagName.equalsIgnoreCase("Owner")) {
                                        if (!tagName.equalsIgnoreCase("Initiator")) {
                                            if (!tagName.equalsIgnoreCase("ID")) {
                                                if (!tagName.equalsIgnoreCase("DisplayName")) {
                                                    if (!tagName.equalsIgnoreCase("PartNumberMarker")) {
                                                        if (!tagName.equalsIgnoreCase("StorageClass")) {
                                                            if (!tagName.equalsIgnoreCase("NextPartNumberMarker")) {
                                                                if (!tagName.equalsIgnoreCase("MaxParts")) {
                                                                    if (!tagName.equalsIgnoreCase("IsTruncated")) {
                                                                        if (!tagName.equalsIgnoreCase("Part")) {
                                                                            if (!tagName.equalsIgnoreCase("PartNumber")) {
                                                                                if (!tagName.equalsIgnoreCase("LastModified")) {
                                                                                    if (!tagName.equalsIgnoreCase("ETag")) {
                                                                                        if (tagName.equalsIgnoreCase("Size")) {
                                                                                            xmlPullParser.next();
                                                                                            part.size = xmlPullParser.getText();
                                                                                            break;
                                                                                        } else {
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        xmlPullParser.next();
                                                                                        part.eTag = xmlPullParser.getText();
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    xmlPullParser.next();
                                                                                    part.lastModified = xmlPullParser.getText();
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                xmlPullParser.next();
                                                                                part.partNumber = xmlPullParser.getText();
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            part = new ListParts.Part();
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        xmlPullParser.next();
                                                                        result.isTruncated = Boolean.parseBoolean(xmlPullParser.getText());
                                                                        break;
                                                                    }
                                                                } else {
                                                                    xmlPullParser.next();
                                                                    result.maxParts = xmlPullParser.getText();
                                                                    break;
                                                                }
                                                            } else {
                                                                xmlPullParser.next();
                                                                result.nextPartNumberMarker = xmlPullParser.getText();
                                                                break;
                                                            }
                                                        } else {
                                                            xmlPullParser.next();
                                                            result.storageClass = xmlPullParser.getText();
                                                            break;
                                                        }
                                                    } else {
                                                        xmlPullParser.next();
                                                        result.partNumberMarker = xmlPullParser.getText();
                                                        break;
                                                    }
                                                } else {
                                                    xmlPullParser.next();
                                                    if (owner == null) {
                                                        if (initiator != null) {
                                                            initiator.disPlayName = xmlPullParser.getText();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        owner.disPlayName = xmlPullParser.getText();
                                                        break;
                                                    }
                                                }
                                            } else {
                                                xmlPullParser.next();
                                                if (owner == null) {
                                                    if (initiator != null) {
                                                        initiator.f3124id = xmlPullParser.getText();
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                } else {
                                                    owner.f3125id = xmlPullParser.getText();
                                                    break;
                                                }
                                            }
                                        } else {
                                            initiator = new ListParts.Initiator();
                                            break;
                                        }
                                    } else {
                                        owner = new ListParts.Owner();
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    result.uploadId = xmlPullParser.getText();
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                result.key = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            result.encodingType = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.bucket = xmlPullParser.getText();
                        break;
                    }
                case 3:
                    String tagName2 = xmlPullParser.getName();
                    if (!tagName2.equalsIgnoreCase("Owner")) {
                        if (!tagName2.equalsIgnoreCase("Initiator")) {
                            if (tagName2.equalsIgnoreCase("Part")) {
                                result.parts.add(part);
                                part = null;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            result.initiator = initiator;
                            initiator = null;
                            break;
                        }
                    } else {
                        result.owner = owner;
                        owner = null;
                        break;
                    }
            }
        }
    }

    public static void parseError(InputStream inputStream, CosError error) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Code")) {
                        if (!tagName.equalsIgnoreCase("Message")) {
                            if (!tagName.equalsIgnoreCase("Resource")) {
                                if (!tagName.equalsIgnoreCase("RequestId")) {
                                    if (tagName.equalsIgnoreCase("TraceId")) {
                                        xmlPullParser.next();
                                        error.traceId = xmlPullParser.getText();
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    error.requestId = xmlPullParser.getText();
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                error.resource = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            error.message = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        error.code = xmlPullParser.getText();
                        break;
                    }
            }
        }
    }
}
