package awesomebanker;

import java.util.Optional;
import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

//        List<awesomebanker.Account> accounts = new ArrayList();
//
//        for (int index = 1; index <= 20; index++) {
//
//            awesomebanker.Account newAccount = new awesomebanker.Account();
//
//            newAccount.accountName = "my account";
//
//            accounts.add(newAccount);
//
//        }
//
//        System.out.println(accounts);

//        Optional<List<awesomebanker.Account>> accounts = awesomebanker.Vault.getVault();
//
//        if (accounts.isPresent()) {
//
//            System.out.println(accounts);
//
//        } else {
//
//            System.out.println("Couldn't load vault.csv!");
//
//        }

        //
        // Start listening for inputs..
        //
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your account name: ");

        //
        // Take whatever is typed before hitting enter
        //
        String accountName = scanner.nextLine();

        System.out.println("*** Retrieving the account name\"" + accountName + "\"");

        //
        // Try to get the account by name
        //
        Optional<Account> optionalAccount = Vault.getAccountByName(accountName);

        //
        // Check to make sure the account exists
        //
        if (optionalAccount.isPresent()) {

            System.out.println("*** Your account funds are: " + optionalAccount.get().getAccountFunds());

        } else {

            System.out.println("*** COULD NOT LOCATE ACCOUNT NAME!");

        }

    }

}
