package exceptions;

public class UnknownInputException extends Exception{
	private static final long serialVersionUID = 1L;

	public UnknownInputException() {
		super("Not a valid input");
	}

}
