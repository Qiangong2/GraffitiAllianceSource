package com.tencent.cos.xml.common;

public enum COSACL {
    PRIVATE("private"),
    PUBLIC_READ("public-read"),
    PUBLIC_READ_WRITE("public-read-write");
    
    private String acl;

    private COSACL(String acl2) {
        this.acl = acl2;
    }

    public String getAcl() {
        return this.acl;
    }

    public static COSACL fromString(String acl2) {
        COSACL[] values = values();
        for (COSACL cosacl : values) {
            if (cosacl.acl.equalsIgnoreCase(acl2)) {
                return cosacl;
            }
        }
        return null;
    }
}
