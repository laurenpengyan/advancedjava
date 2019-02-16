import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// M5 MVC Pattern
public class BankAccountView {

    private final ChoiceBox choiceNewAccountType = new ChoiceBox(FXCollections.observableArrayList(
            "Checking", "Savings", "CD")
    );
    private final TextField textCustomerId = new TextField();
    private final TextField textAccountId = new TextField();
    private final TextField textInitialBalance = new TextField();
    private BankAccountController controller;
    private Parent root;
    // Create new account panel
    private Label labelNewAccountType = new Label("New Account Type");
    private Label labelCustomerId = new Label("Customer Id");
    private Label labelAccountId = new Label("Account Id");
    private Label labelInitialBalance = new Label("Initial Balance");
    private Button buttonCreateNewAccount = new Button("Create");
    private Button buttonResetCreateNewAccount = new Button("Reset");

    private Label labelMewAccountStatusText = new Label("Status");
    private Label labelNewAccountStatusContent = new Label("");


    public BankAccountView() {

        // Initialize UI Components
        choiceNewAccountType.setValue("Checking");

        // Initialize layout
        // TODO: Change URL
        root = new VBox();

        HBox hboxNewAccountType = new HBox(labelNewAccountType, choiceNewAccountType);
        hboxNewAccountType.setSpacing(12);

        HBox hboxCustommerId = new HBox(labelCustomerId, textCustomerId);

        HBox hboxAccountId = new HBox(labelAccountId, textAccountId);

        HBox hboxInitialBalance = new HBox(labelInitialBalance, textInitialBalance);

        HBox hboxCreateNewButtonPanel = new HBox(buttonCreateNewAccount, buttonResetCreateNewAccount);
        hboxCreateNewButtonPanel.setSpacing(12);

        HBox hboxCreateNewAccountStatus = new HBox(labelMewAccountStatusText, labelNewAccountStatusContent);
        hboxCreateNewAccountStatus.setSpacing(16);

        ((VBox) root).getChildren().addAll(hboxNewAccountType, hboxCustommerId, hboxAccountId, hboxInitialBalance, hboxCreateNewButtonPanel, hboxCreateNewAccountStatus);

    }

    public void setController(BankAccountController controller) {
        this.controller = controller;
    }

    public ChoiceBox getChoiceNewAccountType() {
        return choiceNewAccountType;
    }

    public TextField getTextCustomerId() {
        return textCustomerId;
    }

    public TextField getTextAccountId() {
        return textAccountId;
    }

    public TextField getTextInitialBalance() {
        return textInitialBalance;
    }


    public void setEventHandlers() {

        // M5 MVC Pattern
        // Call controller to create object using current values in view
        buttonCreateNewAccount.setOnAction(e -> createNewAccount());

        // M5 MVC Pattern
        // Reset UI using controller
        buttonResetCreateNewAccount.setOnAction(e -> resetCreateNewAccount());

    }

    private void createNewAccount() {
        // Validate input for create new account
        if (validateInputForCreateNewAccount()) {
            controller.createNewAccount();
        }
    }

    private boolean validateInputForCreateNewAccount() {

        // TODO: Validate the values as well
        if (!(choiceNewAccountType.getValue() instanceof String)) {
            showStatus(Alert.AlertType.ERROR, "Please choose account type!");
            return false;
        }
        if (textCustomerId.getText().isEmpty()) {
            showStatus(Alert.AlertType.ERROR, "Please enter customer id!");
            return false;
        }

        if (textAccountId.getText().isEmpty()) {
            showStatus(Alert.AlertType.ERROR, "Please enter account id!");
            return false;
        }

        if (textInitialBalance.getText().isEmpty()) {
            showStatus(Alert.AlertType.ERROR, "Please enter initial balance!");
            return false;
        }

        return true;
    }

    private void resetCreateNewAccount() {
        this.choiceNewAccountType.setId("Checking");
        this.textCustomerId.setText("");
        this.textAccountId.setText("");
        this.textInitialBalance.setText("");
    }

    private void showStatus(Alert.AlertType alertType, String message) {
        // TODO: Change background when alert type is ERROR/WARNING/INFO
        this.labelNewAccountStatusContent.setText(message);
    }


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(null);
        alert.show();
    }

    public Parent getRoot() {
        return root;
    }


}