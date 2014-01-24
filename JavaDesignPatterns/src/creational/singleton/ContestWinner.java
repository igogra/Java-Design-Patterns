package creational.singleton;

// Lazy instantiation
public class ContestWinner {
	private static ContestWinner theWinner;
	
	private ContestWinner() {
	}

	public static ContestWinner getWinner() {
		if (theWinner == null) {
			theWinner = new ContestWinner();
		}
		
		return theWinner;
	}
}

// Early instantiation
/*public class ContestWinner {
	private static ContestWinner theWinner = new ContestWinner();
	
	private ContestWinner() {
	}

	public static ContestWinner getWinner() {		
		return theWinner;
	}
}*/
