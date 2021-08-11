package com.xiaomi.measite.smack;

import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.AbstractC2006d;
import com.xiaomi.smack.AbstractC2009f;
import com.xiaomi.smack.debugger.AbstractC2007a;
import com.xiaomi.smack.util.AbstractC2044f;
import com.xiaomi.smack.util.AbstractC2052m;
import com.xiaomi.smack.util.C2039a;
import com.xiaomi.smack.util.C2040b;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

/* renamed from: com.xiaomi.measite.smack.a */
public class C1892a implements AbstractC2007a {

    /* renamed from: a */
    public static boolean f4834a = false;

    /* renamed from: b */
    private SimpleDateFormat f4835b = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: c */
    private AbstractC2002a f4836c = null;

    /* renamed from: d */
    private AbstractC2009f f4837d = null;

    /* renamed from: e */
    private AbstractC2006d f4838e = null;

    /* renamed from: f */
    private Writer f4839f;

    /* renamed from: g */
    private Reader f4840g;

    /* renamed from: h */
    private AbstractC2044f f4841h;

    /* renamed from: i */
    private AbstractC2052m f4842i;

    public C1892a(AbstractC2002a aVar, Writer writer, Reader reader) {
        this.f4836c = aVar;
        this.f4839f = writer;
        this.f4840g = reader;
        m6921e();
    }

    /* renamed from: e */
    private void m6921e() {
        C2039a aVar = new C2039a(this.f4840g);
        this.f4841h = new C1893b(this);
        aVar.mo10641a(this.f4841h);
        C2040b bVar = new C2040b(this.f4839f);
        this.f4842i = new C1894c(this);
        bVar.mo10652a(this.f4842i);
        this.f4840g = aVar;
        this.f4839f = bVar;
        this.f4837d = new C1895d(this);
        this.f4838e = new C1896e(this);
    }

    @Override // com.xiaomi.smack.debugger.AbstractC2007a
    /* renamed from: a */
    public Reader mo10097a() {
        return this.f4840g;
    }

    @Override // com.xiaomi.smack.debugger.AbstractC2007a
    /* renamed from: a */
    public Reader mo10098a(Reader reader) {
        ((C2039a) this.f4840g).mo10642b(this.f4841h);
        C2039a aVar = new C2039a(reader);
        aVar.mo10641a(this.f4841h);
        this.f4840g = aVar;
        return this.f4840g;
    }

    @Override // com.xiaomi.smack.debugger.AbstractC2007a
    /* renamed from: a */
    public Writer mo10099a(Writer writer) {
        ((C2040b) this.f4839f).mo10653b(this.f4842i);
        C2040b bVar = new C2040b(writer);
        bVar.mo10652a(this.f4842i);
        this.f4839f = bVar;
        return this.f4839f;
    }

    @Override // com.xiaomi.smack.debugger.AbstractC2007a
    /* renamed from: b */
    public Writer mo10100b() {
        return this.f4839f;
    }

    @Override // com.xiaomi.smack.debugger.AbstractC2007a
    /* renamed from: c */
    public AbstractC2009f mo10101c() {
        return this.f4837d;
    }

    @Override // com.xiaomi.smack.debugger.AbstractC2007a
    /* renamed from: d */
    public AbstractC2009f mo10102d() {
        return null;
    }
}
