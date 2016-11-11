/**
 * Created by Roguz on 2016-11-07.
 */
import javax.swing.*;
import java.awt.*;

public class TestFrame{

    private JTextArea txtOutput;

    public TestFrame(){
        JFrame window = new JFrame("MyUnitTester");
        northPane(window);
        centerPane(window);
        southPane(window);
        window.pack();
        window.setVisible(true);

    }

    private void northPane(JFrame window){
        JPanel panel1 = new JPanel();
        JTextField txtInput = new JTextField(25);
        panel1.add(txtInput);
        JButton runButton = new JButton("Run");
        runButton.addActionListener(new RunButtonListner(txtInput));
        panel1.add(runButton);
        window.add(panel1, BorderLayout.NORTH);
    }

    private void centerPane(JFrame window){
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setRows(15);
        JScrollPane scroll = new JScrollPane(txtOutput);
        window.add(scroll,BorderLayout.CENTER);
    }

    private void southPane(JFrame window){
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListner(txtOutput));
        JPanel panel2 = new JPanel();
        panel2.add(clearButton);
        window.add(panel2,BorderLayout.SOUTH);
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestFrame();
            }
        });
    }
}
