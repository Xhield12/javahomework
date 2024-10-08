package net.shield.windows;

import javax.swing.*;
import java.awt.*;

public class PopupWindow {
    public JFrame popOutFrame = new JFrame();
    public JPanel popOutPanel = new JPanel();
    public JLabel popOutLabel = new JLabel("Default Text");
    public static JTextArea popOutTextArea = new JTextArea();

    public void init(int x, int y, boolean request) {
        popOutFrame.setSize(x/4, y/4);
        popOutFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        popOutLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        popOutTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        if (request) {
            popOutPanel.add(popOutLabel);
        }
        else {
            popOutPanel.add(popOutTextArea);
        }
        popOutFrame.add(popOutPanel, BorderLayout.CENTER);
        popOutFrame.setVisible(true);
    }

    public void clear() {
        popOutPanel.removeAll();
        popOutLabel.removeAll();
        popOutTextArea.removeAll();
    }

}
