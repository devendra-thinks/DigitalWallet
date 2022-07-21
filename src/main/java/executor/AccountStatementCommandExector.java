package executor;

import model.Account;
import model.Statement;
import service.AccountManager;

import java.util.List;

public class AccountStatementCommandExector implements CommandExecutor{

    @Override
    public boolean isValid(String[] args) {
        return args.length == 2;
    }

    @Override
    public void execute(AccountManager accountManager , String[] args) {
         Account account = accountManager.getAccount(args[1]);
         List<Statement > statements  = account.getStatementList();
         for(Statement statement : statements){
                String actionType = statement.getAmount() > 0 ? " debit " : " credit ";
                System.out.println(statement.getAccountId() +  actionType +  statement.getAmount());
         }
    }
}
