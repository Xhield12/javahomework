package net.shield.buttons;

import javax.swing.*;

public class Buttons {
    public static JButton addFunds = new JButton("Add/remove funds to/from your account");
    public static JButton checkBalance = new JButton("Check the balance of your account");

    public static void initButtons(int x, int y) {
        addFunds.setSize(x, y);
        checkBalance.setSize(x, y);
    }
}
