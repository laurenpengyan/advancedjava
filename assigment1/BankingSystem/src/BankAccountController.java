import java.math.BigDecimal;

// M5 MVC Pattern
public class BankAccountController {

    private final BankAccountView view;
    private final BankAccountModel model;

    public BankAccountController(BankAccountModel model, BankAccountView view) {
        this.model = model;
        this.view = view;
    }

    public BankAccountView getView() {
        return view;
    }

    public BankAccountModel getModel() {
        return model;
    }

    public void createNewAccount() {
        // M5 MVC Pattern
        // Get values from view
        // TODO: Validation first
        String accountType = (String) view.getChoiceNewAccountType().getValue();
        int customerId = Integer.parseInt(view.getTextCustomerId().getText());
        long accountId = Long.parseLong(view.getTextAccountId().getText());
        BigDecimal initialBalance = new BigDecimal(view.getTextInitialBalance().getText());

        // Handle exception when accountId is already exists
        model.createNewAccount(accountType, customerId, accountId, initialBalance);
    }

    public void resetNewAccount() {
        // M5 MVC Pattern
        // Get values from view
        // TODO: Validation
        String accountType = (String) view.getChoiceNewAccountType().getValue();
        int customerId = Integer.parseInt(view.getTextCustomerId().getText());
        long accountId = Long.parseLong(view.getTextAccountId().getText());
        BigDecimal initialBalance = new BigDecimal(view.getTextInitialBalance().getText());

        model.createNewAccount(accountType, customerId, accountId, initialBalance);
    }


}