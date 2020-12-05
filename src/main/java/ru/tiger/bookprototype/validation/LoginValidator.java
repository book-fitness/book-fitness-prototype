package ru.tiger.bookprototype.validation;

/**
 *
 * @author tiger
 */
public class LoginValidator extends AbstractValidator{
    public String getRegExp() {
        //return "[_A-Za-z0-9]{4,30}";
        return "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    }
}
