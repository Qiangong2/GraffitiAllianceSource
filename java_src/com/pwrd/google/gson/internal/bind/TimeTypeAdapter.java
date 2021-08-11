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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        /* class com.pwrd.google.gson.internal.bind.TimeTypeAdapter.C12731 */

        @Override // com.pwrd.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.pwrd.google.gson.TypeAdapter
    public synchronized Time read(JsonReader in) throws IOException {
        Time time;
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.format.parse(in.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    public synchronized void write(JsonWriter out, Time value) throws IOException {
        out.value(value == null ? null : this.format.format(value));
    }
}
