package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

class Memento {
	private String year;

	public Memento(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}
}

class Originator {
	private String year;

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public Memento createMemento() {
		return new Memento(year);
	}

	public void setMemento(Memento memento) {
		year = memento.getYear();
	}
}

class Caretaker {
	private List<Memento> yearsList = new ArrayList<Memento>();

	public void addMemento(Memento m) {
		yearsList.add(m);
	}

	public Memento getMemento(int index) {
		return yearsList.get(index);
	}
}

public class DemoMemento {
	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setYear("2000");
		Memento memento = originator.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(memento);

		originator.setYear("1990");
		originator.setYear("1980");
		memento = originator.createMemento();
		caretaker.addMemento(memento);
		originator.setYear("1970");
		System.out
				.println("Originator Current State: " + originator.getYear());
		System.out.println("Originator restoring to previous state...");
		memento = caretaker.getMemento(1);
		originator.setMemento(memento);
		System.out
				.println("Originator Current State: " + originator.getYear());
		System.out.println("Again restoring to previous state...");
		memento = caretaker.getMemento(0);
		originator.setMemento(memento);
		System.out
				.println("Originator Current State: " + originator.getYear());
	}
}
