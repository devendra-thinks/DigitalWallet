package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
     String accountId;
     double balance;
     List<Statement > statementList = new ArrayList<>();
     public Account(String accountId, double balance) {
          this.accountId = accountId;
          this.balance = balance;
     }

     public double getBalance() {
          return balance;
     }

     public void setBalance(double balance) {
          this.balance = balance;
     }

     public String getAccountId() {
          return accountId;
     }

     public void setAccountId(String accountId) {
          this.accountId = accountId;
     }

     public List<Statement> getStatementList() {
          return statementList;
     }

     public void setStatementList(List<Statement> statementList) {
          this.statementList = statementList;
     }
}
