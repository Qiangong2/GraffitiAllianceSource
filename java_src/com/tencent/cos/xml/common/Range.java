package com.tencent.cos.xml.common;

public class Range {
    private long end;
    private long start;

    public Range(long start2, long end2) {
        this.start = start2;
        this.end = end2;
    }

    public Range(long start2) {
        this(start2, -1);
    }

    public long getEnd() {
        return this.end;
    }

    public long getStart() {
        return this.start;
    }

    public String getRange() {
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.start);
        objArr[1] = this.end == -1 ? "" : String.valueOf(this.end);
        return String.format("bytes=%s-%s", objArr);
    }
}
