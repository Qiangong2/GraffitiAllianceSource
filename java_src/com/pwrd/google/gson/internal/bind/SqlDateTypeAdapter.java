package com.pwrd.google.gson.internal.bind;

import com.pwrd.google.gson.Gson;
import com.pwrd.google.gson.JsonSyntaxException;
import com.pwrd.google.gson.TypeAdapter;
import com.pwrd.google.gson.TypeAdapterFactory;
import com.pwrd.google.gson.reflect.TypeToken;
import com.pwrd.google.gson.stream.JsonReader;
import com.pwrd.google.gson.stream.JsonToken;
import com.pwrd.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        /* class com.pwrd.google.gson.internal.bind.SqlDateTypeAdapter.C12721 */

        @Override // com.pwrd.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.pwrd.google.gson.TypeAdapter
    public synchronized Date read(JsonReader in) throws IOException {
        Date date;
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.format.parse(in.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    public synchronized void write(JsonWriter out, Date value) throws IOException {
        out.value(value == null ? null : this.format.format(value));
    }
}
