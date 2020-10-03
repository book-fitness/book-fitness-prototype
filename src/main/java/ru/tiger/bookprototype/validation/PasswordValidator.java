package ru.tiger.bookprototype.validation;

/**
 *
 * @author tiger
 */
public class PasswordValidator extends AbstractValidator{
    public String getRegExp() {
        return "[A-Za-z0-9]{8,32}";
    }
}
