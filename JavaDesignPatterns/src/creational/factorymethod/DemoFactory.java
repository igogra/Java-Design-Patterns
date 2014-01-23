package creational.factorymethod;

interface Vehicle {
	public void move();
}

class Boat implements Vehicle {
	@Override
	public void move() {
		System.out.println("Boat is sailing");
	}
}

class Airplane implements Vehicle {
	@Override
	public void move() {
		System.out.println("Airplane is flying");
	}
}

class VehicleFactory {
	public Vehicle getVehicle(String vehicleType) {
		Vehicle vehicle = null;

		// Generate object of concrete class based on given information
		if (vehicleType.equals("boat")) {
			vehicle = new Boat();
		} else if (vehicleType.equals("airplane")) {
			vehicle = new Airplane();
		}

		return vehicle;
	}
}

public class DemoFactory {
	public static void main(String[] args) {
		// Create the factory
		VehicleFactory vehicleFactory = new VehicleFactory();

		// Factory instantiates an object
		Vehicle vehicle = vehicleFactory.getVehicle("boat");

		// Don't know which object factory created
		vehicle.move();

		vehicle = vehicleFactory.getVehicle("airplane");
		vehicle.move();
	}
}
