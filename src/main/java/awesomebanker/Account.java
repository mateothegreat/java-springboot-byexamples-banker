package awesomebanker;

public class Account {

    private String accountName;
    private String accountSurname;
    private String accountLogin;
    private String accountPassword;
    private Double accountFunds;

    public String getAccountName() {

        return accountName;

    }

    public void setAccountName(String accountName) {

        this.accountName = accountName;

    }

    public String getAccountSurname() {

        return accountSurname;

    }

    public void setAccountSurname(String accountSurname) {

        this.accountSurname = accountSurname;

    }

    public String getAccountLogin() {

        return accountLogin;

    }

    public void setAccountLogin(String accountLogin) {

        this.accountLogin = accountLogin;

    }

    public String getAccountPassword() {

        return accountPassword;

    }

    public void setAccountPassword(String accountPassword) {

        this.accountPassword = accountPassword;

    }

    public Double getAccountFunds() {

        return accountFunds;

    }

    public void setAccountFunds(Double accountFunds) {

        this.accountFunds = accountFunds;

    }

    @Override
    public String toString() {

        return "accountName=" + accountName + "accountFunds=$" + accountFunds;

    }

}
