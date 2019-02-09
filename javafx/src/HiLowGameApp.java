import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HiLowGameApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private HiLowGame game = new HiLowGame();

    @Override
    public void start(Stage primaryStage) {

        newGame();

        primaryStage.setTitle("Welcome to Hi-Lo Game!");

        // Number Input field
        TextField textFieldInputNumber = new TextField();
        textFieldInputNumber.setPrefWidth(190);

        // force the field to be numeric only
        textFieldInputNumber.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textFieldInputNumber.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // Action button(guess or start a new game)
        Button btnAction = new Button();
        btnAction.setText("Guess!");

        // Result area
        // TODO: Use string constant for text context
        // TODO: Use font effects and fancy styles
        DropShadow dsResult = new DropShadow();
        dsResult.setOffsetY(3.0f);
        dsResult.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text textResults = new Text();
        textResults.setEffect(dsResult);
        textResults.setText("New game, input number(1-100)!");
        textResults.setFont(Font.font ("Verdana", FontWeight.BOLD, 16));

        textResults.setFill(Color.GREEN);

        // Event handlers
        btnAction.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (game.getStatus() == HiLowGame.GuessStatus.CORRECT) {

                    // Restart game
                    HiLowGameApp.this.newGame();

                    textFieldInputNumber.setText("");
                    btnAction.setText("Guess!");
                    textResults.setText("New game, input number(1-100)!");

                } else {

                    if (textFieldInputNumber.getText().isEmpty()) {
                        textResults.setText("Enter number!");
                        return;
                    }

                    // Guess logic
                    int inputNumber = Integer.valueOf(textFieldInputNumber.getText());
                    HiLowGame.GuessStatus guessResult = game.guess(inputNumber);

                    // Debug
                    System.out.println(inputNumber + ":" + guessResult);

                    switch (guessResult) {
                        case CORRECT:
                            textResults.setText("Awesome, you win!");
                            btnAction.setText("New Game!");
                            break;
                        case TOO_LOW:
                            textResults.setText("The number is too low!");
                            break;
                        case TOO_HIGH:
                            textResults.setText("The number is too high!");
                            break;
                    }

                }
            }
        });


        // Initialize layout
        HBox hboxInput = new HBox();

        hboxInput.setPadding(new Insets(15, 12, 15, 12));
        hboxInput.setSpacing(10);
        hboxInput.setStyle("-fx-background-color: #336699;");

        hboxInput.getChildren().addAll(textFieldInputNumber, btnAction);

        HBox hboxResult = new HBox();
        hboxResult.setPadding(new Insets(15, 12, 15, 12));
        hboxResult.setSpacing(10);
        hboxResult.getChildren().add(textResults);

        BorderPane root = new BorderPane();
        root.setTop(hboxInput);
        root.setBottom(hboxResult);

        primaryStage.setScene(new Scene(root, 320, 100));
        primaryStage.show();
    }

    private void newGame() {
        game.restart();

        // Uncomment this line for test
        System.out.println("Target number is " + game.getCorrectNumber());
    }

}