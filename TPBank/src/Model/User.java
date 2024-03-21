package Model;

public class User {

    private String accountNumber;
    private String password;
    private String captcha;

    public User(String accountNumber, String password, String captcha) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.captcha = captcha;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
