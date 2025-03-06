package domain;

public class GuessGameLogic {
	private int theNumber=0;
	private int remainder = 5;
	private String hint;

	public GuessGameLogic() {
	}
	
	public  GuessGameLogic(int startNumber, int endNumber) {
		this.theNumber = generateRandomNumber(startNumber, endNumber);
	}
	
	public void initialize(int startNumber, int endNumber) {
		this.theNumber = generateRandomNumber(startNumber, endNumber);
	}

	public boolean isCorrectGuess(int guess) {
		if (guess == theNumber) {
			return true;
		} else {
			if (guess > theNumber)
				hint = "Guess Number to Small";
			else
				hint = "Guess Number to Big";
			remainder--;
			return false;
		}
	}

	private int generateRandomNumber(int startNumber, int endNumber) {
		double range = (double) (endNumber - startNumber + 1);
		return startNumber + (int) (Math.random() * range);
	}

	public int getRemainder() {
		return remainder;
	}

	public String getHint() {
		return hint;
	}

	public int getTheNumber() {
		return theNumber;
	}

	public void setTheNumber(int theNumber) {
		this.theNumber = theNumber;
	}
	
	
}