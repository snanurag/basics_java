package reflection.proxy;

public class ProxyClient {

	public static void main(String[] args) {
	    Foo foo = (Foo) DebugProxy.newInstance(FooImpl.class);
	    foo.bar(null);
	}

}
