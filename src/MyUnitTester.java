/**
 * Created by Alexander Nyström(dv15anm) on 2016-11-07.
 *
 */
import javax.swing.*;

/**
 * MyUnitTester is the class to start the program, this is where the main method
 * is. When executed the GUI will be drawn and the rest of the interaction is
 * handled by the GUI.
 *
 * @version 1.0 14 Nov 2016
 * @author Alexander Nyström
 */
public class MyUnitTester {

    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
