import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vault {

    private static final String VAULT_FILENAME = "vault.csv";

    //
    // This method retrieves the data out of vault.csv, loops through each item
    // and creates an Account Object for each.
    //
    // It returns an Optional Object which is empty (checked by .isPresent()) if
    // vault.csv cannot be loaded instead of crashing.
    //
    public static Optional<List<Account>> getVault() {

        List<Account> accounts = new ArrayList<>();

        try {

            //
            // Open up the vault.csv file for reading
            //
            Reader reader = Files.newBufferedReader(Paths.get(VAULT_FILENAME));

            //
            // Read in vault.csv and treat it as a CSV object using the commons-csv CSVParser Class
            //
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            //
            // Loop through each line in the CSV file and create an Account Object
            // for each.
            //
            // We then add it to the List using .add()
            //
            for (CSVRecord csvRecord : csvParser) {

                Account account = new Account();

                account.setAccountName(csvRecord.get("accountName"));
                account.setAccountSurname(csvRecord.get("accountSurname"));
                account.setAccountLogin(csvRecord.get("accountLogin"));
                account.setAccountPassword(csvRecord.get("accountPassword"));
                account.setAccountFunds(Double.parseDouble(csvRecord.get("accountFunds")));

                accounts.add(account);

            }

        } catch (IOException e) {

            //
            // Something bad happened, don't freak out! :)
            //
            e.printStackTrace();

        }

        //
        // Return either an empty Optional Object or the accounts
        //
        return accounts.size() > 0 ? Optional.of(accounts) : Optional.empty();

    }

    //
    // Retrieve an account record (from the csv) by it's accountName field value
    //
    public static Optional<Account> getAccountByName(String name) {

        Optional<List<Account>> accounts = getVault();

        if (accounts.isPresent()) {

            //
            // Loop through each account and see if accountName matches
            //
            for (int i = 0; i < accounts.get().size(); i++) {

                //
                // We got a match, return the account object now
                //
                if (accounts.get().get(i).getAccountName().equals(name)) {

                    return Optional.of(accounts.get().get(i));

                }

            }

        }

        return Optional.empty();

    }

}
