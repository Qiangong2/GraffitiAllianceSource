package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class ListAllMyBuckets {
    public List<Bucket> buckets;
    public Owner owner;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ListAllMyBuckets:\n");
        if (this.owner != null) {
            stringBuilder.append(this.owner.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder.append("Buckets:\n");
        for (Bucket bucket : this.buckets) {
            if (bucket != null) {
                stringBuilder.append(bucket.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        stringBuilder.append("}").append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class Owner {
        public String disPlayName;

        /* renamed from: id */
        public String f3120id;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Owner:\n");
            stringBuilder.append("ID:").append(this.f3120id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DisPlayName:").append(this.disPlayName).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Bucket {
        public String createDate;
        public String location;
        public String name;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Bucket:\n");
            stringBuilder.append("Name:").append(this.name).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Location:").append(this.location).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("CreateDate:").append(this.createDate).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
