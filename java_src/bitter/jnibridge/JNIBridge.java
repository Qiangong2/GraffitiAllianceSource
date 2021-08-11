package bitter.jnibridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JNIBridge {

    /* renamed from: bitter.jnibridge.JNIBridge$a */
    private static class C0211a implements InvocationHandler {

        /* renamed from: a */
        private Object f154a = new Object[0];

        /* renamed from: b */
        private long f155b;

        public C0211a(long j) {
            this.f155b = j;
        }

        /* renamed from: a */
        public final void mo3477a() {
            synchronized (this.f154a) {
                this.f155b = 0;
            }
        }

        @Override // java.lang.Object
        public final void finalize() {
            synchronized (this.f154a) {
                if (this.f155b != 0) {
                    JNIBridge.delete(this.f155b);
                }
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object invoke;
            synchronized (this.f154a) {
                invoke = this.f155b == 0 ? null : JNIBridge.invoke(this.f155b, method.getDeclaringClass(), method, objArr);
            }
            return invoke;
        }
    }

    static native void delete(long j);

    static void disableInterfaceProxy(Object obj) {
        ((C0211a) Proxy.getInvocationHandler(obj)).mo3477a();
    }

    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new C0211a(j));
    }
}
