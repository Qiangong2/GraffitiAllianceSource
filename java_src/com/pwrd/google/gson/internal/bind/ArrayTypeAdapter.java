package com.pwrd.google.gson.internal.bind;

import com.pwrd.google.gson.Gson;
import com.pwrd.google.gson.TypeAdapter;
import com.pwrd.google.gson.TypeAdapterFactory;
import com.pwrd.google.gson.internal.C$Gson$Types;
import com.pwrd.google.gson.reflect.TypeToken;
import com.pwrd.google.gson.stream.JsonReader;
import com.pwrd.google.gson.stream.JsonToken;
import com.pwrd.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        /* class com.pwrd.google.gson.internal.bind.ArrayTypeAdapter.C12661 */

        @Override // com.pwrd.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type componentType = C$Gson$Types.getArrayComponentType(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(componentType)), C$Gson$Types.getRawType(componentType));
        }
    };
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    public ArrayTypeAdapter(Gson context, TypeAdapter<E> componentTypeAdapter2, Class<E> componentType2) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, componentTypeAdapter2, componentType2);
        this.componentType = componentType2;
    }

    @Override // com.pwrd.google.gson.TypeAdapter
    public Object read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        List<E> list = new ArrayList<>();
        in.beginArray();
        while (in.hasNext()) {
            list.add(this.componentTypeAdapter.read(in));
        }
        in.endArray();
        Object array = Array.newInstance((Class<?>) this.componentType, list.size());
        for (int i = 0; i < list.size(); i++) {
            Array.set(array, i, list.get(i));
        }
        return array;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.pwrd.google.gson.TypeAdapter<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.pwrd.google.gson.TypeAdapter
    public void write(JsonWriter out, Object array) throws IOException {
        if (array == null) {
            out.nullValue();
            return;
        }
        out.beginArray();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(out, Array.get(array, i));
        }
        out.endArray();
    }
}
