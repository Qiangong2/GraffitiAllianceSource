package com.xiaomi.smack;

import com.xiaomi.smack.packet.C2033g;
import com.xiaomi.smack.packet.C2034h;
import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.xiaomi.smack.p */
public class C2023p extends Exception {

    /* renamed from: a */
    private C2033g f5355a = null;

    /* renamed from: b */
    private C2034h f5356b = null;

    /* renamed from: c */
    private Throwable f5357c = null;

    public C2023p() {
    }

    public C2023p(C2033g gVar) {
        this.f5355a = gVar;
    }

    public C2023p(String str) {
        super(str);
    }

    public C2023p(String str, Throwable th) {
        super(str);
        this.f5357c = th;
    }

    public C2023p(Throwable th) {
        this.f5357c = th;
    }

    /* renamed from: a */
    public Throwable mo10561a() {
        return this.f5357c;
    }

    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f5356b == null) ? (message != null || this.f5355a == null) ? message : this.f5355a.toString() : this.f5356b.toString();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f5357c != null) {
            printStream.println("Nested Exception: ");
            this.f5357c.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f5357c != null) {
            printWriter.println("Nested Exception: ");
            this.f5357c.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f5356b != null) {
            sb.append(this.f5356b);
        }
        if (this.f5355a != null) {
            sb.append(this.f5355a);
        }
        if (this.f5357c != null) {
            sb.append("\n  -- caused by: ").append(this.f5357c);
        }
        return sb.toString();
    }
}
