package executor;

import service.AccountManager;

public interface CommandExecutor {
     boolean isValid(String []args);
     void execute(AccountManager accountManager , String []args);
}
