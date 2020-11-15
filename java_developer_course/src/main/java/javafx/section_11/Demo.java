package javafx.section_11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Demo extends Application {

    private Stage stage;

    private Scene sceneOne, sceneTwo;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;

        Button buttonOne = new Button("Switch to scene two");
        buttonOne.setOnAction(event -> stage.setScene(sceneTwo));



        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(buttonOne);
        sceneOne = new Scene(stackPane, 200,200);

        Button buttonTwo = new Button("Switch to scene one");
        buttonTwo.setOnAction(event -> stage.setScene(sceneOne));

        StackPane anotherStackPane = new StackPane();
        anotherStackPane.getChildren().add(buttonTwo);
        sceneTwo = new Scene(anotherStackPane, 200,200);

        stage.setScene(sceneOne);
        stage.show();
    }
}
