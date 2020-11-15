package student_management_application;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    public TextField textFieldName;
    public TextField textFieldId;
    public TextField textFieldMarks;
    public TextField textFieldContact;

    public TextArea textArea;

    public void addButtonAction() {
        textArea.appendText(
                textFieldId.getText()+"\t"+
                textFieldName.getText()+"\t"+
                textFieldMarks.getText()+"\t"+
                textFieldContact.getText()+"\n"
        );
    }

}
