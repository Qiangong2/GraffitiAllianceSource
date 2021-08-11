package com.pwrd.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {
    public abstract <T> T newInstance(Class<T> cls) throws Exception;

    public static UnsafeAllocator create() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            final Object unsafe = f.get(null);
            final Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
            return new UnsafeAllocator() {
                /* class com.pwrd.google.gson.internal.UnsafeAllocator.C12621 */

                @Override // com.pwrd.google.gson.internal.UnsafeAllocator
                public <T> T newInstance(Class<T> c) throws Exception {
                    return (T) allocateInstance.invoke(unsafe, c);
                }
            };
        } catch (Exception e) {
            try {
                Method getConstructorId = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                getConstructorId.setAccessible(true);
                final int constructorId = ((Integer) getConstructorId.invoke(null, Object.class)).intValue();
                final Method newInstance = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                newInstance.setAccessible(true);
                return new UnsafeAllocator() {
                    /* class com.pwrd.google.gson.internal.UnsafeAllocator.C12632 */

                    @Override // com.pwrd.google.gson.internal.UnsafeAllocator
                    public <T> T newInstance(Class<T> c) throws Exception {
                        return (T) newInstance.invoke(null, c, Integer.valueOf(constructorId));
                    }
                };
            } catch (Exception e2) {
                try {
                    final Method newInstance2 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    newInstance2.setAccessible(true);
                    return new UnsafeAllocator() {
                        /* class com.pwrd.google.gson.internal.UnsafeAllocator.C12643 */

                        @Override // com.pwrd.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> c) throws Exception {
                            return (T) newInstance2.invoke(null, c, Object.class);
                        }
                    };
                } catch (Exception e3) {
                    return new UnsafeAllocator() {
                        /* class com.pwrd.google.gson.internal.UnsafeAllocator.C12654 */

                        @Override // com.pwrd.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> c) {
                            throw new UnsupportedOperationException("Cannot allocate " + c);
                        }
                    };
                }
            }
        }
    }
}
