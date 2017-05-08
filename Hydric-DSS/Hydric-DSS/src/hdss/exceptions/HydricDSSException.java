package hdss.exceptions;

public class HydricDSSException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String message;

	//Esfuerzo Actual: 1.5 minutos
	//4

	public HydricDSSException (String message){

		this.message = message;
	}

	//Esfuerzo Actual: 1.5 minutos
	//3

	public String getMessage(){

		return this.message;
	}

}
