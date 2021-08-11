package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class CORSConfiguration {
    public List<CORSRule> corsRules;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{CORSConfiguration:\n");
        if (this.corsRules != null) {
            for (CORSRule corsRule : this.corsRules) {
                if (corsRule != null) {
                    stringBuilder.append(corsRule.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class CORSRule {
        public List<String> allowedHeader;
        public List<String> allowedMethod;
        public String allowedOrigin;
        public List<String> exposeHeader;

        /* renamed from: id */
        public String f3118id;
        public int maxAgeSeconds;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{CORSRule:\n");
            stringBuilder.append("ID:").append(this.f3118id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("AllowedOrigin:").append(this.allowedOrigin).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.allowedMethod != null) {
                for (String method : this.allowedMethod) {
                    if (method != null) {
                        stringBuilder.append("AllowedMethod:").append(method).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }
            }
            if (this.allowedHeader != null) {
                for (String header : this.allowedHeader) {
                    if (header != null) {
                        stringBuilder.append("AllowedHeader:").append(header).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }
            }
            if (this.exposeHeader != null) {
                for (String exposeHeader2 : this.exposeHeader) {
                    if (exposeHeader2 != null) {
                        stringBuilder.append("ExposeHeader:").append(exposeHeader2).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }
            }
            stringBuilder.append("MaxAgeSeconds:").append(this.maxAgeSeconds).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
