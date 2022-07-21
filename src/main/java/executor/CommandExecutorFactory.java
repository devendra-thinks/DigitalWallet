package executor;

public class CommandExecutorFactory {
        public static final String STATEMENT = "statement";
        public static final String TRANSFER = "transfer";
        public static final String CREATE = "create";
        public static final String OVERVIEW = "overview";

        public CommandExecutor getCommandExecutor(String command){
                switch (command){
                        case STATEMENT:
                                return new AccountStatementCommandExector();
                        case TRANSFER:
                                return new TransferAmountCommandExecutor();
                        case CREATE:
                                return new CreateWalletCommandExecutor();
                        case OVERVIEW :
                                return new OverviewCommandExecutor();
                        default:
                               return new ExitCommandExecutor();
                }
        }
}
