package model;

public class InputValidator {


    /*public static boolean stringValidator(String needsValidation){
        char[] chars = needsValidation.toCharArray();
        for (char c: chars) {
            if(!Character.isLetter(c)){
                return false;
            }
        }

       return true;
    }*/

    public static boolean intValidator(String needsValidation){
       try {
           Integer.parseInt(needsValidation);
           return true;
       }
       catch (NumberFormatException e){
            return false;
       }
    }
}
