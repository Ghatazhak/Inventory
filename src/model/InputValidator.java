package model;
/** This class validates int and double primitives for other functions */
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
/** this method validates integers. This method uses wrapper class to parseint.
 * @param needsValidation A string that needs validation.
 * @return  a boolean. True if it's an integer and false if it is not. */
    public static boolean intValidator(String needsValidation){
       try {
           Integer.parseInt(needsValidation);
           return true;
       }
       catch (NumberFormatException e){
            return false;
       }
    }
    /**this method validates doubles. This method uses a wrapper class to parse double.
     * @param needsValidation the string needing validated.
     * @return boolean */
    public static boolean doubleValidator(String needsValidation){
        try {
            Double.parseDouble(needsValidation);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

}
