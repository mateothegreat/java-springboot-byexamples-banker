import java.util.ArrayList;
import java.util.List;

public class Bank {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList();

        for (int index = 1; index <= 20; index++) {

            Account newAccount = new Account();

            newAccount.accountName = "my account";

            accounts.add(newAccount);

        }

        System.out.println(accounts);

    }

}
