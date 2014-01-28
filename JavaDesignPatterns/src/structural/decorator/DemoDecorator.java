package structural.decorator;

interface Pizza {
	public String makePizza();
}

class SimplePizza implements Pizza {
	@Override
	public String makePizza() {
		return "Base Pizza";
	}
}

abstract class PizzaDecorator implements Pizza {
	public abstract String makePizza();
}

class MushroomDecorator extends PizzaDecorator {
	private Pizza pizza;

	public MushroomDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	public String makePizza() {
		return pizza.makePizza() + " + Mushrooms";
	}
}

class OnionDecorator extends PizzaDecorator {
	private Pizza pizza;

	public OnionDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	public String makePizza() {
		return pizza.makePizza() + " + Onion";
	}
}

public class DemoDecorator {
	public static void main(String[] args) {
		Pizza basePizza = new SimplePizza();
		System.out.println(basePizza.makePizza());

		Pizza specialPizza = new OnionDecorator(
				new MushroomDecorator(basePizza));
		System.out.println(specialPizza.makePizza());
	}
}
