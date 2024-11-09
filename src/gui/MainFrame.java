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
        setSize(600, 500);  // Increased size to accommodate all buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the patient list
        patientList = new ArrayList<>();

        // Use BackgroundPanel (assumes a class that handles custom backgrounds)
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // Transparent panel
        JLabel titleLabel = new JLabel("Welcome to MediMap");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK); // Set text color for visibility
        titlePanel.add(titleLabel);
        backgroundPanel.add(titlePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Transparent panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // FlowLayout for button control

        JButton addPatientButton = new JButton("Add Patient");
        JButton viewPatientsButton = new JButton("View Patients");
        JButton manageBedsButton = new JButton("Manage Beds");
        JButton appointmentButton = new JButton("Schedule Appointment");
        JButton emergencyServicesButton = new JButton("Emergency Services");
        JButton reportsButton = new JButton("Reports & Analytics"); // New button for reports & analytics
        JButton pharmacyButton = new JButton("Pharmacy"); // New button for Pharmacy management

        // Button dimensions
        Dimension buttonSize = new Dimension(160, 40);
        JButton[] buttons = {addPatientButton, viewPatientsButton, manageBedsButton, appointmentButton, emergencyServicesButton, reportsButton, pharmacyButton};

        for (JButton button : buttons) {
            button.setPreferredSize(buttonSize);
            button.setBackground(new Color(173, 216, 230)); // Light blue for consistency
            button.setForeground(Color.BLACK);
            buttonPanel.add(button);
        }

        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);

        // Action Listeners
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientFrame(patientList); // Pass patient list
            }
        });

        viewPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewPatientsFrame(patientList); // Pass patient list
            }
        });

        manageBedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageBedsFrame(); // Open Manage Beds frame
            }
        });

        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentFrame(patientList); // Open Appointment frame
            }
        });

        emergencyServicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmergencyServicesFrame(); // Open Emergency Services frame
            }
        });

        reportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReportsFrame(patientList); // Open Reports & Analytics frame (implement as needed)
            }
        });

        pharmacyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PharmacyFrame(); // Open Pharmacy management frame
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