package com.umeng.analytics.social;

import android.text.TextUtils;
import com.umeng.p085a.C1346h;
import java.util.Locale;

public class UMPlatformData {

    /* renamed from: a */
    private UMedia f3965a;

    /* renamed from: b */
    private String f3966b = "";

    /* renamed from: c */
    private String f3967c = "";

    /* renamed from: d */
    private String f3968d;

    /* renamed from: e */
    private GENDER f3969e;

    public enum UMedia {
        SINA_WEIBO {
            public String toString() {
                return "sina";
            }
        },
        TENCENT_WEIBO {
            public String toString() {
                return "tencent";
            }
        },
        TENCENT_QZONE {
            public String toString() {
                return "qzone";
            }
        },
        TENCENT_QQ {
            public String toString() {
                return "qq";
            }
        },
        WEIXIN_FRIENDS {
            public String toString() {
                return "wxsesion";
            }
        },
        WEIXIN_CIRCLE {
            public String toString() {
                return "wxtimeline";
            }
        },
        RENREN {
            public String toString() {
                return "renren";
            }
        },
        DOUBAN {
            public String toString() {
                return "douban";
            }
        }
    }

    public enum GENDER {
        MALE(0) {
            public String toString() {
                return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
            }
        },
        FEMALE(1) {
            public String toString() {
                return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
            }
        };
        
        public int value;

        private GENDER(int i) {
            this.value = i;
        }
    }

    public UMPlatformData(UMedia uMedia, String str) {
        if (uMedia == null || TextUtils.isEmpty(str)) {
            C1346h.m5009e("parameter is not valid");
            return;
        }
        this.f3965a = uMedia;
        this.f3966b = str;
    }

    public String getWeiboId() {
        return this.f3967c;
    }

    public void setWeiboId(String str) {
        this.f3967c = str;
    }

    public UMedia getMeida() {
        return this.f3965a;
    }

    public String getUsid() {
        return this.f3966b;
    }

    public String getName() {
        return this.f3968d;
    }

    public void setName(String str) {
        this.f3968d = str;
    }

    public GENDER getGender() {
        return this.f3969e;
    }

    public void setGender(GENDER gender) {
        this.f3969e = gender;
    }

    public boolean isValid() {
        if (this.f3965a == null || TextUtils.isEmpty(this.f3966b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "UMPlatformData [meida=" + this.f3965a + ", usid=" + this.f3966b + ", weiboId=" + this.f3967c + ", name=" + this.f3968d + ", gender=" + this.f3969e + "]";
    }
}
