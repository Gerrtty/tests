package data;

public class AccountData {

    private String login;
    private String password;
    private boolean logined;

    public AccountData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AccountData() {

    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public boolean getLogined() {
        return logined;
    }

    public void setLogined(boolean b) {
        logined = b;
    }
}
