package bmi;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public TextField textFieldHeight;
    public TextField textFieldWeight;

    public Label labelBMI;
    public Label labelResult;

    public void bmiButtonClicked()
    {

        double height;
        double weight;
        double bmi;

        String result="";

        height= Double.parseDouble(textFieldHeight.getText());
        weight= Double.parseDouble(textFieldWeight.getText());

        bmi= height*height;
        bmi= weight/bmi;

        labelBMI.setText("BMI IS: "+bmi);

        if(bmi<18.5){

            result="Under weight";

        }
        else if(bmi>18.5 && bmi<25){

            result="Normal BMI";
        }
        else if(bmi>25){

            result="Over Weight";

        }

        labelResult.setText(result);

    }

}
