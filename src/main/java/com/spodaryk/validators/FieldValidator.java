package com.spodaryk.validators;

public class FieldValidator {

    public static boolean isValidate(String key) {
        if (key.equals("A") || key.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(key);
        } catch (NumberFormatException e) {
            System.out.println("Your number has wrong format");
            return false;
        }
        return true;
    }
}
