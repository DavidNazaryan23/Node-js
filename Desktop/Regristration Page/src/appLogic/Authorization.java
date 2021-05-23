package appLogic;

import exceptions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authorization {





    public static Map<String,String>  retrieveUsers(){

        List<String> users = null;

        try {
           users = FileManagment.read("All Users\\database.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Map<String,String> mailPassword = new HashMap<>();

        if(users == null){
            return mailPassword;
        }

        for (String user: users){
            String[] userSplit = user.split(",",4);

            if(userSplit.length==4){
                mailPassword.put(userSplit[1], userSplit[3]);
            }

        }

        return mailPassword;
    }


    public static boolean doesExist(String email){

        return retrieveUsers().containsKey(email);

    }


    public static boolean registerUser(String fullName, String email, String username, String password) throws InvalidUsernameException, InvalidNameException, InvalidEmailException, InvalidPasswordException, ExistingUserException {

        if(doesExist(email)){
            throw new ExistingUserException();
        }

        User newUser =  new User(fullName,email,username,password);

        try{

            FileManagment.append("All Users\\database.txt", newUser.toString()+"\n");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean logIn(String email, String password) throws NoSuchUserException, InvalidPasswordException {
        if(!doesExist(email)){
            System.out.println("does not exist");
            throw new NoSuchUserException();
        }


        if(!Validation.hashString(password).equals(retrieveUsers().get(email))){
            throw new InvalidPasswordException();
        }

        return true;
    }







}
