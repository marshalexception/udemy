package javafx.section_12;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxExample extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Option 1", "Option 2", "Option 3", "Option 4", "Option 5");
        choiceBox.setValue("Option 1");

        Button button = new Button("Click");
        button.setOnAction(event -> System.out.println(choiceBox.getValue()));

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setTitle("ChoiceBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
