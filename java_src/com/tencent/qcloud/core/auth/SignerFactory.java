package com.tencent.qcloud.core.auth;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SignerFactory {
    private static final String COS_XML_SIGNER = "CosXmlSigner";
    private static final Map<String, Class<? extends QCloudSigner>> SIGNERS = new ConcurrentHashMap();

    static {
        SIGNERS.put(COS_XML_SIGNER, COSXmlSigner.class);
    }

    private SignerFactory() {
    }

    public static void registerSigner(String signerType, Class<? extends QCloudSigner> signerClass) {
        if (signerType == null) {
            throw new IllegalArgumentException("signerType cannot be null");
        } else if (signerClass == null) {
            throw new IllegalArgumentException("signerClass cannot be null");
        } else {
            SIGNERS.put(signerType, signerClass);
        }
    }

    public static QCloudSigner getSigner(String signerType) {
        return lookupAndCreateSigner(signerType);
    }

    private static QCloudSigner lookupAndCreateSigner(String signerType) {
        return createSigner(signerType);
    }

    private static QCloudSigner createSigner(String signerType) {
        Class<? extends QCloudSigner> signerClass = SIGNERS.get(signerType);
        if (signerClass == null) {
            return null;
        }
        try {
            return (QCloudSigner) signerClass.newInstance();
        } catch (InstantiationException ex) {
            throw new IllegalStateException("Cannot create an instance of " + signerClass.getName(), ex);
        } catch (IllegalAccessException ex2) {
            throw new IllegalStateException("Cannot create an instance of " + signerClass.getName(), ex2);
        }
    }
}
