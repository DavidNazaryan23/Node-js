package exceptions;

public class ExistingUserException extends Exception{

    public ExistingUserException() {
        super("User already exists");
    }
}
