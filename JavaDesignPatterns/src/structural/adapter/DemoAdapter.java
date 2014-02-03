package structural.adapter;

class AmericaPlug {
	public void supplyAmerica() {
		System.out.println("Power from American plug");
	}
}

class EuropePlug {
	public void supplyEurope() {
		System.out.println("Power from European plug");
	}
}

class AmericaAdapter extends AmericaPlug {
	private EuropePlug europePlug;

	public AmericaAdapter(EuropePlug europePlug) {
		this.europePlug = europePlug;
	}

	@Override
	public void supplyAmerica() {
		europePlug.supplyEurope();
	}
}

public class DemoAdapter {
	public static void main(String[] args) {
		// Plug in an American plug in America
		AmericaPlug americaPlug = new AmericaPlug();
		americaPlug.supplyAmerica();

		EuropePlug europePlug = new EuropePlug();

		// Plug in a European plug in America using an American adapter
		AmericaAdapter americaAdapter = new AmericaAdapter(europePlug);
		americaAdapter.supplyAmerica();
	}
}
