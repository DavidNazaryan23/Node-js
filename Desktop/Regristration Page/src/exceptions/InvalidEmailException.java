package exceptions;

public class InvalidEmailException extends Exception {

    public InvalidEmailException() {
        super("Invalid Email");
    }
}
