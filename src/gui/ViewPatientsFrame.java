package gui;

import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class ViewPatientsFrame extends JFrame {
    private JTable patientsTable;
    private DefaultTableModel tableModel;

    public ViewPatientsFrame(List<Patient> patients) {
        setTitle("View Patients");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Use BackgroundPanel
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        // Create column names
        String[] columnNames = {"Name", "ID", "Symptoms"};

        // Initialize table model and JTable
        tableModel = new DefaultTableModel(columnNames, 0);
        patientsTable = new JTable(tableModel);

        // Set black font color for the table
        patientsTable.setForeground(Color.BLACK);
        patientsTable.setBackground(Color.WHITE); // Set background color for better contrast

        // Populate table with patient data
        for (Patient patient : patients) {
            Object[] row = {patient.getName(), patient.getId(), patient.getSymptoms()};
            tableModel.addRow(row);
        }

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(patientsTable);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }
}