import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Vault {

    private static final String VAULT_FILENAME = "vault.csv";

    public static List<Account> getVault() {

        List<Account> accounts = new ArrayList<>();

        try {

            Reader reader = Files.newBufferedReader(Paths.get(VAULT_FILENAME));

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

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

            e.printStackTrace();

        }

        return accounts;

    }

}
