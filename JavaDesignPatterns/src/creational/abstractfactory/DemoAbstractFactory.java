package creational.abstractfactory;

interface Coke {
	public void drink();
}

interface CokeFactory {
	public Coke produceCoke();
}

class CocaColaFactory implements CokeFactory {
	@Override
	public Coke produceCoke() {
		return new CocaCola();
	}
}

class PepsiFactory implements CokeFactory {
	@Override
	public Coke produceCoke() {
		return new Pepsi();
	}
}

class CocaCola implements Coke {
	@Override
	public void drink() {
		System.out.println("Drink Coca-Cola");
	}
}

class Pepsi implements Coke {
	@Override
	public void drink() {
		System.out.println("Drink Pepsi");
	}
}

class Beverage {
	public Beverage(CokeFactory factory) {
		Coke coke = factory.produceCoke();
		coke.drink();
	}
}

public class DemoAbstractFactory {
	public static void main(String[] args) {
		new Beverage(createCokeFactory("pepsi"));
		
		new Beverage(createCokeFactory("cocacola"));
	}

	public static CokeFactory createCokeFactory(String typeBeverage) {
		if (typeBeverage.equals("pepsi")) {
			return new PepsiFactory();
		} else {
			return new CocaColaFactory();
		}
	}
}
