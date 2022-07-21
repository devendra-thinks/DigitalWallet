package executor;

import model.Account;
import service.AccountManager;

public class CreateWalletCommandExecutor implements CommandExecutor {

    // command , balance , accountid
    @Override
    public boolean isValid(String[] args) {
        return args.length == 3 ? true : false;
    }

    @Override
    public void execute(AccountManager accountManager , String[] args) {
        String accountId = args[1];
        Double amount = Double.parseDouble(args[2]);
        Account account = new Account(accountId, amount);
        accountManager.addAccount(account);
    }
}
