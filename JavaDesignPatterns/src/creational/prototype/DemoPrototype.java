package creational.prototype;

interface Prototype {
	public void setType(String type);

	public void printType();
}

class Car implements Prototype, Cloneable {
	private String type;

	public Car(String type) {
		this.type = type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void printType() {
		System.out.println("Type: " + type);
	}

	@Override
	public Car clone() throws CloneNotSupportedException {
		return (Car) super.clone();
	}
}

public class DemoPrototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		Car car = new Car("Private car");

		Prototype prototype = car.clone();
		prototype.setType("Van");
		prototype.printType();

		prototype = car.clone();
		prototype.setType("Sports car");
		prototype.printType();
	}
}
