package javafxml;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public TextField textFieldOne;
    public TextField textFieldTwo;
    public Button sampleButton;
    public Label sampleLabel;

    public void buttonAction() {
        final double result = add(textFieldOne.getText(), textFieldTwo.getText());
        sampleLabel.setText(result + "");
    }

    private double add(String one, String two) {
        if (one.length() == 0) {
            return Double.parseDouble(two);
        } else if (two.length() == 0) {
            return Double.parseDouble(one);
        } else {
            return Double.parseDouble(one) + Double.parseDouble(two);
        }
    }
}
