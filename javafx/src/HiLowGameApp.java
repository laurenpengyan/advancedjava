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

        primaryStage.setTitle("High-low Game!");

        // Number Input field
        TextField tfInputNumber = new TextField();
        tfInputNumber.setPrefWidth(195);

        // force the field to be numeric only
        tfInputNumber.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfInputNumber.setText(newValue.replaceAll("[^\\d]", ""));
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

        Text ttResult = new Text();
        ttResult.setEffect(dsResult);
        ttResult.setText("New game, input number(1-100)!");
        ttResult.setFont(Font.font ("Verdana", FontWeight.BOLD, 16));

        ttResult.setFill(Color.GREEN);

        // Event handlers
        btnAction.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (game.getStatus() == HiLowGame.GuessStatus.CORRECT) {
                    // Restart game
                    HiLowGameApp.this.newGame();

                    tfInputNumber.setText("");
                    btnAction.setText("Guess!");
                    ttResult.setText("New game, input number(1-100)!");

                } else {

                    if (tfInputNumber.getText().isEmpty()) {
                        ttResult.setText("Enter number!");
                        return;
                    }

                    // Guess logic
                    int inputNumber = Integer.valueOf(tfInputNumber.getText());
                    HiLowGame.GuessStatus guessResult = game.guess(inputNumber);

                    // Debug
                    System.out.println(inputNumber + ":" + guessResult);

                    switch (guessResult) {
                        case CORRECT:
                            ttResult.setText("You win the game!");
                            btnAction.setText("New Game!");
                            break;
                        case TOO_LOW:
                            ttResult.setText("The number is too low!");
                            break;
                        case TOO_HIGH:
                            ttResult.setText("The number is too high!");
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

        hboxInput.getChildren().addAll(tfInputNumber, btnAction);

        HBox hboxResult = new HBox();
        hboxResult.setPadding(new Insets(15, 12, 15, 12));
        hboxResult.setSpacing(10);
        hboxResult.getChildren().add(ttResult);

        BorderPane root = new BorderPane();
        root.setTop(hboxInput);
        root.setBottom(hboxResult);

        primaryStage.setScene(new Scene(root, 320, 100));
        primaryStage.show();
    }

    private void newGame() {
        game.restart();
        System.out.println("Target number is " + game.getTargetNumber());
    }

}