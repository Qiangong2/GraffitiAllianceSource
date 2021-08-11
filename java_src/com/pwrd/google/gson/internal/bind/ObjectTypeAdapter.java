package com.pwrd.google.gson.internal.bind;

import com.pwrd.google.gson.Gson;
import com.pwrd.google.gson.TypeAdapter;
import com.pwrd.google.gson.TypeAdapterFactory;
import com.pwrd.google.gson.internal.LinkedTreeMap;
import com.pwrd.google.gson.reflect.TypeToken;
import com.pwrd.google.gson.stream.JsonReader;
import com.pwrd.google.gson.stream.JsonToken;
import com.pwrd.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken;
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        /* class com.pwrd.google.gson.internal.bind.ObjectTypeAdapter.C12701 */

        @Override // com.pwrd.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (type.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson, null);
            }
            return null;
        }
    };
    private final Gson gson;

    static /* synthetic */ int[] $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken() {
        int[] iArr = $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken;
        if (iArr == null) {
            iArr = new int[JsonToken.values().length];
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[JsonToken.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[JsonToken.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken = iArr;
        }
        return iArr;
    }

    private ObjectTypeAdapter(Gson gson2) {
        this.gson = gson2;
    }

    /* synthetic */ ObjectTypeAdapter(Gson gson2, ObjectTypeAdapter objectTypeAdapter) {
        this(gson2);
    }

    @Override // com.pwrd.google.gson.TypeAdapter
    public Object read(JsonReader in) throws IOException {
        switch ($SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken()[in.peek().ordinal()]) {
            case 1:
                List<Object> list = new ArrayList<>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(read(in));
                }
                in.endArray();
                return list;
            case 2:
            case 4:
            case 5:
            default:
                throw new IllegalStateException();
            case 3:
                Map<String, Object> map = new LinkedTreeMap<>();
                in.beginObject();
                while (in.hasNext()) {
                    map.put(in.nextName(), read(in));
                }
                in.endObject();
                return map;
            case 6:
                return in.nextString();
            case 7:
                return Double.valueOf(in.nextDouble());
            case 8:
                return Boolean.valueOf(in.nextBoolean());
            case 9:
                in.nextNull();
                return null;
        }
    }

    @Override // com.pwrd.google.gson.TypeAdapter
    public void write(JsonWriter out, Object value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        TypeAdapter<Object> typeAdapter = this.gson.getAdapter(value.getClass());
        if (typeAdapter instanceof ObjectTypeAdapter) {
            out.beginObject();
            out.endObject();
            return;
        }
        typeAdapter.write(out, value);
    }
}
