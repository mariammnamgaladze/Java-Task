package exeption;


public class InvalidNumberException extends Exception {

    private static final String NEGATIVE_NUMBERS_ERROR = " ";

    public InvalidNumberException(String msg) {
        super(msg);
    }

    public InvalidNumberException() {
        super(NEGATIVE_NUMBERS_ERROR);
    }
}