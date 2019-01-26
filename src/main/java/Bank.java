import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your account name: ");

        String accountName = scanner.nextLine();

        System.out.println("*** Retrieving the account name\"" + accountName + "\"");

        Optional<Account> optionalAccount = Vault.getAccountByName(accountName);

        if (optionalAccount.isPresent()) {

            System.out.println("*** Your account funds are: " + optionalAccount.get().getAccountFunds());

        } else {

            System.out.println("*** COULD NOT LOCATE ACCOUNT NAME!");

        }

    }

}
