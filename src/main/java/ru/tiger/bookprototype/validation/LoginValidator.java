package ru.tiger.bookprototype.validation;

/**
 *
 * @author tiger
 */
public class LoginValidator extends AbstractValidator{
    public String getRegExp() {
        return "[_A-Za-z0-9]{4,30}";
    }
}
