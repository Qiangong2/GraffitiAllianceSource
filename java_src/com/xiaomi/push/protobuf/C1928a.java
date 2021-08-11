package com.xiaomi.push.protobuf;

import android.support.p007v4.view.MotionEventCompat;
import com.google.protobuf.micro.AbstractC0400d;
import com.google.protobuf.micro.C0396a;
import com.google.protobuf.micro.C0397b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.push.protobuf.a */
public final class C1928a {

    /* renamed from: com.xiaomi.push.protobuf.a$a */
    public static final class C1929a extends AbstractC0400d {

        /* renamed from: a */
        private boolean f4969a;

        /* renamed from: b */
        private int f4970b = 0;

        /* renamed from: c */
        private boolean f4971c;

        /* renamed from: d */
        private boolean f4972d = false;

        /* renamed from: e */
        private boolean f4973e;

        /* renamed from: f */
        private int f4974f = 0;

        /* renamed from: g */
        private boolean f4975g;

        /* renamed from: h */
        private boolean f4976h = false;

        /* renamed from: i */
        private List<String> f4977i = Collections.emptyList();

        /* renamed from: j */
        private int f4978j = -1;

        /* renamed from: b */
        public static C1929a m7133b(byte[] bArr) {
            return (C1929a) new C1929a().mo4056a(bArr);
        }

        /* renamed from: c */
        public static C1929a m7134c(C0396a aVar) {
            return new C1929a().mo4055a(aVar);
        }

        @Override // com.google.protobuf.micro.AbstractC0400d
        /* renamed from: a */
        public int mo4054a() {
            int i = 0;
            int d = mo10318d() ? C0397b.m1462d(1, mo10317c()) + 0 : 0;
            if (mo10320f()) {
                d += C0397b.m1456b(2, mo10319e());
            }
            if (mo10322h()) {
                d += C0397b.m1460c(3, mo10321g());
            }
            int b = mo10324j() ? d + C0397b.m1456b(4, mo10323i()) : d;
            for (String str : mo10325k()) {
                i += C0397b.m1457b(str);
            }
            int size = b + i + (mo10325k().size() * 1);
            this.f4978j = size;
            return size;
        }

        /* renamed from: a */
        public C1929a mo10311a(int i) {
            this.f4969a = true;
            this.f4970b = i;
            return this;
        }

        /* renamed from: a */
        public C1929a mo10312a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f4977i.isEmpty()) {
                this.f4977i = new ArrayList();
            }
            this.f4977i.add(str);
            return this;
        }

        /* renamed from: a */
        public C1929a mo10313a(boolean z) {
            this.f4971c = true;
            this.f4972d = z;
            return this;
        }

        @Override // com.google.protobuf.micro.AbstractC0400d
        /* renamed from: a */
        public void mo4057a(C0397b bVar) {
            if (mo10318d()) {
                bVar.mo4048b(1, mo10317c());
            }
            if (mo10320f()) {
                bVar.mo4041a(2, mo10319e());
            }
            if (mo10322h()) {
                bVar.mo4039a(3, mo10321g());
            }
            if (mo10324j()) {
                bVar.mo4041a(4, mo10323i());
            }
            for (String str : mo10325k()) {
                bVar.mo4040a(5, str);
            }
        }

        /* renamed from: b */
        public C1929a mo10314b(int i) {
            this.f4973e = true;
            this.f4974f = i;
            return this;
        }

        /* renamed from: b */
        public C1929a mo4055a(C0396a aVar) {
            while (true) {
                int a = aVar.mo4021a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        mo10311a(aVar.mo4030f());
                        break;
                    case 16:
                        mo10313a(aVar.mo4028d());
                        break;
                    case MotionEventCompat.AXIS_DISTANCE:
                        mo10314b(aVar.mo4025c());
                        break;
                    case 32:
                        mo10316b(aVar.mo4028d());
                        break;
                    case MotionEventCompat.AXIS_GENERIC_11:
                        mo10312a(aVar.mo4029e());
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

        /* renamed from: b */
        public C1929a mo10316b(boolean z) {
            this.f4975g = true;
            this.f4976h = z;
            return this;
        }

        /* renamed from: c */
        public int mo10317c() {
            return this.f4970b;
        }

        /* renamed from: d */
        public boolean mo10318d() {
            return this.f4969a;
        }

        /* renamed from: e */
        public boolean mo10319e() {
            return this.f4972d;
        }

        /* renamed from: f */
        public boolean mo10320f() {
            return this.f4971c;
        }

        /* renamed from: g */
        public int mo10321g() {
            return this.f4974f;
        }

        /* renamed from: h */
        public boolean mo10322h() {
            return this.f4973e;
        }

        /* renamed from: i */
        public boolean mo10323i() {
            return this.f4976h;
        }

        /* renamed from: j */
        public boolean mo10324j() {
            return this.f4975g;
        }

        /* renamed from: k */
        public List<String> mo10325k() {
            return this.f4977i;
        }

        /* renamed from: l */
        public int mo10326l() {
            return this.f4977i.size();
        }
    }
}
