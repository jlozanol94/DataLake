package co.com.test.choucair.exceptions;

public class BackEndException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BackEndException() {
        super();
    }

    public BackEndException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BackEndException(String message, Throwable cause) {
        super(message, cause);
    }	

   public BackEndException(String message) {
        super(message);
    }
   
   public BackEndException(Throwable cause) {
        super(cause);
    }


}
