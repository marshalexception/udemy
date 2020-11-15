package javafx.section_12;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxes extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        CheckBox checkBoxOne = new CheckBox("Red");
        CheckBox checkBoxTwo = new CheckBox("Green");

        Button button = new Button("Click");
        button.setOnAction(event -> checkAction(checkBoxOne, checkBoxTwo));

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(checkBoxOne, checkBoxTwo, button);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setTitle("CheckBoxes Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void checkAction(CheckBox one, CheckBox two) {
        String message = "";
        if (one.isSelected()) {
            message = "red";
        } else if (two.isSelected()) {
            message = "green";
        }
        System.out.println(message);
    }
}
