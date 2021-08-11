package android.support.p007v4.util;

/* renamed from: android.support.v4.util.Pools */
public final class Pools {

    /* renamed from: android.support.v4.util.Pools$Pool */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    private Pools() {
    }

    /* renamed from: android.support.v4.util.Pools$SimplePool */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int maxPoolSize) {
            if (maxPoolSize <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[maxPoolSize];
        }

        @Override // android.support.p007v4.util.Pools.Pool
        public T acquire() {
            if (this.mPoolSize <= 0) {
                return null;
            }
            int lastPooledIndex = this.mPoolSize - 1;
            T instance = (T) this.mPool[lastPooledIndex];
            this.mPool[lastPooledIndex] = null;
            this.mPoolSize--;
            return instance;
        }

        @Override // android.support.p007v4.util.Pools.Pool
        public boolean release(T instance) {
            if (isInPool(instance)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.mPoolSize >= this.mPool.length) {
                return false;
            } else {
                this.mPool[this.mPoolSize] = instance;
                this.mPoolSize++;
                return true;
            }
        }

        private boolean isInPool(T instance) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == instance) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.util.Pools$SynchronizedPool */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock = new Object();

        public SynchronizedPool(int maxPoolSize) {
            super(maxPoolSize);
        }

        @Override // android.support.p007v4.util.Pools.SimplePool, android.support.p007v4.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // android.support.p007v4.util.Pools.SimplePool, android.support.p007v4.util.Pools.Pool
        public boolean release(T element) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(element);
            }
            return release;
        }
    }
}