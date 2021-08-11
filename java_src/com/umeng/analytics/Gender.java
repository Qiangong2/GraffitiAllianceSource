package com.umeng.analytics;

import com.umeng.analytics.p095f.EnumC1499a;
import java.util.Locale;

public enum Gender {
    Male(1) {
        public String toString() {
            return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
        }
    },
    Female(2) {
        public String toString() {
            return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
        }
    },
    Unknown(0) {
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
        }
    };
    
    public int value;

    private Gender(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }

    public static Gender getGender(int i) {
        switch (i) {
            case 1:
                return Male;
            case 2:
                return Female;
            default:
                return Unknown;
        }
    }

    public static EnumC1499a transGender(Gender gender) {
        switch (gender) {
            case Male:
                return EnumC1499a.MALE;
            case Female:
                return EnumC1499a.FEMALE;
            default:
                return EnumC1499a.UNKNOWN;
        }
    }
}
