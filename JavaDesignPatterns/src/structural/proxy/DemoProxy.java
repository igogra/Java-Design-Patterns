package structural.proxy;

interface Internet {
	public void connect();
}

class ProxyAccess implements Internet {
	@Override
	public void connect() {
		System.out.println("Connecting to Internet from proxy...");
	}

}

class InternetAccess implements Internet {
	private Internet internet;

	public InternetAccess() {
		this.internet = new ProxyAccess();
	}

	public InternetAccess(Internet internet) {
		this.internet = internet;
	}

	@Override
	public void connect() {
		internet.connect();
	}
}

public class DemoProxy {
	public static void main(String[] args) {
		InternetAccess internetAccess = new InternetAccess();
		internetAccess.connect();
	}
}
