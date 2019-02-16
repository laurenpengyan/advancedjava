import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// M5 MVC Pattern
public class BankAccountApplication extends Application {

    // Model
    private BankAccountModel model;

    private BankAccountView view;

    private BankAccountController controller;


    @Override
    public void start(Stage primaryStage) {

        // Initialize UI Components
        // Initialize Layouts

        // Add event listeners


        // Setup scene and stage
        primaryStage.setTitle("Bank Account System");

        // Scene scene = new Scene(view.getRoot(), 1200, 300);
        Scene scene = new Scene(view.getRoot());
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    /**
     * Initialize the model/view for initial loading.
     */
    public void init() {

        // M5 MVC Pattern
        // Initialize Model/View/Controller
        model = new BankAccountModel();
        view = new BankAccountView();
        controller = new BankAccountController(model, view);
        view.setController(controller);


        // Set event handlers
        view.setEventHandlers();

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