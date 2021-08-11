package com.tencent.cos.xml.transfer;

import android.util.Xml;
import com.tencent.cos.xml.model.tag.AccessControlPolicy;
import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.model.tag.CopyObject;
import com.tencent.cos.xml.model.tag.CopyPart;
import com.tencent.cos.xml.model.tag.DeleteResult;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.model.tag.ListAllMyBuckets;
import com.tencent.cos.xml.model.tag.ListBucket;
import com.tencent.cos.xml.model.tag.ListBucketVersions;
import com.tencent.cos.xml.model.tag.ListMultipartUploads;
import com.tencent.cos.xml.model.tag.LocationConstraint;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.model.tag.VersioningConfiguration;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlParser extends XmlSlimParser {
    public static void parseListAllMyBucketsResult(InputStream inputStream, ListAllMyBuckets result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        ListAllMyBuckets.Bucket bucket = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Owner")) {
                        if (!tagName.equalsIgnoreCase("ID")) {
                            if (!tagName.equalsIgnoreCase("DisplayName")) {
                                if (!tagName.equalsIgnoreCase("Buckets")) {
                                    if (!tagName.equalsIgnoreCase("Bucket")) {
                                        if (!tagName.equalsIgnoreCase("Name")) {
                                            if (!tagName.equalsIgnoreCase("Location")) {
                                                if (tagName.equalsIgnoreCase("CreationDate")) {
                                                    xmlPullParser.next();
                                                    bucket.createDate = xmlPullParser.getText();
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                xmlPullParser.next();
                                                bucket.location = xmlPullParser.getText();
                                                break;
                                            }
                                        } else {
                                            xmlPullParser.next();
                                            bucket.name = xmlPullParser.getText();
                                            break;
                                        }
                                    } else {
                                        bucket = new ListAllMyBuckets.Bucket();
                                        break;
                                    }
                                } else {
                                    result.buckets = new ArrayList();
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                result.owner.disPlayName = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            result.owner.f3120id = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        result.owner = new ListAllMyBuckets.Owner();
                        break;
                    }
                case 3:
                    if (xmlPullParser.getName().equalsIgnoreCase("Bucket")) {
                        result.buckets.add(bucket);
                        bucket = null;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    public static void parseListBucketResult(InputStream inputStream, ListBucket result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        ListBucket.Contents contents = null;
        ListBucket.CommonPrefixes commonPrefixes = null;
        ListBucket.Owner owner = null;
        result.contentsList = new ArrayList();
        result.commonPrefixesList = new ArrayList();
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Name")) {
                        if (!tagName.equalsIgnoreCase("Encoding-Type")) {
                            if (!tagName.equalsIgnoreCase("Marker")) {
                                if (!tagName.equalsIgnoreCase("MaxKeys")) {
                                    if (!tagName.equalsIgnoreCase("Delimiter")) {
                                        if (!tagName.equalsIgnoreCase("NextMarker")) {
                                            if (!tagName.equalsIgnoreCase("IsTruncated")) {
                                                if (!tagName.equalsIgnoreCase("Prefix")) {
                                                    if (!tagName.equalsIgnoreCase("Contents")) {
                                                        if (!tagName.equalsIgnoreCase("Key")) {
                                                            if (!tagName.equalsIgnoreCase("LastModified")) {
                                                                if (!tagName.equalsIgnoreCase("ETag")) {
                                                                    if (!tagName.equalsIgnoreCase("Size")) {
                                                                        if (!tagName.equalsIgnoreCase("StorageClass")) {
                                                                            if (!tagName.equalsIgnoreCase("Owner")) {
                                                                                if (!tagName.equalsIgnoreCase("ID")) {
                                                                                    if (tagName.equalsIgnoreCase("CommonPrefixes")) {
                                                                                        commonPrefixes = new ListBucket.CommonPrefixes();
                                                                                        break;
                                                                                    } else {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    xmlPullParser.next();
                                                                                    owner.f3121id = xmlPullParser.getText();
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                owner = new ListBucket.Owner();
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            xmlPullParser.next();
                                                                            contents.storageClass = xmlPullParser.getText();
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        xmlPullParser.next();
                                                                        contents.size = Long.parseLong(xmlPullParser.getText());
                                                                        break;
                                                                    }
                                                                } else {
                                                                    xmlPullParser.next();
                                                                    contents.eTag = xmlPullParser.getText();
                                                                    break;
                                                                }
                                                            } else {
                                                                xmlPullParser.next();
                                                                contents.lastModified = xmlPullParser.getText();
                                                                break;
                                                            }
                                                        } else {
                                                            xmlPullParser.next();
                                                            contents.key = xmlPullParser.getText();
                                                            break;
                                                        }
                                                    } else {
                                                        contents = new ListBucket.Contents();
                                                        break;
                                                    }
                                                } else {
                                                    xmlPullParser.next();
                                                    if (commonPrefixes == null) {
                                                        result.prefix = xmlPullParser.getText();
                                                        break;
                                                    } else {
                                                        commonPrefixes.prefix = xmlPullParser.getText();
                                                        break;
                                                    }
                                                }
                                            } else {
                                                xmlPullParser.next();
                                                result.isTruncated = Boolean.parseBoolean(xmlPullParser.getText());
                                                break;
                                            }
                                        } else {
                                            xmlPullParser.next();
                                            result.nextMarker = xmlPullParser.getText();
                                            break;
                                        }
                                    } else {
                                        xmlPullParser.next();
                                        result.delimiter = xmlPullParser.getText();
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    result.maxKeys = Integer.parseInt(xmlPullParser.getText());
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                result.marker = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            result.encodingType = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.name = xmlPullParser.getText();
                        break;
                    }
                case 3:
                    String tagName2 = xmlPullParser.getName();
                    if (!tagName2.equalsIgnoreCase("Contents")) {
                        if (!tagName2.equalsIgnoreCase("Owner")) {
                            if (tagName2.equalsIgnoreCase("CommonPrefixes")) {
                                result.commonPrefixesList.add(commonPrefixes);
                                commonPrefixes = null;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            contents.owner = owner;
                            owner = null;
                            break;
                        }
                    } else {
                        result.contentsList.add(contents);
                        contents = null;
                        break;
                    }
            }
        }
    }

    public static void parseAccessControlPolicy(InputStream inputStream, AccessControlPolicy result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        AccessControlPolicy.Owner owner = null;
        result.accessControlList = new AccessControlPolicy.AccessControlList();
        result.accessControlList.grants = new ArrayList();
        AccessControlPolicy.Grant grant = null;
        AccessControlPolicy.Grantee grantee = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Owner")) {
                        if (!tagName.equalsIgnoreCase("ID")) {
                            if (!tagName.equalsIgnoreCase("DisplayName")) {
                                if (!tagName.equalsIgnoreCase("Grant")) {
                                    if (!tagName.equalsIgnoreCase("Grantee")) {
                                        if (tagName.equalsIgnoreCase("Permission")) {
                                            xmlPullParser.next();
                                            grant.permission = xmlPullParser.getText();
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        grantee = new AccessControlPolicy.Grantee();
                                        break;
                                    }
                                } else {
                                    grant = new AccessControlPolicy.Grant();
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                if (owner == null) {
                                    if (grantee != null) {
                                        grantee.displayName = xmlPullParser.getText();
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    owner.displayName = xmlPullParser.getText();
                                    break;
                                }
                            }
                        } else {
                            xmlPullParser.next();
                            if (owner == null) {
                                if (grantee != null) {
                                    grantee.f3116id = xmlPullParser.getText();
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                owner.f3117id = xmlPullParser.getText();
                                break;
                            }
                        }
                    } else {
                        owner = new AccessControlPolicy.Owner();
                        break;
                    }
                case 3:
                    String tagName2 = xmlPullParser.getName();
                    if (!tagName2.equalsIgnoreCase("Owner")) {
                        if (!tagName2.equalsIgnoreCase("Grant")) {
                            if (tagName2.equalsIgnoreCase("Grantee")) {
                                grant.grantee = grantee;
                                grantee = null;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            result.accessControlList.grants.add(grant);
                            grant = null;
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

    public static void parseCORSConfiguration(InputStream inputStream, CORSConfiguration result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        result.corsRules = new ArrayList();
        CORSConfiguration.CORSRule corsRule = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("CORSRule")) {
                        if (!tagName.equalsIgnoreCase("ID")) {
                            if (!tagName.equalsIgnoreCase("AllowedOrigin")) {
                                if (!tagName.equalsIgnoreCase("AllowedMethod")) {
                                    if (!tagName.equalsIgnoreCase("AllowedHeader")) {
                                        if (!tagName.equalsIgnoreCase("ExposeHeader")) {
                                            if (tagName.equalsIgnoreCase("MaxAgeSeconds")) {
                                                xmlPullParser.next();
                                                corsRule.maxAgeSeconds = Integer.parseInt(xmlPullParser.getText());
                                                break;
                                            } else {
                                                break;
                                            }
                                        } else {
                                            xmlPullParser.next();
                                            if (corsRule.exposeHeader == null) {
                                                corsRule.exposeHeader = new ArrayList();
                                            }
                                            corsRule.exposeHeader.add(xmlPullParser.getText());
                                            break;
                                        }
                                    } else {
                                        xmlPullParser.next();
                                        if (corsRule.allowedHeader == null) {
                                            corsRule.allowedHeader = new ArrayList();
                                        }
                                        corsRule.allowedHeader.add(xmlPullParser.getText());
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    if (corsRule.allowedMethod == null) {
                                        corsRule.allowedMethod = new ArrayList();
                                    }
                                    corsRule.allowedMethod.add(xmlPullParser.getText());
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                corsRule.allowedOrigin = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            corsRule.f3118id = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        corsRule = new CORSConfiguration.CORSRule();
                        break;
                    }
                case 3:
                    if (xmlPullParser.getName().equalsIgnoreCase("CORSRule")) {
                        result.corsRules.add(corsRule);
                        corsRule = null;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    public static void parseReplicationConfiguration(InputStream inputStream, ReplicationConfiguration result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        result.rules = new ArrayList();
        ReplicationConfiguration.Rule rule = null;
        ReplicationConfiguration.Destination destination = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Role")) {
                        if (!tagName.equalsIgnoreCase("Rule")) {
                            if (!tagName.equalsIgnoreCase("Status")) {
                                if (!tagName.equalsIgnoreCase("ID")) {
                                    if (!tagName.equalsIgnoreCase("Prefix")) {
                                        if (!tagName.equalsIgnoreCase("Destination")) {
                                            if (!tagName.equalsIgnoreCase("Bucket")) {
                                                if (tagName.equalsIgnoreCase("StorageClass")) {
                                                    xmlPullParser.next();
                                                    destination.storageClass = xmlPullParser.getText();
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                xmlPullParser.next();
                                                destination.bucket = xmlPullParser.getText();
                                                break;
                                            }
                                        } else {
                                            destination = new ReplicationConfiguration.Destination();
                                            break;
                                        }
                                    } else {
                                        xmlPullParser.next();
                                        rule.prefix = xmlPullParser.getText();
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    rule.f3126id = xmlPullParser.getText();
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                rule.status = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            rule = new ReplicationConfiguration.Rule();
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.role = xmlPullParser.getText();
                        break;
                    }
                case 3:
                    String tagName2 = xmlPullParser.getName();
                    if (!tagName2.equalsIgnoreCase("Rule")) {
                        if (tagName2.equalsIgnoreCase("Destination")) {
                            rule.destination = destination;
                            destination = null;
                            break;
                        } else {
                            break;
                        }
                    } else {
                        result.rules.add(rule);
                        rule = null;
                        break;
                    }
            }
        }
    }

    public static void parseVersioningConfiguration(InputStream inputStream, VersioningConfiguration result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    if (xmlPullParser.getName().equalsIgnoreCase("Status")) {
                        xmlPullParser.next();
                        result.status = xmlPullParser.getText();
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    public static void parseLifecycleConfiguration(InputStream inputStream, LifecycleConfiguration result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        result.rules = new ArrayList();
        LifecycleConfiguration.Rule rule = null;
        LifecycleConfiguration.Filter filter = null;
        LifecycleConfiguration.Transition transition = null;
        LifecycleConfiguration.Expiration expiration = null;
        LifecycleConfiguration.AbortIncompleteMultiUpload abortIncompleteMultiUpload = null;
        LifecycleConfiguration.NoncurrentVersionExpiration noncurrentVersionExpiration = null;
        LifecycleConfiguration.NoncurrentVersionTransition noncurrentVersionTransition = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Rule")) {
                        if (!tagName.equalsIgnoreCase("ID")) {
                            if (!tagName.equalsIgnoreCase("Filter")) {
                                if (!tagName.equalsIgnoreCase("Prefix")) {
                                    if (!tagName.equalsIgnoreCase("Status")) {
                                        if (!tagName.equalsIgnoreCase("Transition")) {
                                            if (!tagName.equalsIgnoreCase("Expiration")) {
                                                if (!tagName.equalsIgnoreCase("Days")) {
                                                    if (!tagName.equalsIgnoreCase(HttpConstants.Header.DATE)) {
                                                        if (!tagName.equalsIgnoreCase("ExpiredObjectDeleteMarker")) {
                                                            if (!tagName.equalsIgnoreCase("AbortIncompleteMultipartUpload")) {
                                                                if (!tagName.equalsIgnoreCase("DaysAfterInitiation")) {
                                                                    if (!tagName.equalsIgnoreCase("NoncurrentVersionExpiration")) {
                                                                        if (!tagName.equalsIgnoreCase("NoncurrentVersionTransition")) {
                                                                            if (!tagName.equalsIgnoreCase("NoncurrentDays")) {
                                                                                if (tagName.equalsIgnoreCase("StorageClass")) {
                                                                                    xmlPullParser.next();
                                                                                    if (transition == null) {
                                                                                        if (noncurrentVersionTransition != null) {
                                                                                            noncurrentVersionTransition.storageClass = xmlPullParser.getText();
                                                                                            break;
                                                                                        } else {
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        transition.storageClass = xmlPullParser.getText();
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                xmlPullParser.next();
                                                                                if (noncurrentVersionExpiration == null) {
                                                                                    if (noncurrentVersionTransition != null) {
                                                                                        noncurrentVersionTransition.noncurrentDays = Integer.parseInt(xmlPullParser.getText());
                                                                                        break;
                                                                                    } else {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    noncurrentVersionExpiration.noncurrentDays = Integer.parseInt(xmlPullParser.getText());
                                                                                    break;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            noncurrentVersionTransition = new LifecycleConfiguration.NoncurrentVersionTransition();
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        noncurrentVersionExpiration = new LifecycleConfiguration.NoncurrentVersionExpiration();
                                                                        break;
                                                                    }
                                                                } else {
                                                                    xmlPullParser.next();
                                                                    abortIncompleteMultiUpload.daysAfterInitiation = Integer.parseInt(xmlPullParser.getText());
                                                                    break;
                                                                }
                                                            } else {
                                                                abortIncompleteMultiUpload = new LifecycleConfiguration.AbortIncompleteMultiUpload();
                                                                break;
                                                            }
                                                        } else {
                                                            xmlPullParser.next();
                                                            expiration.expiredObjectDeleteMarker = xmlPullParser.getText();
                                                            break;
                                                        }
                                                    } else {
                                                        xmlPullParser.next();
                                                        if (transition == null) {
                                                            if (expiration != null) {
                                                                expiration.date = xmlPullParser.getText();
                                                                break;
                                                            } else {
                                                                break;
                                                            }
                                                        } else {
                                                            transition.date = xmlPullParser.getText();
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    xmlPullParser.next();
                                                    if (transition == null) {
                                                        if (rule.expiration != null) {
                                                            expiration.days = Integer.parseInt(xmlPullParser.getText());
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        transition.days = Integer.parseInt(xmlPullParser.getText());
                                                        break;
                                                    }
                                                }
                                            } else {
                                                expiration = new LifecycleConfiguration.Expiration();
                                                break;
                                            }
                                        } else {
                                            transition = new LifecycleConfiguration.Transition();
                                            break;
                                        }
                                    } else {
                                        xmlPullParser.next();
                                        rule.status = xmlPullParser.getText();
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    filter.prefix = xmlPullParser.getText();
                                    break;
                                }
                            } else {
                                filter = new LifecycleConfiguration.Filter();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            rule.f3119id = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        rule = new LifecycleConfiguration.Rule();
                        break;
                    }
                case 3:
                    String tagName2 = xmlPullParser.getName();
                    if (!tagName2.equalsIgnoreCase("Rule")) {
                        if (!tagName2.equalsIgnoreCase("Filter")) {
                            if (!tagName2.equalsIgnoreCase("Transition")) {
                                if (!tagName2.equalsIgnoreCase("NoncurrentVersionExpiration")) {
                                    if (!tagName2.equalsIgnoreCase("NoncurrentVersionTransition")) {
                                        if (!tagName2.equalsIgnoreCase("Expiration")) {
                                            if (tagName2.equalsIgnoreCase("AbortIncompleteMultipartUpload")) {
                                                rule.abortIncompleteMultiUpload = abortIncompleteMultiUpload;
                                                abortIncompleteMultiUpload = null;
                                                break;
                                            } else {
                                                break;
                                            }
                                        } else {
                                            rule.expiration = expiration;
                                            expiration = null;
                                            break;
                                        }
                                    } else {
                                        rule.noncurrentVersionTransition = noncurrentVersionTransition;
                                        noncurrentVersionTransition = null;
                                        break;
                                    }
                                } else {
                                    rule.noncurrentVersionExpiration = noncurrentVersionExpiration;
                                    noncurrentVersionExpiration = null;
                                    break;
                                }
                            } else {
                                rule.transition = transition;
                                transition = null;
                                break;
                            }
                        } else {
                            rule.filter = filter;
                            filter = null;
                            break;
                        }
                    } else {
                        result.rules.add(rule);
                        rule = null;
                        break;
                    }
            }
        }
    }

    public static void parseLocationConstraint(InputStream inputStream, LocationConstraint result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    if (xmlPullParser.getName().equalsIgnoreCase("LocationConstraint")) {
                        xmlPullParser.next();
                        result.location = xmlPullParser.getText();
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    public static void parseListMultipartUploadsResult(InputStream inputStream, ListMultipartUploads result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        ListMultipartUploads.CommonPrefixes commonPrefixes = null;
        ListMultipartUploads.Upload upload = null;
        result.uploads = new ArrayList();
        result.commonPrefixes = new ArrayList();
        ListMultipartUploads.Initiator initiator = null;
        ListMultipartUploads.Owner owner = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Bucket")) {
                        if (!tagName.equalsIgnoreCase("Encoding-Type")) {
                            if (!tagName.equalsIgnoreCase("KeyMarker")) {
                                if (!tagName.equalsIgnoreCase("UploadIdMarker")) {
                                    if (!tagName.equalsIgnoreCase("NextKeyMarker")) {
                                        if (!tagName.equalsIgnoreCase("NextUploadIdMarker")) {
                                            if (!tagName.equalsIgnoreCase("MaxUploads")) {
                                                if (!tagName.equalsIgnoreCase("IsTruncated")) {
                                                    if (!tagName.equalsIgnoreCase("Prefix")) {
                                                        if (!tagName.equalsIgnoreCase("Delimiter")) {
                                                            if (!tagName.equalsIgnoreCase("Upload")) {
                                                                if (!tagName.equalsIgnoreCase("Key")) {
                                                                    if (!tagName.equalsIgnoreCase("UploadID")) {
                                                                        if (!tagName.equalsIgnoreCase("StorageClass")) {
                                                                            if (!tagName.equalsIgnoreCase("Initiator")) {
                                                                                if (!tagName.equalsIgnoreCase("UIN")) {
                                                                                    if (!tagName.equalsIgnoreCase("Owner")) {
                                                                                        if (!tagName.equalsIgnoreCase("UID")) {
                                                                                            if (!tagName.equalsIgnoreCase("ID")) {
                                                                                                if (!tagName.equalsIgnoreCase("DisplayName")) {
                                                                                                    if (!tagName.equalsIgnoreCase("Initiated")) {
                                                                                                        if (tagName.equalsIgnoreCase("CommonPrefixs")) {
                                                                                                            commonPrefixes = new ListMultipartUploads.CommonPrefixes();
                                                                                                            break;
                                                                                                        } else {
                                                                                                            break;
                                                                                                        }
                                                                                                    } else {
                                                                                                        xmlPullParser.next();
                                                                                                        upload.initiated = xmlPullParser.getText();
                                                                                                        break;
                                                                                                    }
                                                                                                } else {
                                                                                                    xmlPullParser.next();
                                                                                                    if (owner == null) {
                                                                                                        if (initiator != null) {
                                                                                                            initiator.displayName = xmlPullParser.getText();
                                                                                                            break;
                                                                                                        } else {
                                                                                                            break;
                                                                                                        }
                                                                                                    } else {
                                                                                                        owner.displayName = xmlPullParser.getText();
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                xmlPullParser.next();
                                                                                                if (owner == null) {
                                                                                                    if (initiator != null) {
                                                                                                        initiator.f3122id = xmlPullParser.getText();
                                                                                                        break;
                                                                                                    } else {
                                                                                                        break;
                                                                                                    }
                                                                                                } else {
                                                                                                    owner.f3123id = xmlPullParser.getText();
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            xmlPullParser.next();
                                                                                            if (owner != null) {
                                                                                                owner.uid = xmlPullParser.getText();
                                                                                                break;
                                                                                            } else {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        owner = new ListMultipartUploads.Owner();
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    xmlPullParser.next();
                                                                                    if (initiator != null) {
                                                                                        initiator.uin = xmlPullParser.getText();
                                                                                        break;
                                                                                    } else {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                initiator = new ListMultipartUploads.Initiator();
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            xmlPullParser.next();
                                                                            upload.storageClass = xmlPullParser.getText();
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        xmlPullParser.next();
                                                                        upload.uploadID = xmlPullParser.getText();
                                                                        break;
                                                                    }
                                                                } else {
                                                                    xmlPullParser.next();
                                                                    upload.key = xmlPullParser.getText();
                                                                    break;
                                                                }
                                                            } else {
                                                                upload = new ListMultipartUploads.Upload();
                                                                break;
                                                            }
                                                        } else {
                                                            xmlPullParser.next();
                                                            result.delimiter = xmlPullParser.getText();
                                                            break;
                                                        }
                                                    } else {
                                                        xmlPullParser.next();
                                                        if (commonPrefixes == null) {
                                                            result.prefix = xmlPullParser.getText();
                                                            break;
                                                        } else {
                                                            commonPrefixes.prefix = xmlPullParser.getText();
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    xmlPullParser.next();
                                                    result.isTruncated = Boolean.parseBoolean(xmlPullParser.getText());
                                                    break;
                                                }
                                            } else {
                                                xmlPullParser.next();
                                                result.maxUploads = xmlPullParser.getText();
                                                break;
                                            }
                                        } else {
                                            xmlPullParser.next();
                                            result.nextUploadIdMarker = xmlPullParser.getText();
                                            break;
                                        }
                                    } else {
                                        xmlPullParser.next();
                                        result.nextKeyMarker = xmlPullParser.getText();
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    result.uploadIdMarker = xmlPullParser.getText();
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                result.keyMarker = xmlPullParser.getText();
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
                    if (!tagName2.equalsIgnoreCase("Upload")) {
                        if (!tagName2.equalsIgnoreCase("CommonPrefixs")) {
                            if (!tagName2.equalsIgnoreCase("Owner")) {
                                if (tagName2.equalsIgnoreCase("Initiator")) {
                                    upload.initiator = initiator;
                                    initiator = null;
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                upload.owner = owner;
                                owner = null;
                                break;
                            }
                        } else {
                            result.commonPrefixes.add(commonPrefixes);
                            commonPrefixes = null;
                            break;
                        }
                    } else {
                        result.uploads.add(upload);
                        upload = null;
                        break;
                    }
            }
        }
    }

    public static void parseDeleteResult(InputStream inputStream, DeleteResult result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        result.errorList = new ArrayList();
        result.deletedList = new ArrayList();
        DeleteResult.Deleted deleted = null;
        DeleteResult.Error error = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Deleted")) {
                        if (!tagName.equalsIgnoreCase("Error")) {
                            if (!tagName.equalsIgnoreCase("Key")) {
                                if (!tagName.equalsIgnoreCase("VersionId")) {
                                    if (!tagName.equalsIgnoreCase("DeleteMarker")) {
                                        if (!tagName.equalsIgnoreCase("DeleteMarkerVersionId")) {
                                            if (tagName.equalsIgnoreCase("Message")) {
                                                xmlPullParser.next();
                                                error.message = xmlPullParser.getText();
                                                break;
                                            } else {
                                                break;
                                            }
                                        } else {
                                            xmlPullParser.next();
                                            deleted.deleteMarkerVersionId = xmlPullParser.getText();
                                            break;
                                        }
                                    } else {
                                        xmlPullParser.next();
                                        deleted.deleteMarker = Boolean.parseBoolean(xmlPullParser.getText());
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    if (deleted == null) {
                                        if (error != null) {
                                            error.versionId = xmlPullParser.getText();
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        deleted.versionId = xmlPullParser.getText();
                                        break;
                                    }
                                }
                            } else {
                                xmlPullParser.next();
                                if (deleted == null) {
                                    if (error != null) {
                                        error.key = xmlPullParser.getText();
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    deleted.key = xmlPullParser.getText();
                                    break;
                                }
                            }
                        } else {
                            error = new DeleteResult.Error();
                            break;
                        }
                    } else {
                        deleted = new DeleteResult.Deleted();
                        break;
                    }
                case 3:
                    String tagName2 = xmlPullParser.getName();
                    if (!tagName2.equalsIgnoreCase("Deleted")) {
                        if (tagName2.equalsIgnoreCase("CosError")) {
                            result.errorList.add(error);
                            error = null;
                            break;
                        } else {
                            break;
                        }
                    } else {
                        result.deletedList.add(deleted);
                        deleted = null;
                        break;
                    }
            }
        }
    }

    public static void parseCopyObjectResult(InputStream inputStream, CopyObject result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("ETag")) {
                        if (tagName.equalsIgnoreCase("LastModified")) {
                            xmlPullParser.next();
                            result.lastModified = xmlPullParser.getText();
                            break;
                        } else {
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.eTag = xmlPullParser.getText();
                        break;
                    }
            }
        }
    }

    public static void parseCopyPartResult(InputStream inputStream, CopyPart result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("ETag")) {
                        if (tagName.equalsIgnoreCase("LastModified")) {
                            xmlPullParser.next();
                            result.lastModified = xmlPullParser.getText();
                            break;
                        } else {
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.eTag = xmlPullParser.getText();
                        break;
                    }
            }
        }
    }

    public static void parseListBucketVersions(InputStream inputStream, ListBucketVersions result) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        result.objectVersionList = new ArrayList();
        ListBucketVersions.ObjectVersion objectVersion = null;
        ListBucketVersions.Owner owner = null;
        for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
            switch (eventType) {
                case 2:
                    String tagName = xmlPullParser.getName();
                    if (!tagName.equalsIgnoreCase("Name")) {
                        if (!tagName.equalsIgnoreCase("Prefix")) {
                            if (!tagName.equalsIgnoreCase("KeyMarker")) {
                                if (!tagName.equalsIgnoreCase("VersionIdMarker")) {
                                    if (!tagName.equalsIgnoreCase("MaxKeys")) {
                                        if (!tagName.equalsIgnoreCase("IsTruncated")) {
                                            if (!tagName.equalsIgnoreCase("NextKeyMarker")) {
                                                if (!tagName.equalsIgnoreCase("NextVersionIdMarker")) {
                                                    if (!tagName.equalsIgnoreCase("DeleteMarker")) {
                                                        if (!tagName.equalsIgnoreCase("Version")) {
                                                            if (!tagName.equalsIgnoreCase("Key")) {
                                                                if (!tagName.equalsIgnoreCase("VersionId")) {
                                                                    if (!tagName.equalsIgnoreCase("IsLatest")) {
                                                                        if (!tagName.equalsIgnoreCase("LastModified")) {
                                                                            if (!tagName.equalsIgnoreCase("Owner")) {
                                                                                if (!tagName.equalsIgnoreCase("UID")) {
                                                                                    if (!tagName.equalsIgnoreCase("ETag")) {
                                                                                        if (!tagName.equalsIgnoreCase("Size")) {
                                                                                            if (tagName.equalsIgnoreCase("StorageClass")) {
                                                                                                xmlPullParser.next();
                                                                                                ((ListBucketVersions.Version) objectVersion).storageClass = xmlPullParser.getText();
                                                                                                break;
                                                                                            } else {
                                                                                                break;
                                                                                            }
                                                                                        } else {
                                                                                            xmlPullParser.next();
                                                                                            ((ListBucketVersions.Version) objectVersion).size = Long.parseLong(xmlPullParser.getText());
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        xmlPullParser.next();
                                                                                        ((ListBucketVersions.Version) objectVersion).eTag = xmlPullParser.getText();
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    xmlPullParser.next();
                                                                                    owner.uid = xmlPullParser.getText();
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                owner = new ListBucketVersions.Owner();
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            xmlPullParser.next();
                                                                            objectVersion.lastModified = xmlPullParser.getText();
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        xmlPullParser.next();
                                                                        objectVersion.isLatest = Boolean.parseBoolean(xmlPullParser.getText());
                                                                        break;
                                                                    }
                                                                } else {
                                                                    xmlPullParser.next();
                                                                    objectVersion.versionId = xmlPullParser.getText();
                                                                    break;
                                                                }
                                                            } else {
                                                                xmlPullParser.next();
                                                                objectVersion.key = xmlPullParser.getText();
                                                                break;
                                                            }
                                                        } else {
                                                            objectVersion = new ListBucketVersions.Version();
                                                            break;
                                                        }
                                                    } else {
                                                        objectVersion = new ListBucketVersions.DeleteMarker();
                                                        break;
                                                    }
                                                } else {
                                                    xmlPullParser.next();
                                                    result.nextVersionIdMarker = xmlPullParser.getText();
                                                    break;
                                                }
                                            } else {
                                                xmlPullParser.next();
                                                result.nextKeyMarker = xmlPullParser.getText();
                                                break;
                                            }
                                        } else {
                                            xmlPullParser.next();
                                            result.isTruncated = Boolean.parseBoolean(xmlPullParser.getText());
                                            break;
                                        }
                                    } else {
                                        xmlPullParser.next();
                                        result.maxKeys = Long.parseLong(xmlPullParser.getText());
                                        break;
                                    }
                                } else {
                                    xmlPullParser.next();
                                    result.versionIdMarker = xmlPullParser.getText();
                                    break;
                                }
                            } else {
                                xmlPullParser.next();
                                result.keyMarker = xmlPullParser.getText();
                                break;
                            }
                        } else {
                            xmlPullParser.next();
                            result.prefix = xmlPullParser.getText();
                            break;
                        }
                    } else {
                        xmlPullParser.next();
                        result.name = xmlPullParser.getText();
                        break;
                    }
                case 3:
                    String tagName2 = xmlPullParser.getName();
                    if (!tagName2.equalsIgnoreCase("Owner")) {
                        if (!tagName2.equalsIgnoreCase("DeleteMarker")) {
                            if (tagName2.equalsIgnoreCase("Version")) {
                                result.objectVersionList.add(objectVersion);
                                objectVersion = null;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            result.objectVersionList.add(objectVersion);
                            objectVersion = null;
                            break;
                        }
                    } else {
                        objectVersion.owner = owner;
                        owner = null;
                        break;
                    }
            }
        }
    }
}
