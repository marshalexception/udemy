package javafx.section_12;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application {
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Option 1", "Option 2", "Option 3", "Option 4", "Option 5");
        comboBox.setPromptText("Option 1");
        comboBox.setOnAction(event -> System.out.println(comboBox.getValue()));

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(comboBox);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setTitle("ComboBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
