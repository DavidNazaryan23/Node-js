package exceptions;

public class NoSuchUserException extends Exception{

    public NoSuchUserException() {

        super("No such user exists");
    }
}
