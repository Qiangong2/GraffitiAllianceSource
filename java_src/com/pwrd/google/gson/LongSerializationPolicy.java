package com.pwrd.google.gson;

public enum LongSerializationPolicy {
    DEFAULT {
        @Override // com.pwrd.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long value) {
            return new JsonPrimitive((Number) value);
        }
    },
    STRING {
        @Override // com.pwrd.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long value) {
            return new JsonPrimitive(String.valueOf(value));
        }
    };

    public abstract JsonElement serialize(Long l);

    /* synthetic */ LongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this();
    }
}
