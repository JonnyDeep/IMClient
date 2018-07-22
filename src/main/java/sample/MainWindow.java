package sample;

import sun.rmi.runtime.Log;

import javax.swing.*;

public class MainWindow {
    public static void main(String[] args) {
        final LoginUI loginUI = new LoginUI(330,430);
        loginUI.setBackground();

        loginUI.setVisible(true);
        Runnable rb = new Runnable() {
            @Override
            public void run() {
                loginUI.dragTheWindow();
            }
        };
        SwingUtilities.invokeLater(rb);
    }
}
