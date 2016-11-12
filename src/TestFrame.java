/**
 * Created by Alexander Nyström(dv15anm) on 2016-11-07.
 *
 */
import javax.swing.*;
import java.awt.*;

public class TestFrame{

    private JTextArea txtOutput;
    private JTextField txtInput;

    public TestFrame(){
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

    private void northPane(JFrame window){
        JPanel panel1 = new JPanel();
        panel1.add(txtInput);
        JButton runButton = new JButton("Run");
        runButton.addActionListener(new RunButtonListner(txtInput,txtOutput));
        panel1.add(runButton);
        window.add(panel1, BorderLayout.NORTH);
    }

    private void centerPane(JFrame window){
        txtOutput.setEditable(false);
        txtOutput.setRows(15);
        JScrollPane scroll = new JScrollPane(txtOutput);
        window.add(scroll,BorderLayout.CENTER);
    }

    private void southPane(JFrame window){
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListner(txtOutput,
                                        txtInput));
        JPanel panel2 = new JPanel();
        panel2.add(clearButton);
        window.add(panel2,BorderLayout.SOUTH);
    }

}
