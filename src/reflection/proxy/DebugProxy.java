package reflection.proxy;

public class DebugProxy {

    public static Object newInstance(Class cl) {
        return java.lang.reflect.Proxy.newProxyInstance(
                cl.getClassLoader(),
                cl.getInterfaces(),
                new Handler(cl));
    }
}
