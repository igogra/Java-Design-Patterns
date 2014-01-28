package structural.facade;

// Components of Computer

class CPU {
	public void processData() {
		System.out.println("Processing data...");
	}
}

class Memory {
	public void load() {
		System.out.println("Loading...");
	}
}

class HardDrive {
	public void readdata() {
		System.out.println("Reading data...");
	}
}

// Facade
class Computer {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void run() {
		cpu.processData();
		memory.load();
		hardDrive.readdata();
	}
}

public class DemoFacade {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.run();
	}
}
