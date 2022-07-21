package executor;

import exception.InvalidTransferAmountException;
import model.Account;
import model.Statement;
import service.AccountManager;

public class TransferAmountCommandExecutor  implements CommandExecutor{
    @Override
    public boolean isValid(String[] args) {
        return args.length == 4;
    }

    @Override
    public void execute(AccountManager accountManager , String[] args) {
              String fromAccountId = args[1];
              String toAccountId = args[2];
              Double amount = Double.parseDouble(args[3]);

              if(amount <= accountManager.getMinTransferAmount()){
                  throw new InvalidTransferAmountException("Amount is lesser then allowed value");
              }
              Account fromAccount = accountManager.getAccount(fromAccountId);
              Account toAccount  = accountManager.getAccount(toAccountId);

              if(amount > fromAccount.getBalance() ){
                  throw new RuntimeException("please transfer what you have");
              }
              fromAccount.setBalance(fromAccount.getBalance() - amount);
              fromAccount.getStatementList().add(new Statement(toAccountId, -amount));
              toAccount.setBalance(toAccount.getBalance() + amount);
              toAccount.getStatementList().add(new Statement(fromAccountId, amount));
    }
}
