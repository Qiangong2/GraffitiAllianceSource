package com.pwrd.google.gson.internal.bind;

import com.pwrd.google.gson.JsonArray;
import com.pwrd.google.gson.JsonElement;
import com.pwrd.google.gson.JsonNull;
import com.pwrd.google.gson.JsonObject;
import com.pwrd.google.gson.JsonPrimitive;
import com.pwrd.google.gson.stream.JsonReader;
import com.pwrd.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED = new Object();
    private static final Reader UNREADABLE_READER = new Reader() {
        /* class com.pwrd.google.gson.internal.bind.JsonTreeReader.C12681 */

        @Override // java.io.Reader
        public int read(char[] buffer, int offset, int count) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Closeable, java.io.Reader, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private final List<Object> stack = new ArrayList();

    public JsonTreeReader(JsonElement element) {
        super(UNREADABLE_READER);
        this.stack.add(element);
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        this.stack.add(((JsonArray) peekStack()).iterator());
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        this.stack.add(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        popStack();
        popStack();
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken token = peek();
        return (token == JsonToken.END_OBJECT || token == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.stack.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Object o = peekStack();
        if (o instanceof Iterator) {
            boolean isObject = this.stack.get(this.stack.size() - 2) instanceof JsonObject;
            Iterator<?> iterator = (Iterator) o;
            if (!iterator.hasNext()) {
                return isObject ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (isObject) {
                return JsonToken.NAME;
            }
            this.stack.add(iterator.next());
            return peek();
        } else if (o instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (o instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (o instanceof JsonPrimitive) {
                JsonPrimitive primitive = (JsonPrimitive) o;
                if (primitive.isString()) {
                    return JsonToken.STRING;
                }
                if (primitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (primitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (o instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (o == SENTINEL_CLOSED) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object peekStack() {
        return this.stack.get(this.stack.size() - 1);
    }

    private Object popStack() {
        return this.stack.remove(this.stack.size() - 1);
    }

    private void expect(JsonToken expected) throws IOException {
        if (peek() != expected) {
            throw new IllegalStateException("Expected " + expected + " but was " + peek());
        }
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry<?, ?> entry = (Map.Entry) ((Iterator) peekStack()).next();
        this.stack.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.STRING || token == JsonToken.NUMBER) {
            return ((JsonPrimitive) popStack()).getAsString();
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + token);
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        return ((JsonPrimitive) popStack()).getAsBoolean();
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            double result = ((JsonPrimitive) peekStack()).getAsDouble();
            if (isLenient() || (!Double.isNaN(result) && !Double.isInfinite(result))) {
                popStack();
                return result;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + result);
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token);
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            long result = ((JsonPrimitive) peekStack()).getAsLong();
            popStack();
            return result;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token);
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            int result = ((JsonPrimitive) peekStack()).getAsInt();
            popStack();
            return result;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token);
    }

    @Override // com.pwrd.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack.clear();
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
        } else {
            popStack();
        }
    }

    @Override // com.pwrd.google.gson.stream.JsonReader
    public String toString() {
        return getClass().getSimpleName();
    }

    public void promoteNameToValue() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry<?, ?> entry = (Map.Entry) ((Iterator) peekStack()).next();
        this.stack.add(entry.getValue());
        this.stack.add(new JsonPrimitive((String) entry.getKey()));
    }
}
