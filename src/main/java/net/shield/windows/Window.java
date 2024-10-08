package net.shield.windows;


import net.shield.balance.CurrentBalance;
import net.shield.buttons.Buttons;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window {
    public static JFrame frame = new JFrame();
    public static JPanel buttonPanel = new JPanel();
    public static JPanel outputPanel = new JPanel();
    public static JLabel bankLabel = new JLabel("Bank Account Access");
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    PopupWindow popupWindow = new PopupWindow();


    public void init(int x, int y) {
        frame.add(outputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.WEST);
        LineBorder border = new LineBorder(Color.BLACK);
        buttonPanel.setBorder(border);
        buttonPanel.add(Buttons.addFunds);
        buttonPanel.add(Buttons.checkBalance);
        outputPanel.setBorder(border);
        bankLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        outputPanel.add(bankLabel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(x/2, y/2);

        Buttons.initButtons(x/4, y/4);

        frame.setVisible(true);

        Buttons.checkBalance.addActionListener((ActionEvent e) -> {
            if (e.getSource() == Buttons.checkBalance) {
                popupWindow.clear();
                popupWindow.popOutLabel.setText("You have $" + CurrentBalance.Balance);
                popupWindow.init((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight(), true);
            }
        });

        Buttons.addFunds.addActionListener((ActionEvent e) -> {
            if (e.getSource() == Buttons.addFunds) {
                popupWindow.clear();
                popupWindow.init((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight(), false);
            }
        });

        popupWindow.popOutTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getSource() == popupWindow.popOutTextArea) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        popupWindow.popOutFrame.dispose();
                        CurrentBalance.Balance += Integer.parseInt(popupWindow.popOutTextArea.getText());
                        popupWindow.popOutTextArea.setText("");
                        popupWindow.popOutTextArea.setColumns(0);
                        popupWindow.popOutTextArea.setRows(0);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
