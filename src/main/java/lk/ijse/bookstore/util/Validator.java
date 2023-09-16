package lk.ijse.bookstore.util;

public class Validator {
    
    public static boolean validateTextFeild(String input, String pattern){
        String text = input.strip();

        if (text.isEmpty()) {
            return false;
        }

        if (!text.matches(pattern)) {
            return false;
        }

        return true;
    
    }

    public static boolean validateTextFeild(Number input, String pattern){
        String stringInput = input.toString();
        String text = stringInput.strip();

        if (text.isEmpty()) {
            return false;
        }

        if (!text.matches(pattern)) {
            return false;
        }

        return true;
    
    }

}   