import javax.swing.*;

/**
 * Created by Alexander Nyström(dv15anm) on 2016-11-07.
 *
 */
public class MyUnitTester {
    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestFrame();
            }
        });
    }
}
