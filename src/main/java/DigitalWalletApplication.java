import exception.InvalidCommandException;
import executor.CommandExecutor;
import executor.CommandExecutorFactory;
import service.AccountManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitalWalletApplication {
  public static void main(String[] args) throws IOException, InvalidCommandException {
      CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory();
      AccountManager accountManager = new AccountManager( 0.001);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      while(true){
          String line  = bufferedReader.readLine();
          String []tokens = line.split(" ");
          CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(tokens[0]);
          if (commandExecutor.isValid(tokens)) {
              commandExecutor.execute(accountManager,tokens);
          }else {
              throw  new InvalidCommandException("Command is invalid");
          }
      }
  }
}
