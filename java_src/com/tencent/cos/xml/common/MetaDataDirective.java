package com.tencent.cos.xml.common;

public enum MetaDataDirective {
    COPY("Copy"),
    REPLACED("Replaced");
    
    String directive;

    private MetaDataDirective(String directive2) {
        this.directive = directive2;
    }

    public String getMetaDirective() {
        return this.directive;
    }

    public static MetaDataDirective fromValue(String value) {
        MetaDataDirective[] values = values();
        for (MetaDataDirective metaDataDirective : values) {
            if (metaDataDirective.directive.equalsIgnoreCase(value)) {
                return metaDataDirective;
            }
        }
        return null;
    }
}
