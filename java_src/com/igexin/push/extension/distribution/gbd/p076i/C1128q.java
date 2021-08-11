package com.igexin.push.extension.distribution.gbd.p076i;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.gbd.i.q */
public class C1128q<E> {

    /* renamed from: a */
    private Comparator<E> f2984a;

    /* renamed from: b */
    private int f2985b;

    public C1128q(Comparator<E> comparator) {
        mo5890a(comparator);
    }

    /* renamed from: a */
    private boolean m4632a(List<E> list, int i, int i2, E e) {
        boolean z;
        int i3 = i2;
        int i4 = i;
        while (true) {
            if (i4 > i3) {
                z = false;
                break;
            }
            int i5 = (i4 + i3) >> 1;
            int compare = this.f2984a.compare(list.get(i5), e);
            if (compare == 0) {
                z = true;
                i4 = i5;
                break;
            } else if (compare < 0) {
                i4 = i5 + 1;
            } else {
                i3 = i5 - 1;
            }
        }
        this.f2985b = i4;
        return z;
    }

    /* renamed from: a */
    public List<E> mo5889a(List<E> list, List<E> list2) {
        int i;
        int i2;
        if (this.f2984a == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int size = list.size();
        int size2 = list2.size();
        int i3 = size - 1;
        int i4 = size2 - 1;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size && i5 < size2) {
            E e = list.get(i6);
            E e2 = list2.get(i5);
            int compare = this.f2984a.compare(e, e2);
            if (compare == 0) {
                arrayList.add(e);
                i6++;
                i = i5 + 1;
            } else if (compare < 0) {
                if (m4632a(list, i6 + 1, i3, e2)) {
                    arrayList.add(e2);
                    i2 = this.f2985b + 1;
                } else {
                    i2 = this.f2985b;
                }
                i6 = i2;
                i = i5 + 1;
            } else if (m4632a(list2, i5 + 1, i4, e)) {
                arrayList.add(e);
                i = this.f2985b + 1;
                i6++;
            } else {
                i = this.f2985b;
                i6++;
            }
            i5 = i;
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo5890a(Comparator<E> comparator) {
        this.f2984a = comparator;
    }
}
