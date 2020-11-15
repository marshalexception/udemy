package javafx.section_13;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application {

    ListView<String> listView;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        listView = new ListView<>();
        listView.getItems().addAll("Item 1", "Item 2", "Item 3", "Item 4");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button("Click");
        button.setOnAction(event -> buttonClick());

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(listView, button);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setTitle("ListView Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void buttonClick() {
        ObservableList<String> observableList = listView.getSelectionModel().getSelectedItems();
        for (int i = 0; i < observableList.size(); i++) {
            System.out.println(observableList.get(i));
        }
    }
}
