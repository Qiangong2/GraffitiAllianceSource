package com.amap.loc;

import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.amap.loc.bb */
/* compiled from: DiskLruCache */
public final class C0264bb implements Closeable {

    /* renamed from: a */
    static final Pattern f404a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: q */
    private static final OutputStream f405q = new OutputStream() {
        /* class com.amap.loc.C0264bb.C02662 */

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };

    /* renamed from: b */
    final ThreadPoolExecutor f406b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: c */
    private final File f407c;

    /* renamed from: d */
    private final File f408d;

    /* renamed from: e */
    private final File f409e;

    /* renamed from: f */
    private final File f410f;

    /* renamed from: g */
    private final int f411g;

    /* renamed from: h */
    private long f412h;

    /* renamed from: i */
    private final int f413i;

    /* renamed from: j */
    private long f414j = 0;

    /* renamed from: k */
    private Writer f415k;

    /* renamed from: l */
    private final LinkedHashMap<String, C0270c> f416l = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m */
    private int f417m;

    /* renamed from: n */
    private AbstractC0271bc f418n;

    /* renamed from: o */
    private long f419o = 0;

    /* renamed from: p */
    private final Callable<Void> f420p = new Callable<Void>() {
        /* class com.amap.loc.C0264bb.CallableC02651 */

        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (C0264bb.this) {
                if (C0264bb.this.f415k != null) {
                    C0264bb.this.m683j();
                    if (C0264bb.this.m681h()) {
                        C0264bb.this.m680g();
                        C0264bb.this.f417m = 0;
                    }
                }
            }
            return null;
        }
    };

    /* renamed from: com.amap.loc.bb$a */
    /* compiled from: DiskLruCache */
    public final class C0267a {

        /* renamed from: b */
        private final C0270c f423b;

        /* renamed from: c */
        private final boolean[] f424c;

        /* renamed from: d */
        private boolean f425d;

        /* renamed from: e */
        private boolean f426e;

        /* access modifiers changed from: private */
        /* renamed from: com.amap.loc.bb$a$a */
        /* compiled from: DiskLruCache */
        public class C0268a extends FilterOutputStream {
            private C0268a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C0267a.this.f425d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C0267a.this.f425d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C0267a.this.f425d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C0267a.this.f425d = true;
                }
            }
        }

        private C0267a(C0270c cVar) {
            this.f423b = cVar;
            this.f424c = cVar.f436d ? null : new boolean[C0264bb.this.f413i];
        }

        /* renamed from: a */
        public OutputStream mo3732a(int i) throws IOException {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i < 0 || i >= C0264bb.this.f413i) {
                throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + C0264bb.this.f413i);
            }
            synchronized (C0264bb.this) {
                if (this.f423b.f437e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f423b.f436d) {
                    this.f424c[i] = true;
                }
                File b = this.f423b.mo3743b(i);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    C0264bb.this.f407c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        outputStream = C0264bb.f405q;
                    }
                }
                outputStream = new C0268a(fileOutputStream);
            }
            return outputStream;
        }

        /* renamed from: a */
        public void mo3733a() throws IOException {
            if (this.f425d) {
                C0264bb.this.m666a((C0264bb) this, (C0267a) false);
                C0264bb.this.mo3727c(this.f423b.f434b);
            } else {
                C0264bb.this.m666a((C0264bb) this, (C0267a) true);
            }
            this.f426e = true;
        }

        /* renamed from: b */
        public void mo3734b() throws IOException {
            C0264bb.this.m666a((C0264bb) this, (C0267a) false);
        }
    }

    /* renamed from: com.amap.loc.bb$b */
    /* compiled from: DiskLruCache */
    public final class C0269b implements Closeable {

        /* renamed from: b */
        private final String f429b;

        /* renamed from: c */
        private final long f430c;

        /* renamed from: d */
        private final InputStream[] f431d;

        /* renamed from: e */
        private final long[] f432e;

        private C0269b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f429b = str;
            this.f430c = j;
            this.f431d = inputStreamArr;
            this.f432e = jArr;
        }

        /* renamed from: a */
        public InputStream mo3739a(int i) {
            return this.f431d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f431d) {
                C0274be.m717a(inputStream);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.amap.loc.bb$c */
    /* compiled from: DiskLruCache */
    public final class C0270c {

        /* renamed from: b */
        private final String f434b;

        /* renamed from: c */
        private final long[] f435c;

        /* renamed from: d */
        private boolean f436d;

        /* renamed from: e */
        private C0267a f437e;

        /* renamed from: f */
        private long f438f;

        private C0270c(String str) {
            this.f434b = str;
            this.f435c = new long[C0264bb.this.f413i];
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: a */
        private void m703a(String[] strArr) throws IOException {
            if (strArr.length != C0264bb.this.f413i) {
                throw m705b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f435c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m705b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m705b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File mo3741a(int i) {
            return new File(C0264bb.this.f407c, this.f434b + "." + i);
        }

        /* renamed from: a */
        public String mo3742a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f435c) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public File mo3743b(int i) {
            return new File(C0264bb.this.f407c, this.f434b + "." + i + ".tmp");
        }
    }

    private C0264bb(File file, int i, int i2, long j) {
        this.f407c = file;
        this.f411g = i;
        this.f408d = new File(file, "journal");
        this.f409e = new File(file, "journal.tmp");
        this.f410f = new File(file, "journal.bkp");
        this.f413i = i2;
        this.f412h = j;
    }

    /* renamed from: a */
    private synchronized C0267a m663a(String str, long j) throws IOException {
        C0270c cVar;
        C0267a aVar;
        m682i();
        m677e(str);
        C0270c cVar2 = this.f416l.get(str);
        if (j == -1 || (cVar2 != null && cVar2.f438f == j)) {
            if (cVar2 == null) {
                C0270c cVar3 = new C0270c(str);
                this.f416l.put(str, cVar3);
                cVar = cVar3;
            } else if (cVar2.f437e != null) {
                aVar = null;
            } else {
                cVar = cVar2;
            }
            aVar = new C0267a(cVar);
            cVar.f437e = aVar;
            this.f415k.write("DIRTY " + str + '\n');
            this.f415k.flush();
        } else {
            aVar = null;
        }
        return aVar;
    }

    /* renamed from: a */
    public static C0264bb m664a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m669a(file2, file3, false);
                }
            }
            C0264bb bbVar = new C0264bb(file, i, i2, j);
            if (bbVar.f408d.exists()) {
                try {
                    bbVar.m676e();
                    bbVar.m679f();
                    bbVar.f415k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bbVar.f408d, true), C0274be.f445a));
                    return bbVar;
                } catch (Throwable th) {
                    bbVar.mo3726c();
                }
            }
            file.mkdirs();
            C0264bb bbVar2 = new C0264bb(file, i, i2, j);
            bbVar2.m680g();
            return bbVar2;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private synchronized void m666a(C0267a aVar, boolean z) throws IOException {
        synchronized (this) {
            C0270c cVar = aVar.f423b;
            if (cVar.f437e != aVar) {
                throw new IllegalStateException();
            }
            if (z && !cVar.f436d) {
                int i = 0;
                while (true) {
                    if (i >= this.f413i) {
                        break;
                    } else if (!aVar.f424c[i]) {
                        aVar.mo3734b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!cVar.mo3743b(i).exists()) {
                        aVar.mo3734b();
                        break;
                    } else {
                        i++;
                    }
                }
            }
            for (int i2 = 0; i2 < this.f413i; i2++) {
                File b = cVar.mo3743b(i2);
                if (!z) {
                    m668a(b);
                } else if (b.exists()) {
                    File a = cVar.mo3741a(i2);
                    b.renameTo(a);
                    long j = cVar.f435c[i2];
                    long length = a.length();
                    cVar.f435c[i2] = length;
                    this.f414j = (this.f414j - j) + length;
                }
            }
            this.f417m++;
            cVar.f437e = null;
            if (cVar.f436d || z) {
                cVar.f436d = true;
                this.f415k.write("CLEAN " + cVar.f434b + cVar.mo3742a() + '\n');
                if (z) {
                    long j2 = this.f419o;
                    this.f419o = 1 + j2;
                    cVar.f438f = j2;
                }
            } else {
                this.f416l.remove(cVar.f434b);
                this.f415k.write("REMOVE " + cVar.f434b + '\n');
            }
            this.f415k.flush();
            if (this.f414j > this.f412h || m681h()) {
                this.f406b.submit(this.f420p);
            }
        }
    }

    /* renamed from: a */
    private static void m668a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m669a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m668a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: d */
    private void m674d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf != "REMOVE".length() || !str.startsWith("REMOVE")) {
                str2 = substring;
            } else {
                this.f416l.remove(substring);
                return;
            }
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C0270c cVar = this.f416l.get(str2);
        if (cVar == null) {
            cVar = new C0270c(str2);
            this.f416l.put(str2, cVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            cVar.f436d = true;
            cVar.f437e = null;
            cVar.m703a((C0270c) split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            cVar.f437e = new C0267a(cVar);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: e */
    private void m676e() throws IOException {
        C0272bd bdVar = new C0272bd(new FileInputStream(this.f408d), C0274be.f445a);
        try {
            String a = bdVar.mo3744a();
            String a2 = bdVar.mo3744a();
            String a3 = bdVar.mo3744a();
            String a4 = bdVar.mo3744a();
            String a5 = bdVar.mo3744a();
            if (!"libcore.io.DiskLruCache".equals(a) || !"1".equals(a2) || !Integer.toString(this.f411g).equals(a3) || !Integer.toString(this.f413i).equals(a4) || !"".equals(a5)) {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m674d(bdVar.mo3744a());
                    i++;
                } catch (EOFException e) {
                    this.f417m = i - this.f416l.size();
                    return;
                }
            }
        } finally {
            C0274be.m717a(bdVar);
        }
    }

    /* renamed from: e */
    private void m677e(String str) {
        if (!f404a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* renamed from: f */
    private void m679f() throws IOException {
        m668a(this.f409e);
        Iterator<C0270c> it = this.f416l.values().iterator();
        while (it.hasNext()) {
            C0270c next = it.next();
            if (next.f437e == null) {
                for (int i = 0; i < this.f413i; i++) {
                    this.f414j += next.f435c[i];
                }
            } else {
                next.f437e = null;
                for (int i2 = 0; i2 < this.f413i; i2++) {
                    m668a(next.mo3741a(i2));
                    m668a(next.mo3743b(i2));
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: g */
    private synchronized void m680g() throws IOException {
        if (this.f415k != null) {
            this.f415k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f409e), C0274be.f445a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write("1");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.f411g));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.f413i));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            for (C0270c cVar : this.f416l.values()) {
                if (cVar.f437e != null) {
                    bufferedWriter.write("DIRTY " + cVar.f434b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f434b + cVar.mo3742a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f408d.exists()) {
                m669a(this.f408d, this.f410f, true);
            }
            m669a(this.f409e, this.f408d, false);
            this.f410f.delete();
            this.f415k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f408d, true), C0274be.f445a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: h */
    private boolean m681h() {
        return this.f417m >= 2000 && this.f417m >= this.f416l.size();
    }

    /* renamed from: i */
    private void m682i() {
        if (this.f415k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private void m683j() throws IOException {
        while (this.f414j > this.f412h) {
            String key = this.f416l.entrySet().iterator().next().getKey();
            mo3727c(key);
            if (this.f418n != null) {
                this.f418n.mo3638a(key);
            }
        }
    }

    /* renamed from: a */
    public synchronized C0269b mo3721a(String str) throws IOException {
        C0269b bVar = null;
        synchronized (this) {
            m682i();
            m677e(str);
            C0270c cVar = this.f416l.get(str);
            if (cVar != null && cVar.f436d) {
                InputStream[] inputStreamArr = new InputStream[this.f413i];
                for (int i = 0; i < this.f413i; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(cVar.mo3741a(i));
                    } catch (FileNotFoundException e) {
                        int i2 = 0;
                        while (i2 < this.f413i && inputStreamArr[i2] != null) {
                            C0274be.m717a(inputStreamArr[i2]);
                            i2++;
                        }
                    }
                }
                this.f417m++;
                this.f415k.append((CharSequence) ("READ " + str + '\n'));
                if (m681h()) {
                    this.f406b.submit(this.f420p);
                }
                bVar = new C0269b(str, cVar.f438f, inputStreamArr, cVar.f435c);
            }
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo3722a(AbstractC0271bc bcVar) {
        this.f418n = bcVar;
    }

    /* renamed from: a */
    public synchronized boolean mo3723a() {
        return this.f415k == null;
    }

    /* renamed from: b */
    public C0267a mo3724b(String str) throws IOException {
        return m663a(str, -1);
    }

    /* renamed from: b */
    public synchronized void mo3725b() throws IOException {
        m682i();
        m683j();
        this.f415k.flush();
    }

    /* renamed from: c */
    public void mo3726c() throws IOException {
        close();
        C0274be.m718a(this.f407c);
    }

    /* renamed from: c */
    public synchronized boolean mo3727c(String str) throws IOException {
        boolean z;
        synchronized (this) {
            m682i();
            m677e(str);
            C0270c cVar = this.f416l.get(str);
            if (cVar == null || cVar.f437e != null) {
                z = false;
            } else {
                for (int i = 0; i < this.f413i; i++) {
                    File a = cVar.mo3741a(i);
                    if (!a.exists() || a.delete()) {
                        this.f414j -= cVar.f435c[i];
                        cVar.f435c[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f417m++;
                this.f415k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f416l.remove(str);
                if (m681h()) {
                    this.f406b.submit(this.f420p);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f415k != null) {
            Iterator it = new ArrayList(this.f416l.values()).iterator();
            while (it.hasNext()) {
                C0270c cVar = (C0270c) it.next();
                if (cVar.f437e != null) {
                    cVar.f437e.mo3734b();
                }
            }
            m683j();
            this.f415k.close();
            this.f415k = null;
        }
    }
}
