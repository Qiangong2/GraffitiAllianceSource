package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;

public class RestoreConfigure {
    public CASJobParameters casJobParameters;
    public int days;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{RestoreRequest:\n");
        stringBuilder.append("Days:").append(this.days).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.casJobParameters != null) {
            stringBuilder.append(this.casJobParameters.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class CASJobParameters {
        public String tier = Tier.Standard.getTier();

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{CASJobParameters:\n");
            stringBuilder.append("Tier:").append(this.tier).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public enum Tier {
        Expedited("Expedited"),
        Standard("Standard"),
        Bulk("Bulk");
        
        private String tier;

        private Tier(String tier2) {
            this.tier = tier2;
        }

        public String getTier() {
            return this.tier;
        }
    }
}
