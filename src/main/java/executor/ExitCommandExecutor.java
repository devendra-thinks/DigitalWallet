package executor;

import service.AccountManager;

public class ExitCommandExecutor implements  CommandExecutor{
    @Override
    public boolean isValid(String[] args) {
        return args.length == 1;
    }

    @Override
    public void execute(AccountManager accountManager, String[] args) {
         System.exit(0);
    }
}
