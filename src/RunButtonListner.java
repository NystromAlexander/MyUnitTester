import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexander Nyström(dv15anm) on 09/11/2016.
 *
 */
public class RunButtonListner implements ActionListener {

    private JTextField textField;
    private ClassTester tester;

    public RunButtonListner(JTextField inputText, JTextArea outputText){
        this.textField = inputText;
        tester = new ClassTester(outputText);
    }

    public void actionPerformed(ActionEvent e){
        if(tester.setupTest(textField.getText())) {
            tester.runTests();
        }
    }
}
