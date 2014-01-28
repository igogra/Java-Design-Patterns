package structural.flyweight;

import java.util.HashMap;

// Flyweight object interface
interface ICocktail {
	public void serveCocktail(CocktailContext context);
}

// Concrete Flyweight object
class Cocktail implements ICocktail {
	private final String name;

	public Cocktail(String name) {
		this.name = name;
		System.out.println(name + " created");
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void serveCocktail(CocktailContext context) {
		System.out.println("Serving " + name + " to table "
				+ context.getTable());
	}
}

// A context, here is table number
class CocktailContext {
	private final int tableNumber;

	public CocktailContext(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getTable() {
		return this.tableNumber;
	}
}

// The FlyweightFactory!
class CocktailFactory {
	private HashMap<String, Cocktail> cocktails = new HashMap<String, Cocktail>();

	public Cocktail getCocktailName(String cocktailName) {
		Cocktail name = cocktails.get(cocktailName);
		if (name == null) {
			name = new Cocktail(cocktailName);
			cocktails.put(cocktailName, name);
		}
		return name;
	}

	public int getTotalCocktailsMade() {
		return cocktails.size();
	}
}

public class DemoFlyweight {
	private static Cocktail[] cocktails = new Cocktail[20];

	private static CocktailContext[] tables = new CocktailContext[20];
	private static int ordersCount = 0;
	private static CocktailFactory cocktailFactory;

	public static void takeOrder(String cocktailIn, int table) {
		cocktails[ordersCount] = cocktailFactory.getCocktailName(cocktailIn);
		tables[ordersCount] = new CocktailContext(table);
		ordersCount++;
	}

	public static void main(String[] args) {
		cocktailFactory = new CocktailFactory();

		takeOrder("Mojito", 2);
		takeOrder("Pina Colada", 2);
		takeOrder("Pina Colada", 1);
		takeOrder("Mojito", 2);
		takeOrder("Mojito", 3);
		takeOrder("Mojito", 4);
		takeOrder("Pina Colada", 4);
		takeOrder("Mojito", 5);
		takeOrder("Margarita", 3);
		takeOrder("Mojito", 3);

		for (int i = 0; i < ordersCount; ++i) {
			cocktails[i].serveCocktail(tables[i]);
		}

		System.out.println("\nTotal Cocktail objects made: "
				+ cocktailFactory.getTotalCocktailsMade());
	}
}
