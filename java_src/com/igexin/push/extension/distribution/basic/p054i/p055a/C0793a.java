package com.igexin.push.extension.distribution.basic.p054i.p055a;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0809e;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import com.igexin.push.extension.distribution.basic.p054i.p057c.C0825ad;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.a */
public class C0793a {

    /* renamed from: a */
    private static final Pattern f2241a = Pattern.compile("(?i)\\bcharset=\\s*\"?([^\\s;\"]*)");

    /* renamed from: a */
    static C0809e m3332a(ByteBuffer byteBuffer, String str, String str2, C0825ad adVar) {
        String charBuffer;
        C0809e eVar;
        String str3;
        C0809e eVar2 = null;
        if (str == null) {
            String charBuffer2 = Charset.forName("UTF-8").decode(byteBuffer).toString();
            C0809e a = adVar.mo5406a(charBuffer2, str2);
            C0813i c = a.mo5327a("meta[http-equiv=content-type], meta[charset]").mo5585c();
            if (c != null) {
                String a2 = c.mo5365e("http-equiv") ? m3333a(c.mo5362d("content")) : c.mo5362d("charset");
                if (!(a2 == null || a2.length() == 0 || a2.equals("UTF-8"))) {
                    byteBuffer.rewind();
                    str3 = Charset.forName(a2).decode(byteBuffer).toString();
                    str = a2;
                    charBuffer = str3;
                    eVar = eVar2;
                }
            }
            eVar2 = a;
            str3 = charBuffer2;
            charBuffer = str3;
            eVar = eVar2;
        } else {
            C0803k.m3396a(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            charBuffer = Charset.forName(str).decode(byteBuffer).toString();
            eVar = null;
        }
        if (eVar != null) {
            return eVar;
        }
        if (charBuffer.charAt(0) == 65279) {
            charBuffer = charBuffer.substring(1);
        }
        C0809e a3 = adVar.mo5406a(charBuffer, str2);
        a3.mo5311d().mo5316a(str);
        return a3;
    }

    /* renamed from: a */
    static String m3333a(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f2241a.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).trim().toUpperCase();
        }
        return null;
    }

    /* renamed from: a */
    static ByteBuffer m3334a(InputStream inputStream) {
        byte[] bArr = new byte[131072];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(131072);
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
