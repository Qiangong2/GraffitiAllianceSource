package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class AccessControlPolicy {
    public AccessControlList accessControlList;
    public Owner owner;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{AccessControlPolicy:\n");
        if (this.owner != null) {
            stringBuilder.append(this.owner.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.accessControlList != null) {
            stringBuilder.append(this.accessControlList.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class Owner {
        public String displayName;

        /* renamed from: id */
        public String f3117id;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Owner:\n");
            stringBuilder.append("Id:").append(this.f3117id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DisplayName:").append(this.displayName).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class AccessControlList {
        public List<Grant> grants;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{AccessControlList:\n");
            if (this.grants != null) {
                for (Grant grant : this.grants) {
                    if (grant != null) {
                        stringBuilder.append(grant.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Grant {
        public Grantee grantee;
        public String permission;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Grant:\n");
            if (this.grantee != null) {
                stringBuilder.append(this.grantee.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("Permission:").append(this.permission).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Grantee {
        public String displayName;

        /* renamed from: id */
        public String f3116id;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Grantee:\n");
            stringBuilder.append("Id:").append(this.f3116id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DisplayName:").append(this.displayName).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
