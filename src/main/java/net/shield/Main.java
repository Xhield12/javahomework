package net.shield;

import net.shield.balance.CurrentBalance;
import net.shield.windows.Window;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static Window window = new Window();

    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        System.out.print("Please input an integer for your starting balance: ");
        Scanner scanner = new Scanner(System.in);
        CurrentBalance.Balance = scanner.nextInt();
        window.init((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight());
    }
}