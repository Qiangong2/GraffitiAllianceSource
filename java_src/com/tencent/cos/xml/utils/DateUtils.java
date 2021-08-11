package com.tencent.cos.xml.utils;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static final String GMT_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";

    public static Date toDate(String gmt) throws CosXmlClientException {
        try {
            return new SimpleDateFormat(GMT_TIME_FORMAT, Locale.ENGLISH).parse(gmt);
        } catch (ParseException e) {
            throw new CosXmlClientException(e);
        }
    }

    public static String toString(Date date) {
        return new SimpleDateFormat(GMT_TIME_FORMAT, Locale.ENGLISH).format(date);
    }

    public static String toString(long dateSeconds) {
        return new SimpleDateFormat(GMT_TIME_FORMAT, Locale.ENGLISH).format(new Date(dateSeconds));
    }
}
