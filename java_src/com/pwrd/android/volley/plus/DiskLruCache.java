package com.pwrd.android.volley.plus;

import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable, PersistentCache {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    private static final int IO_BUFFER_SIZE = 8192;
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_TMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String PERSISTENT = "PERSISTENT";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable = new Callable<Void>() {
        /* class com.pwrd.android.volley.plus.DiskLruCache.CallableC12221 */

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter != null) {
                    DiskLruCache.this.trimToSize();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                }
            }
            return null;
        }
    };
    private final File directory;
    private final ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File journalFile;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private final long maxSize;
    private long nextSequenceNumber = 0;
    private int redundantOpCount;
    private long size = 0;
    private final int valueCount;

    private static <T> T[] copyOfRange(T[] tArr, int start, int end) {
        int originalLength = tArr.length;
        if (start > end) {
            throw new IllegalArgumentException();
        } else if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int resultLength = end - start;
            int copyLength = Math.min(resultLength, originalLength - start);
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), resultLength));
            System.arraycopy(tArr, start, tArr2, 0, copyLength);
            return tArr2;
        }
    }

    public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter writer = new StringWriter();
            char[] buffer = new char[1024];
            while (true) {
                int count = reader.read(buffer);
                if (count == -1) {
                    return writer.toString();
                }
                writer.write(buffer, 0, count);
            }
        } finally {
            reader.close();
        }
    }

    public static String readAsciiLine(InputStream in) throws IOException {
        StringBuilder result = new StringBuilder(80);
        while (true) {
            int c = in.read();
            if (c == -1) {
                throw new EOFException();
            } else if (c == 10) {
                int length = result.length();
                if (length > 0 && result.charAt(length - 1) == '\r') {
                    result.setLength(length - 1);
                }
                return result.toString();
            } else {
                result.append((char) c);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }

    public static void deleteContents(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files == null) {
            throw new IllegalArgumentException("not a directory: " + dir);
        }
        for (File file : files) {
            if (file.isDirectory()) {
                deleteContents(file);
            }
            if (!file.delete()) {
                throw new IOException("failed to delete file: " + file);
            }
        }
    }

    private DiskLruCache(File directory2, int appVersion2, int valueCount2, long maxSize2) {
        this.directory = directory2;
        this.appVersion = appVersion2;
        this.journalFile = new File(directory2, JOURNAL_FILE);
        this.journalFileTmp = new File(directory2, JOURNAL_FILE_TMP);
        this.valueCount = valueCount2;
        this.maxSize = maxSize2;
    }

    public static DiskLruCache open(File directory2, int appVersion2, int valueCount2, long maxSize2) throws IOException {
        if (maxSize2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (valueCount2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            DiskLruCache cache = new DiskLruCache(directory2, appVersion2, valueCount2, maxSize2);
            if (cache.journalFile.exists()) {
                try {
                    cache.readJournal();
                    cache.processJournal();
                    cache.journalWriter = new BufferedWriter(new FileWriter(cache.journalFile, true), 8192);
                    return cache;
                } catch (IOException e) {
                    cache.delete();
                }
            }
            directory2.mkdirs();
            DiskLruCache cache2 = new DiskLruCache(directory2, appVersion2, valueCount2, maxSize2);
            cache2.rebuildJournal();
            return cache2;
        }
    }

    private void readJournal() throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(this.journalFile), 8192);
        try {
            String magic = readAsciiLine(in);
            String version = readAsciiLine(in);
            String appVersionString = readAsciiLine(in);
            String valueCountString = readAsciiLine(in);
            String blank = readAsciiLine(in);
            if (!MAGIC.equals(magic) || !"1".equals(version) || !Integer.toString(this.appVersion).equals(appVersionString) || !Integer.toString(this.valueCount).equals(valueCountString) || !"".equals(blank)) {
                throw new IOException("unexpected journal header: [" + magic + ", " + version + ", " + valueCountString + ", " + blank + "]");
            }
            while (true) {
                try {
                    readJournalLine(readAsciiLine(in));
                } catch (EOFException e) {
                    return;
                }
            }
        } finally {
            closeQuietly(in);
        }
    }

    private void readJournalLine(String line) throws IOException {
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            throw new IOException("unexpected journal line: " + line);
        }
        String key = parts[1];
        if (!parts[0].equals(REMOVE) || parts.length != 2) {
            Entry entry = this.lruEntries.get(key);
            if (entry == null) {
                entry = new Entry(this, key, null);
                this.lruEntries.put(key, entry);
            }
            if (parts[0].equals(CLEAN) && parts.length == this.valueCount + 2) {
                entry.readable = true;
                entry.currentEditor = null;
                entry.persistent = false;
                entry.setLengths((String[]) copyOfRange(parts, 2, parts.length));
            } else if (parts[0].equals(DIRTY) && parts.length == 2) {
                entry.currentEditor = new Editor(this, entry, null);
            } else if (parts[0].equals(READ) && parts.length == 2) {
            } else {
                if (!parts[0].equals(PERSISTENT) || parts.length != this.valueCount + 2) {
                    throw new IOException("unexpected journal line: " + line);
                }
                entry.readable = true;
                entry.currentEditor = null;
                entry.persistent = true;
                entry.setLengths((String[]) copyOfRange(parts, 2, parts.length));
            }
        } else {
            this.lruEntries.remove(key);
        }
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.currentEditor != null) {
                entry.currentEditor = null;
                for (int t = 0; t < this.valueCount; t++) {
                    deleteIfExists(entry.getCleanFile(t));
                    deleteIfExists(entry.getDirtyFile(t));
                }
                iterator.remove();
            } else if (!entry.persistent) {
                for (int t2 = 0; t2 < this.valueCount; t2++) {
                    this.size += entry.lengths[t2];
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        Writer writer = new BufferedWriter(new FileWriter(this.journalFileTmp), 8192);
        writer.write(MAGIC);
        writer.write(IOUtils.LINE_SEPARATOR_UNIX);
        writer.write("1");
        writer.write(IOUtils.LINE_SEPARATOR_UNIX);
        writer.write(Integer.toString(this.appVersion));
        writer.write(IOUtils.LINE_SEPARATOR_UNIX);
        writer.write(Integer.toString(this.valueCount));
        writer.write(IOUtils.LINE_SEPARATOR_UNIX);
        writer.write(IOUtils.LINE_SEPARATOR_UNIX);
        for (Entry entry : this.lruEntries.values()) {
            if (entry.currentEditor != null) {
                writer.write("DIRTY " + entry.key + '\n');
            } else {
                writer.write(entry.persistent ? PERSISTENT : "CLEAN " + entry.key + entry.getLengths() + '\n');
            }
        }
        writer.close();
        this.journalFileTmp.renameTo(this.journalFile);
        this.journalWriter = new BufferedWriter(new FileWriter(this.journalFile, true), 8192);
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized Snapshot get(String key) throws IOException {
        Snapshot snapshot = null;
        synchronized (this) {
            checkNotClosed();
            validateKey(key);
            Entry entry = this.lruEntries.get(key);
            if (entry != null && entry.readable) {
                InputStream[] ins = new InputStream[this.valueCount];
                for (int i = 0; i < this.valueCount; i++) {
                    try {
                        ins[i] = new FileInputStream(entry.getCleanFile(i));
                    } catch (FileNotFoundException e) {
                    }
                }
                this.redundantOpCount++;
                this.journalWriter.append((CharSequence) ("READ " + key + '\n'));
                if (journalRebuildRequired()) {
                    this.executorService.submit(this.cleanupCallable);
                }
                snapshot = new Snapshot(this, key, entry.sequenceNumber, ins, null);
            }
        }
        return snapshot;
    }

    @Override // com.pwrd.android.volley.plus.PersistentCache
    public void setPersistent(String key) throws IOException {
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry != null && entry.readable && !entry.persistent) {
            this.redundantOpCount++;
            entry.persistent = true;
            this.journalWriter.write("PERSISTENT " + entry.key + entry.getLengths() + '\n');
            this.journalWriter.flush();
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
        }
    }

    @Override // com.pwrd.android.volley.plus.PersistentCache
    public void setBrittle(String key) throws IOException {
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry != null && entry.readable && entry.persistent) {
            this.redundantOpCount++;
            entry.persistent = false;
            this.journalWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
            this.journalWriter.flush();
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
        }
    }

    public Editor edit(String key) throws IOException {
        return edit(key, -1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        if (r1.currentEditor != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.pwrd.android.volley.plus.DiskLruCache.Editor edit(java.lang.String r7, long r8) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            monitor-enter(r6)
            r6.checkNotClosed()     // Catch:{ all -> 0x0058 }
            r6.validateKey(r7)     // Catch:{ all -> 0x0058 }
            java.util.LinkedHashMap<java.lang.String, com.pwrd.android.volley.plus.DiskLruCache$Entry> r2 = r6.lruEntries     // Catch:{ all -> 0x0058 }
            java.lang.Object r1 = r2.get(r7)     // Catch:{ all -> 0x0058 }
            com.pwrd.android.volley.plus.DiskLruCache$Entry r1 = (com.pwrd.android.volley.plus.DiskLruCache.Entry) r1     // Catch:{ all -> 0x0058 }
            r2 = -1
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0022
            if (r1 == 0) goto L_0x0020
            long r2 = com.pwrd.android.volley.plus.DiskLruCache.Entry.access$10(r1)     // Catch:{ all -> 0x0058 }
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r6)
            return r0
        L_0x0022:
            if (r1 != 0) goto L_0x005b
            com.pwrd.android.volley.plus.DiskLruCache$Entry r1 = new com.pwrd.android.volley.plus.DiskLruCache$Entry
            r2 = 0
            r1.<init>(r6, r7, r2)
            java.util.LinkedHashMap<java.lang.String, com.pwrd.android.volley.plus.DiskLruCache$Entry> r2 = r6.lruEntries
            r2.put(r7, r1)
        L_0x002f:
            com.pwrd.android.volley.plus.DiskLruCache$Editor r0 = new com.pwrd.android.volley.plus.DiskLruCache$Editor
            r2 = 0
            r0.<init>(r6, r1, r2)
            com.pwrd.android.volley.plus.DiskLruCache.Entry.access$5(r1, r0)
            java.io.Writer r2 = r6.journalWriter
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DIRTY "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            r4 = 10
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.write(r3)
            java.io.Writer r2 = r6.journalWriter
            r2.flush()
            goto L_0x0020
        L_0x0058:
            r2 = move-exception
            monitor-exit(r6)
            throw r2
        L_0x005b:
            com.pwrd.android.volley.plus.DiskLruCache$Editor r2 = com.pwrd.android.volley.plus.DiskLruCache.Entry.access$0(r1)
            if (r2 == 0) goto L_0x002f
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pwrd.android.volley.plus.DiskLruCache.edit(java.lang.String, long):com.pwrd.android.volley.plus.DiskLruCache$Editor");
    }

    public File getDirectory() {
        return this.directory;
    }

    public long maxSize() {
        return this.maxSize;
    }

    public synchronized long size() {
        return this.size;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void completeEdit(Editor editor, boolean success) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new IllegalStateException();
        }
        if (success && !entry.readable) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!entry.getDirtyFile(i).exists()) {
                    editor.abort();
                    throw new IllegalStateException("edit didn't create file " + i);
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            File dirty = entry.getDirtyFile(i2);
            if (!success) {
                deleteIfExists(dirty);
            } else if (dirty.exists()) {
                File clean = entry.getCleanFile(i2);
                if (!dirty.renameTo(clean)) {
                    Log.e("ImageCache", "failed to rename image file to: " + clean);
                }
                if (!entry.persistent) {
                    long oldLength = entry.lengths[i2];
                    long newLength = clean.length();
                    entry.lengths[i2] = newLength;
                    this.size = (this.size - oldLength) + newLength;
                }
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable || success) {
            entry.readable = true;
            this.journalWriter.write(entry.persistent ? PERSISTENT : "CLEAN " + entry.key + entry.getLengths() + '\n');
            if (success) {
                long j = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j;
                entry.sequenceNumber = j;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.write("REMOVE " + entry.key + '\n');
        }
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public synchronized boolean remove(String key) throws IOException {
        boolean z;
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null || entry.currentEditor != null || entry.persistent) {
            z = false;
        } else {
            for (int i = 0; i < this.valueCount; i++) {
                File file = entry.getCleanFile(i);
                if (!file.delete()) {
                    throw new IOException("failed to delete " + file);
                }
                this.size -= entry.lengths[i];
                entry.lengths[i] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.append((CharSequence) ("REMOVE " + key + '\n'));
            this.lruEntries.remove(key);
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            z = true;
        }
        return z;
    }

    public boolean isClosed() {
        return this.journalWriter == null;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    public void delete() throws IOException {
        close();
        deleteContents(this.directory);
    }

    private void validateKey(String key) {
        if (key == null) {
            return;
        }
        if (key.contains(" ") || key.contains(IOUtils.LINE_SEPARATOR_UNIX) || key.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + key + "\"");
        }
    }

    /* access modifiers changed from: private */
    public static String inputStreamToString(InputStream in) throws IOException {
        return readFully(new InputStreamReader(in, UTF_8));
    }

    public final class Snapshot implements Closeable {
        private final InputStream[] ins;
        private final String key;
        private final long sequenceNumber;

        private Snapshot(String key2, long sequenceNumber2, InputStream[] ins2) {
            this.key = key2;
            this.sequenceNumber = sequenceNumber2;
            this.ins = ins2;
        }

        /* synthetic */ Snapshot(DiskLruCache diskLruCache, String str, long j, InputStream[] inputStreamArr, Snapshot snapshot) {
            this(str, j, inputStreamArr);
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public InputStream getInputStream(int index) {
            return this.ins[index];
        }

        public String getString(int index) throws IOException {
            return DiskLruCache.inputStreamToString(getInputStream(index));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream in : this.ins) {
                DiskLruCache.closeQuietly(in);
            }
        }
    }

    public final class Editor {
        private final Entry entry;
        private boolean hasErrors;

        private Editor(Entry entry2) {
            this.entry = entry2;
        }

        /* synthetic */ Editor(DiskLruCache diskLruCache, Entry entry2, Editor editor) {
            this(entry2);
        }

        public InputStream newInputStream(int index) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (!this.entry.readable) {
                    return null;
                } else {
                    return new FileInputStream(this.entry.getCleanFile(index));
                }
            }
        }

        public String getString(int index) throws IOException {
            InputStream in = newInputStream(index);
            if (in != null) {
                return DiskLruCache.inputStreamToString(in);
            }
            return null;
        }

        public OutputStream newOutputStream(int index) throws IOException {
            FaultHidingOutputStream faultHidingOutputStream;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                faultHidingOutputStream = new FaultHidingOutputStream(this, new FileOutputStream(this.entry.getDirtyFile(index)), null);
            }
            return faultHidingOutputStream;
        }

        public void set(int index, String value) throws IOException {
            Throwable th;
            Writer writer = null;
            try {
                Writer writer2 = new OutputStreamWriter(newOutputStream(index), DiskLruCache.UTF_8);
                try {
                    writer2.write(value);
                    DiskLruCache.closeQuietly(writer2);
                } catch (Throwable th2) {
                    th = th2;
                    writer = writer2;
                    DiskLruCache.closeQuietly(writer);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                DiskLruCache.closeQuietly(writer);
                throw th;
            }
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
                return;
            }
            DiskLruCache.this.completeEdit(this, true);
        }

        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        /* access modifiers changed from: private */
        public class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream out) {
                super(out);
            }

            /* synthetic */ FaultHidingOutputStream(Editor editor, OutputStream outputStream, FaultHidingOutputStream faultHidingOutputStream) {
                this(outputStream);
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(int oneByte) {
                try {
                    this.out.write(oneByte);
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(byte[] buffer, int offset, int length) {
                try {
                    this.out.write(buffer, offset, length);
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final class Entry {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean persistent;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String key2) {
            this.key = key2;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }

        /* synthetic */ Entry(DiskLruCache diskLruCache, String str, Entry entry) {
            this(str);
        }

        public String getLengths() throws IOException {
            StringBuilder result = new StringBuilder();
            for (long size : this.lengths) {
                result.append(' ').append(size);
            }
            return result.toString();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setLengths(String[] strings) throws IOException {
            if (strings.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strings);
            }
            for (int i = 0; i < strings.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strings[i]);
                } catch (NumberFormatException e) {
                    throw invalidLengths(strings);
                }
            }
        }

        private IOException invalidLengths(String[] strings) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strings));
        }

        public File getCleanFile(int i) {
            return new File(DiskLruCache.this.directory, String.valueOf(this.key) + "." + i);
        }

        public File getDirtyFile(int i) {
            return new File(DiskLruCache.this.directory, String.valueOf(this.key) + "." + i + ".tmp");
        }
    }
}
