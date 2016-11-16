/**
 * Created by Alexander Nyström(dv15anm) on 2016-11-07.
 *
 */
import javax.swing.*;
import java.awt.*;

/**
 * MainWindow the main window for MyUnitTester. Has a text field for input in
 * the north panel with a button to run tests to the right of it.
 * In the center panel it has a text area where the results of the tests will
 * be written. In the south panel it has a button to clear the content of the
 * text area in the center panel.
 *
 * @version 1.0 14 Nov 2016
 * @author Alexander Nyström
 */
public class MainWindow {
    private JTextArea txtOutput;
    private JTextField txtInput;

    /**
     * Constructs a new MainWindow
     */
    public MainWindow() {
        JFrame window = new JFrame("MyUnitTester");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        txtInput = new JTextField(25);
        txtOutput = new JTextArea();
        northPane(window);
        centerPane(window);
        southPane(window);
        window.pack();
        window.setVisible(true);

    }

    /**
     * Creates the north panel with a JTextField and a JButton and adds it
     * to the window.
     * @param window the frame where the components will be added.
     */
    private void northPane(JFrame window) {
        JPanel panel1 = new JPanel();
        txtInput.addActionListener(new RunButtonListener(txtInput,txtOutput));
        panel1.add(txtInput);
        JButton runButton = new JButton("Run tests");
        runButton.addActionListener(new RunButtonListener(txtInput,txtOutput));
        panel1.add(runButton);
        window.add(panel1, BorderLayout.NORTH);
    }

    /**
     * Creates the center panel with a scroll pane with an JTextArea and adds it
     * to the window.
     * @param window the frame where the components will be added.
     */
    private void centerPane(JFrame window) {
        txtOutput.setEditable(false);
        txtOutput.setRows(15);
        JScrollPane scroll = new JScrollPane(txtOutput);
        window.add(scroll,BorderLayout.CENTER);
    }

    /**
     * Creates the south panel with a JButton meant to clear the content of
     * the JTextArea.
     * @param window the frame where the components will be added.
     */
    private void southPane(JFrame window) {
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListener(txtOutput,
                                        txtInput));
        JPanel panel2 = new JPanel();
        panel2.add(clearButton);
        window.add(panel2,BorderLayout.SOUTH);
    }

}
