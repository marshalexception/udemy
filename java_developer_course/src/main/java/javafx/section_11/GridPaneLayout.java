package javafx.section_11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneLayout extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(8,8,8,8));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label nameLabel = new Label("Name");
        GridPane.setConstraints(nameLabel, 0,0);
        TextField nameTextField = new TextField("Enter name here");
        GridPane.setConstraints(nameTextField, 1, 0);

        Label passwordLabel = new Label("Password");
        GridPane.setConstraints(passwordLabel, 0,1);
        TextField passwordTextField = new TextField("Enter password here");
        GridPane.setConstraints(passwordTextField, 1, 1);

        Button button = new Button("Login");
        GridPane.setConstraints(button, 1, 2);
        button.setOnAction(event -> validate(passwordTextField));

        gridPane.getChildren().addAll(nameLabel, nameTextField, passwordLabel, passwordTextField, button);

        Scene scene = new Scene(gridPane, 250,200);
        primaryStage.setTitle("GridPane Layout");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void validate(TextField passwordTextField) {
        String newPassword = passwordTextField.getText();
        if (newPassword.equals("admin")) {
            System.out.println("User is accepted");
        } else {
            System.out.println("User not accepted");
        }
    }
}
