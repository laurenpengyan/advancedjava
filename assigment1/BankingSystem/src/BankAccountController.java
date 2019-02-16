// M5 MVC Pattern
public class BankAccountController {

    private final BankAccountView view;
    private final BankAccountModel model;

    public BankAccountController(BankAccountModel model, BankAccountView view) {
        this.model = model;
        this.view = view;
    }

}