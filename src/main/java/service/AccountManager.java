package service;

import exception.AccountNotFoundException;
import exception.DuplicateAccountException;
import model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
     private  double  minTransferAmount;
     private  List<Account> accounts = new ArrayList<>();

     public Account getAccount(String accountId) throws AccountNotFoundException {
          for (Account account : accounts){
               if (account.getAccountId().equals(accountId))
                    return account;
          }
          throw new AccountNotFoundException("No account present");
     }

     public void addAccount(Account account) {
          try{
               getAccount(account.getAccountId());
               throw new DuplicateAccountException("Duplicate account creation not allowed");
          }catch (AccountNotFoundException e){
               accounts.add(account);
          }
     }

     public void showOverview(){
          for (Account account : accounts){
               System.out.println(account.getAccountId() + " balance is " + account.getBalance());
          }
     }

     public AccountManager(double minTransferAmount) {
          this.minTransferAmount = minTransferAmount;
     }

     public double getMinTransferAmount() {
          return minTransferAmount;
     }
}
