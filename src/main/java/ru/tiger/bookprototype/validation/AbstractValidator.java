package ru.tiger.bookprototype.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tiger
 */
public abstract class AbstractValidator {
    public boolean isValid(String value) {
        Pattern pattern = Pattern.compile(getRegExp());
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
    
    public abstract String getRegExp();
}
