import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roguz on 09/11/2016.
 */
public class RunButtonListner implements ActionListener {

    private JTextField textField;
    public RunButtonListner(JTextField inputText){
        this.textField = inputText;
    }

    public void actionPerformed(ActionEvent e){

        textField.getText();
    }
}
