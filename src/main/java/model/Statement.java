package model;

public class Statement {
      String accountId;
      Double amount;

      public Statement(String accountId, Double amount) {
            this.accountId = accountId;
            this.amount = amount;
      }

      public String getAccountId() {
            return accountId;
      }

      public Double getAmount() {
            return amount;
      }
}
