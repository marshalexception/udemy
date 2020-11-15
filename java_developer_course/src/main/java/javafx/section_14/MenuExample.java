package javafx.section_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuExample extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        Menu mainMenu = new Menu("File");

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> exitAction());

        CheckMenuItem autoSave = new CheckMenuItem("Auto Save");
        autoSave.setOnAction(event -> autoSaveAction(autoSave));

        mainMenu.getItems().addAll(
                new MenuItem("New"),
                new MenuItem("Open"),
                new MenuItem("Save"),
                autoSave,
                new SeparatorMenuItem(),
                exit);

        Menu anotherMenu = new Menu("Help");
        anotherMenu.getItems().addAll(new MenuItem("Check For Updates"), new MenuItem("About"));

        Menu radioMenu = new Menu("Gender");
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem maleItem = new RadioMenuItem("Male");
        RadioMenuItem femaleItem = new RadioMenuItem("Female");
        // same toogle group causes that only one item can be selected
        maleItem.setToggleGroup(toggleGroup);
        femaleItem.setToggleGroup(toggleGroup);
        radioMenu.getItems().addAll(maleItem, femaleItem);

        MenuBar menuBar = new MenuBar(mainMenu, anotherMenu, radioMenu);

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);

        scene = new Scene(layout, 400,400);
        primaryStage.setTitle("Menu Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void autoSaveAction(CheckMenuItem autoSave) {
        if (autoSave.isSelected()) {
            System.out.println("Auto save enabled");
        } else {
            System.out.println("Auto saven disabled");
        }
    }

    private void exitAction() {
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }
}
