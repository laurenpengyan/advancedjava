import javafx.application.Application;
import javafx.stage.Stage;

// M5 MVC Pattern
public class BankAccountApplication extends Application {

    // Model
    private BankAccountModel model;

    private BankAccountView view;

    private BankAccountController controller;


    @Override
    public void start(Stage primaryStage) {

        initialize();

        // Initialize UI Components
        // Initialize Layouts

        // Add event listeners


        // Setup scene and stage
        primaryStage.setTitle("My Favorite Quotes");

//        Scene scene = new Scene(root, 1200, 300);
//        primaryStage.setScene(scene);

        primaryStage.show();

    }

    /**
     * Initialize the model/view for initial loading.
     */
    private void initialize() {
        model = new BankAccountModel();
        view = new BankAccountView();

        controller = new BankAccountController(model, view);
    }

    /**
     * Main entry point.
     *
     * @param args command-line args.
     */
    public static void main(String[] args) {
        launch(args);
    }

}