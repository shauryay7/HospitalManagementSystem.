package gui;

import javax.swing.SwingUtilities;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}