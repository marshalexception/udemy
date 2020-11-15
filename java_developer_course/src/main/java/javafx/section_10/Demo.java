package javafx.section_10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Demo extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JavaFX Demo");

        Button button = new Button();
        button.setText("Button 1");
        button.setOnAction(this::performButtonAction);

        Button anotherButton = new Button();
        anotherButton.setText("Button 2");
        anotherButton.setOnAction(event -> Alert.display("Alert Box", "Dummy text"));

        Pane layout = new Pane();
        layout.getChildren().add(button);
        layout.getChildren().add(anotherButton);

        button.setLayoutX(100);
        button.setLayoutY(100);

        anotherButton.setLayoutX(100);
        anotherButton.setLayoutY(200);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void performButtonAction(ActionEvent event) {
        System.out.println("Button was clicked");
    }

}
