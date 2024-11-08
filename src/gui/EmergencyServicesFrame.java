package gui;

import javax.swing.*;
import java.awt.*;

public class EmergencyServicesFrame extends JFrame {
    public EmergencyServicesFrame() {
        setTitle("Emergency Services");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for the header
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Emergency Services Information", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Panel for the emergency services list
        JPanel servicesPanel = new JPanel();
        servicesPanel.setLayout(new GridLayout(5, 1));

        JLabel emergencyContactLabel = new JLabel("Emergency Contact: 112", SwingConstants.CENTER);
        JLabel ambulanceLabel = new JLabel("Ambulance Service: 1234567890", SwingConstants.CENTER);
        JLabel doctorLabel = new JLabel("Doctors on Call: 9876543210", SwingConstants.CENTER);
        JLabel hospitalInfoLabel = new JLabel("Emergency Department is open 24/7", SwingConstants.CENTER);
        JLabel departmentLabel = new JLabel("Departments: Emergency, ICU, Trauma", SwingConstants.CENTER);

        servicesPanel.add(emergencyContactLabel);
        servicesPanel.add(ambulanceLabel);
        servicesPanel.add(doctorLabel);
        servicesPanel.add(hospitalInfoLabel);
        servicesPanel.add(departmentLabel);

        add(servicesPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new EmergencyServicesFrame(); // Open Emergency Services window directly
    }
}