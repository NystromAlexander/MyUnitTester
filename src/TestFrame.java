/**
 * Created by Roguz on 2016-11-07.
 */
import javax.swing.*;
import java.awt.*;

public class TestFrame{


    public TestFrame(){
        JFrame window = new JFrame("MyUnitTester");
        northPane(window);
        centerPane(window);
    }

    private void northPane(JFrame window){
        JPanel panel1 = new JPanel();
        JTextField txtInput = new JTextField();
        panel1.add(txtInput);
        JButton runButton = new JButton("Run");
        panel1.add(runButton);
        window.add(panel1, BorderLayout.NORTH);
    }

    private void centerPane(JFrame window){
        JTextArea txtOutPut = new JTextArea();
        txtOutPut.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtOutPut);
        window.add(scroll,BorderLayout.CENTER);
    }
}
