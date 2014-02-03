package behavioral.mediator;

interface IMediator {
	public void registerRunway(Runway runway);

	public void registerFlight(Flight flight);

	public boolean isLandingOk();

	public void setLandingStatus(boolean status);
}

class ConcreteMediator implements IMediator {
	@SuppressWarnings("unused")
	private Flight flight;
	@SuppressWarnings("unused")
	private Runway runway;
	public boolean land;

	@Override
	public void registerRunway(Runway runway) {
		this.runway = runway;
	}

	@Override
	public void registerFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public boolean isLandingOk() {
		return land;
	}

	@Override
	public void setLandingStatus(boolean status) {
		land = status;
	}
}

interface Command {
	public void land();
}

class Flight implements Command {
	private IMediator concreteMediator;

	public Flight(IMediator concreteMediator) {
		this.concreteMediator = concreteMediator;
	}

	@Override
	public void land() {
		if (concreteMediator.isLandingOk()) {
			System.out.println("Landing done....");
			concreteMediator.setLandingStatus(true);
		} else
			System.out.println("Will wait to land....");
	}

	public void getReady() {
		System.out.println("Getting ready...");
	}
}

class Runway implements Command {
	private IMediator concreteMediator;

	public Runway(IMediator concreteMediator) {
		this.concreteMediator = concreteMediator;
		concreteMediator.setLandingStatus(true);
	}

	@Override
	public void land() {
		System.out.println("Landing permission granted...");
		concreteMediator.setLandingStatus(true);
	}
}

public class DemoMediator {
	public static void main(String[] args) {
		IMediator concreteMediator = new ConcreteMediator();

		Flight flight = new Flight(concreteMediator);
		concreteMediator.registerFlight(flight);

		flight.getReady();
		flight.land();

		Runway runway = new Runway(concreteMediator);
		concreteMediator.registerRunway(runway);
		runway.land();
		flight.land();
	}
}
