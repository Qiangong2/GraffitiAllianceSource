package com.igexin.p010a.p011a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.igexin.a.a.j */
public class C0412j implements AbstractC0405c, Closeable {

    /* renamed from: a */
    private final int f1001a = 1179403647;

    /* renamed from: b */
    private final FileChannel f1002b;

    public C0412j(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f1002b = new FileInputStream(file).getChannel();
    }

    /* renamed from: a */
    private long m1514a(AbstractC0407e eVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            AbstractC0408f a = eVar.mo4064a(j3);
            if (a.f994a == 1 && a.f996c <= j2 && j2 <= a.f996c + a.f997d) {
                return (j2 - a.f996c) + a.f995b;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    /* renamed from: a */
    public AbstractC0407e mo4066a() {
        this.f1002b.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (mo4071c(allocate, 0) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short e = mo4074e(allocate, 4);
        boolean z = mo4074e(allocate, 5) == 2;
        if (e == 1) {
            return new C0410h(z, this);
        }
        if (e == 2) {
            return new C0411i(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4067a(ByteBuffer byteBuffer, long j) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short e = mo4074e(byteBuffer, j);
            if (e == 0) {
                return sb.toString();
            }
            sb.append((char) e);
            j = j2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4068a(ByteBuffer byteBuffer, long j, int i) {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.f1002b.read(byteBuffer, j + j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 += (long) read;
        }
        byteBuffer.position(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo4069b(ByteBuffer byteBuffer, long j) {
        mo4068a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    /* renamed from: b */
    public List<String> mo4070b() {
        long j;
        AbstractC0406d a;
        this.f1002b.position(0L);
        ArrayList arrayList = new ArrayList();
        AbstractC0407e a2 = mo4066a();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(a2.f985a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) a2.f990f;
        if (j2 == 65535) {
            j2 = a2.mo4065a(0).f998a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            AbstractC0408f a3 = a2.mo4064a(j3);
            if (a3.f994a == 2) {
                j = a3.f995b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        int i = 0;
        ArrayList<Long> arrayList2 = new ArrayList();
        long j4 = 0;
        do {
            a = a2.mo4063a(j, i);
            if (a.f983a == 1) {
                arrayList2.add(Long.valueOf(a.f984b));
            } else if (a.f983a == 5) {
                j4 = a.f984b;
            }
            i++;
        } while (a.f983a != 0);
        if (j4 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long a4 = m1514a(a2, j2, j4);
        for (Long l : arrayList2) {
            arrayList.add(mo4067a(allocate, l.longValue() + a4));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public long mo4071c(ByteBuffer byteBuffer, long j) {
        mo4068a(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1002b.close();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo4073d(ByteBuffer byteBuffer, long j) {
        mo4068a(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public short mo4074e(ByteBuffer byteBuffer, long j) {
        mo4068a(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }
}
