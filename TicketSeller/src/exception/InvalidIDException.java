package exception;

public class InvalidIDException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidIDException() {
		super("A ID informada não é válida. A ID tem que ser um número positivo.");
	}
	
	

}
