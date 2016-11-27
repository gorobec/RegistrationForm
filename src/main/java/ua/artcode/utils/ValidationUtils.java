package ua.artcode.utils;

import ua.artcode.exceptions.IncorrectEmailException;
import ua.artcode.exceptions.IncorrectNPasswordException;
import ua.artcode.exceptions.IncorrectNameSurnameException;
import ua.artcode.exceptions.IncorrectPhoneException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gorobec on 27.11.16.
 */
public class ValidationUtils {

    private static final String NAME_PATTERN = "[A-Z][a-z]{2,15}";
    private static final String PHONE_PATTERN = "\\d{10}";
    private static final String EMAIL_PATTERN = " ^(.+)@(.+)$";
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})\n";




    public static void validatePassword(String password) throws IncorrectNPasswordException {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches())
            throw new IncorrectNPasswordException("Incorrect password input");
    }

    public static void validateEmail(String email) throws IncorrectEmailException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches())
            throw new IncorrectEmailException("Incorrect email input");
    }

    public static void validatePhone(String phone) throws IncorrectPhoneException{
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        if(!matcher.matches())
            throw new IncorrectPhoneException("Incorrect phone input");
    }

    public static void validateName(String name) throws IncorrectNameSurnameException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        if(!matcher.matches())
            throw new IncorrectNameSurnameException("Incorrect name or surname input");
    }

}
