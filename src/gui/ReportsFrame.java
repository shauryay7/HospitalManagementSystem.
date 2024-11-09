package gui;

import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReportsFrame extends JFrame {
    private List<Patient> patientList;

    public ReportsFrame(List<Patient> patientList) {
        this.patientList = patientList;
        setTitle("Reports and Analytics");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Reports and Analytics", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Main Report Panel
        JPanel reportPanel = new JPanel();
        reportPanel.setLayout(new GridLayout(4, 1));

        // Example Metrics - You can add more metrics here
        JLabel totalPatientsLabel = new JLabel("Total Patients: " + patientList.size(), SwingConstants.CENTER);
        JLabel occupiedBedsLabel = new JLabel("Occupied Beds: Calculate...", SwingConstants.CENTER); // Placeholder
        JLabel availableBedsLabel = new JLabel("Available Beds: Calculate...", SwingConstants.CENTER); // Placeholder
        JLabel appointmentStatsLabel = new JLabel("Appointments Scheduled: Calculate...", SwingConstants.CENTER); // Placeholder

        reportPanel.add(totalPatientsLabel);
        reportPanel.add(occupiedBedsLabel);
        reportPanel.add(availableBedsLabel);
        reportPanel.add(appointmentStatsLabel);

        add(reportPanel, BorderLayout.CENTER);

        // Display the frame
        setVisible(true);
    }
}