package to_do;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    public DatePicker datePicker;
    public TextField textFieldTask;
    public TextArea textAreaTasks;

    public void addToDo() {
        textAreaTasks.appendText(""+ datePicker.getValue()+"\t"+ textFieldTask.getText()+"\n");

        // todo: interesting task would be to sort tasks according to date
    }

}