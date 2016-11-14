/**
 * Created by Alexander Nyström(dv15anm) on 09/11/2016.
 *
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * RunButtonListener will trigger on an ActionEvent and will run the ClassTester
 * if the given class name from the JTextField is a valid test class.
 *
 * @version 1.0 14 Nov 2016
 * @author Alexander Nyström
 */
public class RunButtonListener implements ActionListener {
    private JTextField textField;
    private ClassTester tester;

    /**
     * Constructs a new RunButtonListener.
     * @param inputText The text field which will provide input.
     * @param outputText The text area which will be used for output from the
     *                   ClassTester.
     */
    public RunButtonListener(JTextField inputText, JTextArea outputText) {
        this.textField = inputText;
        tester = new ClassTester(outputText);
    }

    /**
     * Will trigger on an ActionEvent, and will take input from the JTextField
     * and test if it is a valid test class. If it is a valid test class it will
     * run the tests.
     * @param e The event that triggered the method.
     */
    public void actionPerformed(ActionEvent e) {
        if (tester.setupTest(textField.getText())) {
            tester.runTests();
        }
    }
}
