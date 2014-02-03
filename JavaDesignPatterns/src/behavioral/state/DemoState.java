package behavioral.state;

interface State {
	public void displayState(StateContext stateContext);
}

class Available implements State {
	@Override
	public void displayState(StateContext stateContext) {
		System.out.println("I'm currently available");
	}
}

class Busy implements State {
	@Override
	public void displayState(StateContext stateContext) {
		System.out.println("I'm currently busy");
	}
}

class StateContext {
	private State currentState;

	public StateContext() {
		currentState = new Available();
	}

	public void setState(State newState) {
		this.currentState = newState;
	}

	public void displayState() {
		this.currentState.displayState(this);
	}
}

public class DemoState {
	public static void main(String[] args) {
		StateContext stateContext = new StateContext();
		stateContext.displayState();
		stateContext.displayState();
		stateContext.displayState();

		stateContext.setState(new Busy());
		stateContext.displayState();
		stateContext.displayState();
		stateContext.displayState();
	}
}
