/**
 * Created by Alexander Nyström(dv15anm) on 09/11/2016.
 *
 */


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

    private ClassTester tester;
    private MainWindow gui;

    /**
     * Constructs a new RunButtonListener.
     * @param gui gives the button a access to the content in the gui
     */
    public RunButtonListener(MainWindow gui) {
        tester = new ClassTester();
        this.gui = gui;
    }

    /**
     * Will trigger on an ActionEvent, and will take input from the JTextField
     * and test if it is a valid test class. If it is a valid test class it will
     * run the tests.
     * @param e The event that triggered the method.
     */
    public void actionPerformed(ActionEvent e) {
        if (tester.setupTest(gui.getTextFieldCont())) {
            tester.runTests();
        }
        gui.setTxtOutputCont(tester.getTxtOutput());
    }
}
