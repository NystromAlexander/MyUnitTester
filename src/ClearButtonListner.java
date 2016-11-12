import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexander Nyström(dv15anm) on 2016-11-11.
 *
 */

public class ClearButtonListner implements ActionListener {
    private JTextArea txtArea;
    private JTextField textInput;

    public ClearButtonListner(JTextArea txtArea, JTextField textInput) {
        this.txtArea = txtArea;
        this.textInput = textInput;
    }

    public void actionPerformed(ActionEvent e) {
        txtArea.setText(null);
        textInput.selectAll();
        textInput.requestFocus();
    }
}
