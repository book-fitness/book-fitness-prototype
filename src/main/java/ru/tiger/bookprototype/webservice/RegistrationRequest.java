package ru.tiger.bookprototype.webservice;

/**
 *
 * @author Igor
 */
class RegistrationRequest {
    private String login;
    private String password;
    private String repeatPassword;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String login, String password, String repeatPassword) {
        this.login = login;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
