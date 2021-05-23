package appLogic;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidUsernameException;

public class User {

    private String fullName;
    private String email;
    private String username;
    private String hashedPassword;


    public User(String fullName, String email, String username, String hashedPassword) throws InvalidNameException, InvalidUsernameException, InvalidEmailException, InvalidPasswordException {




            setFullName(fullName);
            setUserName(username);
            setEmail(email);
            setHashedPassword(hashedPassword);


    }

    public void setFullName(String fullName) throws InvalidNameException{

        if(!Validation.isValidFullName(fullName)){
            throw new InvalidNameException();
        }


        this.fullName = fullName;
    }

    public void setEmail(String email) throws InvalidEmailException{
        if(!Validation.isValidEmail(email)){
            throw new InvalidEmailException();
        }


        this.email = email;
    }

    public void setUserName(String userName) throws InvalidUsernameException{

        if(!Validation.isValidUsername(userName)){
            throw new InvalidUsernameException();
        }

        this.username = userName;

    }

    public void setHashedPassword(String hashedPassword) throws InvalidPasswordException {

        if(!Validation.isValidPassword(hashedPassword)){
            throw new InvalidPasswordException();
        }
        this.hashedPassword = Validation.hashString(hashedPassword);
    }


    public String toString(){
        return fullName+"," + email+"," + username+"," + hashedPassword;
    }
}
