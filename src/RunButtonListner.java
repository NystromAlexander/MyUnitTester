import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Roguz on 09/11/2016.
 */
public class RunButtonListner {

    private JTextField textField;
    public RunButtonListner(JTextField inputText){
        this.textField = inputText;
    }

    public void actionPerformed(ActionEvent e){

        textField.getText();
    }
}
