/**
 * Created by Alexander Nyström(dv15anm) on 2016-11-11.
 *
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClearButtonListener will trigger on ActionEvent and clear the content of the
 * JTextField, and select the content of JTextField and put the field to focus.
 *
 * @version 1.0 14 Nov 2016
 * @author Alexander Nyström
 */
public class ClearButtonListener implements ActionListener {
    private JTextArea txtArea;
    private JTextField textInput;

    /**
     * Constructs a new ClearButtonListener.
     * @param txtArea The text area that will be cleared when action
     *                is triggered.
     * @param textInput The text field to be set in focus when action
     *                  is triggered.
     */
    public ClearButtonListener(JTextArea txtArea, JTextField textInput) {
        this.txtArea = txtArea;
        this.textInput = textInput;
    }

    /**
     * When triggered it will clear all the content in the JTextArea, then it
     * will select all content in the JTextField and set the field to focus.
     * @param e The event that triggered the method.
     */
    public void actionPerformed(ActionEvent e) {
        txtArea.setText(null);
        textInput.selectAll();
        textInput.requestFocus();
    }
}
