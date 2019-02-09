import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;

public class Quotes extends Application {


    private String quotes[] = {"All our dreams can come true, if we have the courage to pursue them.",
            "It does not matter how slowly you go as long as you do not stop.",
            "The future belongs to those who believe in the beauty of their dreams.",
            "Success is not final, failure is not fatal: it is the courage to continue that counts.",
            "Believe you can and you’re halfway there.",
            "Don’t wish it were easier. Wish you were better."};

    //storing all the available font families to an array

    private String[] fonts = (String[]) Font.getFontNames().toArray();

    //UI components

    private Text text;

    private Button button;

    //random number generator

    private Random random;

    @Override

    public void start(Stage primaryStage) {

        //initializing everything

        text = new Text();

        button = new Button("Change Quotes");

        //adding event listener to change button, to call the change() method

        button.setOnAction(e -> change());

        random = new Random();

        //using a VBox to arrange elements

        VBox root = new VBox(text, button);

        //aligning center

        root.setAlignment(Pos.CENTER);

        //setting some padding

        root.setPadding(new Insets(30));

        //setting space between elements

        root.setSpacing(30);

        //creating and displaying scene

        Scene scene = new Scene(root, 1000, 300);

        primaryStage.setScene(scene);

        primaryStage.setTitle("My Favorite Quotes");

        change(); //displaying quote initially

        primaryStage.show();

    }

    //method to update the text with random quote in random font and color

    public void change() {

        //choosing a random quote and fonts

        String quote = quotes[random.nextInt(quotes.length)];

        String font = fonts[random.nextInt(fonts.length)];

        //creating a random color

        Color color = new Color(random.nextDouble(),random.nextDouble(),random.nextDouble(),1.0);

        //updating text with these attributes

        text.setText(quote);

        text.setFont(new Font(font, 20));

        text.setFill(color);

    }

    public static void main(String[] args) {

        launch(args);

    }

}