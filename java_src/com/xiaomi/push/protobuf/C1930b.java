package com.xiaomi.push.protobuf;

import android.support.p007v4.view.MotionEventCompat;
import com.google.protobuf.micro.AbstractC0400d;
import com.google.protobuf.micro.C0396a;
import com.google.protobuf.micro.C0397b;

/* renamed from: com.xiaomi.push.protobuf.b */
public final class C1930b {

    /* renamed from: com.xiaomi.push.protobuf.b$a */
    public static final class C1931a extends AbstractC0400d {

        /* renamed from: a */
        private boolean f4979a;

        /* renamed from: b */
        private boolean f4980b = false;

        /* renamed from: c */
        private boolean f4981c;

        /* renamed from: d */
        private int f4982d = 0;

        /* renamed from: e */
        private boolean f4983e;

        /* renamed from: f */
        private int f4984f = 0;

        /* renamed from: g */
        private boolean f4985g;

        /* renamed from: h */
        private int f4986h = 0;

        /* renamed from: i */
        private int f4987i = -1;

        /* renamed from: b */
        public static C1931a m7154b(byte[] bArr) {
            return (C1931a) new C1931a().mo4056a(bArr);
        }

        @Override // com.google.protobuf.micro.AbstractC0400d
        /* renamed from: a */
        public int mo4054a() {
            int i = 0;
            if (mo10333d()) {
                i = 0 + C0397b.m1456b(1, mo10332c());
            }
            if (mo10335f()) {
                i += C0397b.m1460c(3, mo10334e());
            }
            if (mo10337h()) {
                i += C0397b.m1460c(4, mo10336g());
            }
            if (mo10339j()) {
                i += C0397b.m1460c(5, mo10338i());
            }
            this.f4987i = i;
            return i;
        }

        /* renamed from: a */
        public C1931a mo10327a(int i) {
            this.f4981c = true;
            this.f4982d = i;
            return this;
        }

        /* renamed from: a */
        public C1931a mo10328a(boolean z) {
            this.f4979a = true;
            this.f4980b = z;
            return this;
        }

        @Override // com.google.protobuf.micro.AbstractC0400d
        /* renamed from: a */
        public void mo4057a(C0397b bVar) {
            if (mo10333d()) {
                bVar.mo4041a(1, mo10332c());
            }
            if (mo10335f()) {
                bVar.mo4039a(3, mo10334e());
            }
            if (mo10337h()) {
                bVar.mo4039a(4, mo10336g());
            }
            if (mo10339j()) {
                bVar.mo4039a(5, mo10338i());
            }
        }

        /* renamed from: b */
        public C1931a mo10329b(int i) {
            this.f4983e = true;
            this.f4984f = i;
            return this;
        }

        /* renamed from: b */
        public C1931a mo4055a(C0396a aVar) {
            while (true) {
                int a = aVar.mo4021a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        mo10328a(aVar.mo4028d());
                        break;
                    case MotionEventCompat.AXIS_DISTANCE:
                        mo10327a(aVar.mo4025c());
                        break;
                    case 32:
                        mo10329b(aVar.mo4025c());
                        break;
                    case MotionEventCompat.AXIS_GENERIC_9:
                        mo10331c(aVar.mo4025c());
                        break;
                    default:
                        if (mo4059a(aVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* renamed from: c */
        public C1931a mo10331c(int i) {
            this.f4985g = true;
            this.f4986h = i;
            return this;
        }

        /* renamed from: c */
        public boolean mo10332c() {
            return this.f4980b;
        }

        /* renamed from: d */
        public boolean mo10333d() {
            return this.f4979a;
        }

        /* renamed from: e */
        public int mo10334e() {
            return this.f4982d;
        }

        /* renamed from: f */
        public boolean mo10335f() {
            return this.f4981c;
        }

        /* renamed from: g */
        public int mo10336g() {
            return this.f4984f;
        }

        /* renamed from: h */
        public boolean mo10337h() {
            return this.f4983e;
        }

        /* renamed from: i */
        public int mo10338i() {
            return this.f4986h;
        }

        /* renamed from: j */
        public boolean mo10339j() {
            return this.f4985g;
        }
    }
}
