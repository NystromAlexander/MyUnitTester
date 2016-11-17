/**
 * Created by Alexander Nyström(dv15anm) on 2016-11-11.
 *
 */

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
    private MainWindow gui;

    /**
     * Constructs a new ClearButtonListener.
     * @param gui gives the button a access to the gui
     */
    public ClearButtonListener(MainWindow gui) {
        this.gui = gui;
    }

    /**
     * When triggered it will clear all the content in the JTextArea, then it
     * will select all content in the JTextField and set the field to focus.
     * @param e The event that triggered the method.
     */
    public void actionPerformed(ActionEvent e) {
        gui.clearTextArea();
        gui.textFieldFocus();
    }
}
