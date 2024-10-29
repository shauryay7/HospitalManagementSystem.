package gui;

import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private List<Patient> patientList; // List to store patients

    public MainFrame() {
        setTitle("Hospital Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the patient list
        patientList = new ArrayList<>();

        // Use BackgroundPanel
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // Make the title panel transparent
        JLabel titleLabel = new JLabel("Welcome to the Hospital Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK); // Change text color for visibility
        titlePanel.add(titleLabel);
        backgroundPanel.add(titlePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the button panel transparent
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Use FlowLayout for better control
        JButton addPatientButton = new JButton("Add Patient");
        JButton viewPatientsButton = new JButton("View Patients");
        JButton manageBedsButton = new JButton("Manage Beds");

        Dimension buttonSize = new Dimension(120, 40);
        // Set preferred, minimum, and maximum sizes for buttons
        addPatientButton.setPreferredSize(buttonSize);
        addPatientButton.setMinimumSize(buttonSize);
        addPatientButton.setMaximumSize(buttonSize);

        viewPatientsButton.setPreferredSize(buttonSize);
        viewPatientsButton.setMinimumSize(buttonSize);
        viewPatientsButton.setMaximumSize(buttonSize);

        manageBedsButton.setPreferredSize(buttonSize);
        manageBedsButton.setMinimumSize(buttonSize);
        manageBedsButton.setMaximumSize(buttonSize);

        // Style buttons
        addPatientButton.setBackground(new Color(0, 128, 0)); // Dark green
        addPatientButton.setForeground(Color.BLACK);
        viewPatientsButton.setBackground(new Color(0, 0, 255)); // Blue
        viewPatientsButton.setForeground(Color.BLACK);
        manageBedsButton.setBackground(new Color(255, 165, 0)); // Orange
        manageBedsButton.setForeground(Color.BLACK);

        buttonPanel.add(addPatientButton);
        buttonPanel.add(viewPatientsButton);
        buttonPanel.add(manageBedsButton);
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);

        // Action Listeners
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientFrame(patientList); // Pass the patient list
            }
        });

        viewPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewPatientsFrame(patientList); // Pass the patient list
            }
        });

        manageBedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageBedsFrame(); // Modify if needed
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}