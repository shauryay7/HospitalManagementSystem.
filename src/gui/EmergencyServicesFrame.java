package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmergencyServicesFrame extends JFrame {
    public EmergencyServicesFrame() {
        setTitle("Emergency Services");
        setSize(600, 400);
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
        servicesPanel.setLayout(new GridLayout(7, 1, 10, 10));

        JLabel emergencyContactLabel = new JLabel("Emergency Contact: 112", SwingConstants.CENTER);
        JLabel ambulanceLabel = new JLabel("Ambulance Service: 1234567890", SwingConstants.CENTER);
        JLabel doctorLabel = new JLabel("Doctors on Call: 9876543210", SwingConstants.CENTER);
        JLabel hospitalInfoLabel = new JLabel("Emergency Department is open 24/7", SwingConstants.CENTER);
        JLabel departmentLabel = new JLabel("Departments: Emergency, ICU, Trauma", SwingConstants.CENTER);

        // Buttons for calling actions
        JButton callEmergencyButton = new JButton("Call Emergency Contact");
        JButton callAmbulanceButton = new JButton("Call Ambulance Service");
        JButton callDoctorButton = new JButton("Contact Doctor On-Call");

        // Action Listeners for buttons (simulated functionality)
        callEmergencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EmergencyServicesFrame.this,
                        "Dialing Emergency Contact: 112", "Call", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        callAmbulanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EmergencyServicesFrame.this,
                        "Dialing Ambulance Service: 1234567890", "Call", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        callDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EmergencyServicesFrame.this,
                        "Connecting to Doctor On-Call: 9876543210", "Contact", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Adding components to services panel
        servicesPanel.add(emergencyContactLabel);
        servicesPanel.add(ambulanceLabel);
        servicesPanel.add(doctorLabel);
        servicesPanel.add(hospitalInfoLabel);
        servicesPanel.add(departmentLabel);
        servicesPanel.add(callEmergencyButton);
        servicesPanel.add(callAmbulanceButton);
        servicesPanel.add(callDoctorButton);

        add(servicesPanel, BorderLayout.CENTER);

        // Panel for FAQ section
        JPanel faqPanel = new JPanel();
        faqPanel.setBorder(BorderFactory.createTitledBorder("Frequently Asked Questions"));
        faqPanel.setLayout(new GridLayout(3, 1));

        JButton faqButton1 = new JButton("What should I do during an emergency?");
        JButton faqButton2 = new JButton("How to contact the hospital for urgent care?");
        JButton faqButton3 = new JButton("What are the critical care services offered?");

        // Action listeners for FAQ buttons (simulated responses)
        faqButton1.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "In case of an emergency, call 112 immediately. Follow the instructions provided.", "FAQ", JOptionPane.INFORMATION_MESSAGE));
        faqButton2.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "You can contact the hospital's emergency department through the provided numbers for urgent care.", "FAQ", JOptionPane.INFORMATION_MESSAGE));
        faqButton3.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "The hospital offers Emergency, ICU, Trauma care, and 24/7 on-call doctors.", "FAQ", JOptionPane.INFORMATION_MESSAGE));

        faqPanel.add(faqButton1);
        faqPanel.add(faqButton2);
        faqPanel.add(faqButton3);

        add(faqPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new EmergencyServicesFrame(); // Open Emergency Services window directly
    }
}