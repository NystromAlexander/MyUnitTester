import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roguz on 2016-11-11.
 */
public class ClearButtonListner implements ActionListener {
    private JTextArea txtArea;

    public ClearButtonListner(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    public void actionPerformed(ActionEvent e) {
        txtArea.setText(null);
    }
}
