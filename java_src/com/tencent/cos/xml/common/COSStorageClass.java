package com.tencent.cos.xml.common;

public enum COSStorageClass {
    STANDARD("Standard"),
    STANDARD_IA("Standard_IA"),
    NEARLINE("Nearline");
    
    private String cosStorageClass;

    private COSStorageClass(String cosStorageClass2) {
        this.cosStorageClass = cosStorageClass2;
    }

    public String getStorageClass() {
        return this.cosStorageClass;
    }

    public static COSStorageClass fromString(String cosStorageClass2) {
        COSStorageClass[] values = values();
        for (COSStorageClass storageClass : values) {
            if (storageClass.cosStorageClass.equalsIgnoreCase(cosStorageClass2)) {
                return storageClass;
            }
        }
        return null;
    }
}
