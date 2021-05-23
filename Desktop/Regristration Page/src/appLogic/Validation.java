package appLogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validation {

    public static boolean isValidFullName(String fullName){

        String validation = "^[A-Za-z\\s]+$";

        if(fullName.matches(validation)){
            return true;
        }

        return false;

    }


    public static boolean isValidUsername(String username){

        String validation = "^[a-zA-Z0-9._-]{3,}$";

        if(username.matches(validation)){
            return true;
        }

        return false;

    }

    public static boolean isValidEmail(String email){
        String validation = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

        if(email.matches(validation)){
            return true;
        }

        return false;
    }

    public static boolean isValidPassword(String password){
        String validation = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.!])(?=\\S+$).{8,}$";

        if(password.matches(validation)){
            return true;
        }

        return false;
    }


    public static String hashString(String stringToHash){

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(stringToHash.getBytes());
            byte[] hashArray = messageDigest.digest();

            StringBuilder builder = new StringBuilder();

            for(byte b : hashArray){
                builder.append(String.format("%02x",b));
            }

        return builder.toString();



        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }


    }


}
