package structural.bridge;

interface InterfaceTV {
	public void on();

	public void off();

	public void switchChannel(int channel);
}

class PhilipsTV implements InterfaceTV {
	@Override
	public void on() {
		System.out.println("Philips is turned on");
	}

	@Override
	public void off() {
		System.out.println("Philips is turned off");
	}

	@Override
	public void switchChannel(int channel) {
		System.out.println("Philips: channel " + channel);
	}
}

class LGTV implements InterfaceTV {

	@Override
	public void on() {
		System.out.println("LG is turned on");
	}

	@Override
	public void off() {
		System.out.println("LG is turned off");
	}

	@Override
	public void switchChannel(int channel) {
		System.out.println("LG: channel " + channel);
	}
}

abstract class AbstractRemoteControl {
	private InterfaceTV tv;

	public AbstractRemoteControl(InterfaceTV tv) {
		this.tv = tv;
	}

	public void turnOn() {
		tv.on();
	}

	public void turnOff() {
		tv.off();
	}

	public void setChannel(int channel) {
		tv.switchChannel(channel);
	}
}

class LogitechRemoteControl extends AbstractRemoteControl {

	public LogitechRemoteControl(InterfaceTV tv) {
		super(tv);
	}

	public void setChannelKeyboard(int channel) {
		setChannel(channel);
		System.out.println("Logitech use keyword to set channel");
	}
}

public class DemoBridge {

	public static void main(String[] args) {
		InterfaceTV tv = new LGTV();
		LogitechRemoteControl lrc = new LogitechRemoteControl(tv);
		lrc.turnOn();
		lrc.setChannelKeyboard(3);
		lrc.turnOff();

		System.out.println();

		tv = new PhilipsTV();
		lrc = new LogitechRemoteControl(tv);
		lrc.turnOn();
		lrc.setChannelKeyboard(12);
		lrc.turnOff();
	}
}
