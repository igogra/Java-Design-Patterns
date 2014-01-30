package behavioral.command;

interface Command {
	public void execute();
}

// Invoker
class RemoteControl {
	public void pressButton(Command command) {
		command.execute();
	}
}

// Receiver
class BluerayPlayer {
	public void play() {
		System.out.println("Playing movie...");
	}

	public void stop() {
		System.out.println("Stopping movie...");
	}
}

class PlayCommand implements Command {
	private BluerayPlayer bluerayPlayer;

	public PlayCommand(BluerayPlayer bluerayPlayer) {
		this.bluerayPlayer = bluerayPlayer;
	}

	public void execute() {
		bluerayPlayer.play();
	}
}

class StopCommand implements Command {
	private BluerayPlayer bluerayPlayer;

	public StopCommand(BluerayPlayer bluerayPlayer) {
		this.bluerayPlayer = bluerayPlayer;
	}

	public void execute() {
		bluerayPlayer.stop();
	}
}

// Client
public class DemoCommand {
	public static void main(String[] args) {
		BluerayPlayer bluerayPlayer = new BluerayPlayer();
		Command playCommand = new PlayCommand(bluerayPlayer);
		Command stopCommand = new StopCommand(bluerayPlayer);
		
		RemoteControl remoteControl = new RemoteControl();
		remoteControl.pressButton(playCommand);
		remoteControl.pressButton(stopCommand);
		remoteControl.pressButton(playCommand);
		remoteControl.pressButton(stopCommand);
	}
}
