package com.pwrd.google.gson.internal.bind;

import com.pwrd.google.gson.FieldNamingStrategy;
import com.pwrd.google.gson.Gson;
import com.pwrd.google.gson.JsonSyntaxException;
import com.pwrd.google.gson.TypeAdapter;
import com.pwrd.google.gson.TypeAdapterFactory;
import com.pwrd.google.gson.annotations.JsonAdapter;
import com.pwrd.google.gson.annotations.SerializedName;
import com.pwrd.google.gson.internal.C$Gson$Types;
import com.pwrd.google.gson.internal.ConstructorConstructor;
import com.pwrd.google.gson.internal.Excluder;
import com.pwrd.google.gson.internal.ObjectConstructor;
import com.pwrd.google.gson.internal.Primitives;
import com.pwrd.google.gson.reflect.TypeToken;
import com.pwrd.google.gson.stream.JsonReader;
import com.pwrd.google.gson.stream.JsonToken;
import com.pwrd.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingPolicy2, Excluder excluder2) {
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingPolicy2;
        this.excluder = excluder2;
    }

    public boolean excludeField(Field f, boolean serialize) {
        return excludeField(f, serialize, this.excluder);
    }

    static boolean excludeField(Field f, boolean serialize, Excluder excluder2) {
        return !excluder2.excludeClass(f.getType(), serialize) && !excluder2.excludeField(f, serialize);
    }

    private List<String> getFieldNames(Field f) {
        return getFieldName(this.fieldNamingPolicy, f);
    }

    static List<String> getFieldName(FieldNamingStrategy fieldNamingPolicy2, Field f) {
        SerializedName serializedName = (SerializedName) f.getAnnotation(SerializedName.class);
        List<String> fieldNames = new LinkedList<>();
        if (serializedName == null) {
            fieldNames.add(fieldNamingPolicy2.translateName(f));
        } else {
            fieldNames.add(serializedName.value());
            for (String alternate : serializedName.alternate()) {
                fieldNames.add(alternate);
            }
        }
        return fieldNames;
    }

    @Override // com.pwrd.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> raw = type.getRawType();
        if (!Object.class.isAssignableFrom(raw)) {
            return null;
        }
        return new Adapter(this.constructorConstructor.get(type), getBoundFields(gson, type, raw), null);
    }

    private BoundField createBoundField(Gson context, Field field, String name, TypeToken<?> fieldType, boolean serialize, boolean deserialize) {
        return new BoundField(name, serialize, deserialize, context, field, fieldType, Primitives.isPrimitive(fieldType.getRawType())) {
            /* class com.pwrd.google.gson.internal.bind.ReflectiveTypeAdapterFactory.C12711 */
            final TypeAdapter<?> typeAdapter;
            private final /* synthetic */ Gson val$context;
            private final /* synthetic */ Field val$field;
            private final /* synthetic */ TypeToken val$fieldType;
            private final /* synthetic */ boolean val$isPrimitive;

            {
                this.val$context = r6;
                this.val$field = r7;
                this.val$fieldType = r8;
                this.val$isPrimitive = r9;
                this.typeAdapter = ReflectiveTypeAdapterFactory.this.getFieldAdapter(r6, r7, r8);
            }

            /* access modifiers changed from: package-private */
            @Override // com.pwrd.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void write(JsonWriter writer, Object value) throws IOException, IllegalAccessException {
                new TypeAdapterRuntimeTypeWrapper(this.val$context, this.typeAdapter, this.val$fieldType.getType()).write(writer, this.val$field.get(value));
            }

            /* access modifiers changed from: package-private */
            @Override // com.pwrd.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void read(JsonReader reader, Object value) throws IOException, IllegalAccessException {
                Object fieldValue = this.typeAdapter.read(reader);
                if (fieldValue != null || !this.val$isPrimitive) {
                    this.val$field.set(value, fieldValue);
                }
            }

            @Override // com.pwrd.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object value) throws IOException, IllegalAccessException {
                if (this.serialized && this.val$field.get(value) != value) {
                    return true;
                }
                return false;
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private TypeAdapter<?> getFieldAdapter(Gson gson, Field field, TypeToken<?> fieldType) {
        TypeAdapter<?> adapter;
        JsonAdapter annotation = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        return (annotation == null || (adapter = JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, fieldType, annotation)) == null) ? gson.getAdapter(fieldType) : adapter;
    }

    private Map<String, BoundField> getBoundFields(Gson context, TypeToken<?> type, Class<?> raw) {
        Map<String, BoundField> result = new LinkedHashMap<>();
        if (!raw.isInterface()) {
            Type declaredType = type.getType();
            while (raw != Object.class) {
                Field[] fields = raw.getDeclaredFields();
                int length = fields.length;
                for (int i = 0; i < length; i++) {
                    Field field = fields[i];
                    boolean serialize = excludeField(field, true);
                    boolean deserialize = excludeField(field, false);
                    if (serialize || deserialize) {
                        field.setAccessible(true);
                        Type fieldType = C$Gson$Types.resolve(type.getType(), raw, field.getGenericType());
                        List<String> fieldNames = getFieldNames(field);
                        BoundField previous = null;
                        for (int i2 = 0; i2 < fieldNames.size(); i2++) {
                            String name = fieldNames.get(i2);
                            if (i2 != 0) {
                                serialize = false;
                            }
                            BoundField replaced = result.put(name, createBoundField(context, field, name, TypeToken.get(fieldType), serialize, deserialize));
                            if (previous == null) {
                                previous = replaced;
                            }
                        }
                        if (previous != null) {
                            throw new IllegalArgumentException(declaredType + " declares multiple JSON fields named " + previous.name);
                        }
                    }
                }
                type = TypeToken.get(C$Gson$Types.resolve(type.getType(), raw, raw.getGenericSuperclass()));
                raw = type.getRawType();
            }
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        /* access modifiers changed from: package-private */
        public abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean writeField(Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String name2, boolean serialized2, boolean deserialized2) {
            this.name = name2;
            this.serialized = serialized2;
            this.deserialized = deserialized2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        private Adapter(ObjectConstructor<T> constructor2, Map<String, BoundField> boundFields2) {
            this.constructor = constructor2;
            this.boundFields = boundFields2;
        }

        /* synthetic */ Adapter(ObjectConstructor objectConstructor, Map map, Adapter adapter) {
            this(objectConstructor, map);
        }

        @Override // com.pwrd.google.gson.TypeAdapter
        public T read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            T instance = this.constructor.construct();
            try {
                in.beginObject();
                while (in.hasNext()) {
                    BoundField field = this.boundFields.get(in.nextName());
                    if (field == null || !field.deserialized) {
                        in.skipValue();
                    } else {
                        field.read(in, instance);
                    }
                }
                in.endObject();
                return instance;
            } catch (IllegalStateException e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.pwrd.google.gson.TypeAdapter
        public void write(JsonWriter out, T value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(value)) {
                        out.name(boundField.name);
                        boundField.write(out, value);
                    }
                }
                out.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }
}
