package behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

interface Visitor {
	public void visit(City city);

	public void visit(Museum museum);

	public void visit(Park park);
}

class FirstTimeVisitor implements Visitor {
	@Override
	public void visit(City city) {
		System.out.println("I'm visiting the city");
	}

	@Override
	public void visit(Museum museum) {
		System.out.println("I'm visiting the Museum");
	}

	@Override
	public void visit(Park park) {
		System.out.println("I'm visiting the Park");
	}
}

interface Element {
	public void accept(Visitor visitor);
}

class City implements Element {
	List<Element> places = new ArrayList<Element>();

	public City() {
		places.add(new Museum());
		places.add(new Park());
	}

	@Override
	public void accept(Visitor visitor) {
		System.out.println("City is accepting visitor");
		visitor.visit(this);

		for (Element element : places) {
			element.accept(visitor);
		}
	}
}

class Museum implements Element {
	@Override
	public void accept(Visitor visitor) {
		System.out.println("Museum is accepting visitor");
		visitor.visit(this);
	}
}

class Park implements Element {
	@Override
	public void accept(Visitor visitor) {
		System.out.println("Park is accepting visitor");
		visitor.visit(this);
	}
}

public class DemoVisitor {
	public static void main(String[] args) {
		FirstTimeVisitor visitor = new FirstTimeVisitor();
		City city = new City();
		city.accept(visitor);
	}
}
