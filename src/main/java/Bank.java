import java.util.List;
import java.util.Optional;

public class Bank {

    public static void main(String[] args) {

//        List<Account> accounts = new ArrayList();
//
//        for (int index = 1; index <= 20; index++) {
//
//            Account newAccount = new Account();
//
//            newAccount.accountName = "my account";
//
//            accounts.add(newAccount);
//
//        }
//
//        System.out.println(accounts);

        Optional<List<Account>> accounts = Vault.getVault();

        if (accounts.isPresent()) {

            System.out.println(accounts);

        } else {

            System.out.println("Couldn't load vault.csv!");

        }


    }

}
