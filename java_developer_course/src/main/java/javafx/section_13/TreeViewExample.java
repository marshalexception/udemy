package javafx.section_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

    TreeView<String> tree;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TreeItem<String> root, food, drinks;

        root = new TreeItem<>("Example Tree");
        root.setExpanded(true);

        food = setBranch("Food", root);
        drinks = setBranch("Drinks", root);

        setBranch("Burger", food);
        setBranch("Pizza", food);
        setBranch("Noodles", food);

        setBranch("Water", drinks);
        setBranch("Juice", drinks);

        tree = new TreeView<>(root);
        tree.setShowRoot(true);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(tree);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setTitle("TreeView Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private TreeItem<String> setBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}

