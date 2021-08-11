package com.tencent.cos.xml.common;

public enum Permission {
    READ("READ"),
    WRITE("WRITE"),
    FULL_CONTROL("FULL_CONTROL");
    
    private String permission;

    private Permission(String permission2) {
        this.permission = permission2;
    }

    public String getPermission() {
        return this.permission;
    }

    public static Permission fromValue(String permission2) {
        Permission[] values = values();
        for (Permission permission1 : values) {
            if (permission1.permission.equalsIgnoreCase(permission2)) {
                return permission1;
            }
        }
        return null;
    }
}
