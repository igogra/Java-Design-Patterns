package behavioral.template;

abstract class OS {
	protected boolean status;

	public abstract void start();

	public abstract void run();

	public abstract void shutdown();

	public void testOS() {
		start();
		if (this.status) {
			run();
			shutdown();
		}
	}
}

class Linux extends OS {
	@Override
	public void start() {
		this.status = true;
		System.out.println("Linux starts");
	}

	@Override
	public void run() {
		System.out.println("Run fast");

	}

	@Override
	public void shutdown() {
		System.out.println("Linux stops");
	}
}

class Windows extends OS {
	@Override
	public void start() {
		this.status = true;
		System.out.println("Windows starts");
	}

	@Override
	public void run() {
		System.out.println("Run slowly");

	}

	@Override
	public void shutdown() {
		System.out.println("Windows stops");
	}
}

public class DemoTemplate {
	public static void main(String[] args) {
		OS windows = new Windows();
		windows.testOS();

		OS linux = new Linux();
		linux.testOS();
	}
}
