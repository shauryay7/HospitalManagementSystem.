package gui;

import model.Patient;
import model.Appointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentFrame extends JFrame {
    private List<Patient> patientList;
    private List<Appointment> appointmentList = new ArrayList<>();  // List to store appointments
    private JComboBox<String> doctorComboBox;
    private JComboBox<Patient> patientComboBox;
    private JSpinner dateSpinner;
    private DefaultTableModel tableModel;

    public AppointmentFrame(List<Patient> patientList) {
        this.patientList = patientList;

        setTitle("Schedule Appointment");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create components for scheduling appointments
        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new GridLayout(5, 2));

        JLabel patientLabel = new JLabel("Select Patient:");
        patientComboBox = new JComboBox<>(patientList.toArray(new Patient[0]));

        JLabel doctorLabel = new JLabel("Select Doctor:");
        doctorComboBox = new JComboBox<>(new String[] { "Gynaecologist", "Physician", "Neurologist" });

        JLabel dateLabel = new JLabel("Select Date:");

        // Create a JSpinner with a SpinnerDateModel
        dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd HH:mm:ss"));

        JButton scheduleButton = new JButton("Schedule Appointment");
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleAppointment();
            }
        });

        // Add components to schedule panel
        schedulePanel.add(patientLabel);
        schedulePanel.add(patientComboBox);
        schedulePanel.add(doctorLabel);
        schedulePanel.add(doctorComboBox);
        schedulePanel.add(dateLabel);
        schedulePanel.add(dateSpinner);
        schedulePanel.add(new JLabel()); // Empty label for spacing
        schedulePanel.add(scheduleButton);

        // Add the schedule panel to the top of the frame
        add(schedulePanel, BorderLayout.NORTH);

        // Table to view appointments
        String[] columns = {"Patient Name", "Doctor", "Appointment Date"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable appointmentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(appointmentTable);

        // Add the appointment table to the center of the frame
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void scheduleAppointment() {
        Patient selectedPatient = (Patient) patientComboBox.getSelectedItem();
        String selectedDoctor = (String) doctorComboBox.getSelectedItem();
        Date appointmentDate = (Date) dateSpinner.getValue(); // Get the selected date from the JSpinner

        if (selectedPatient != null && selectedDoctor != null && appointmentDate != null) {
            Appointment appointment = new Appointment(selectedPatient, selectedDoctor, appointmentDate);
            appointmentList.add(appointment);  // Add the new appointment to the list

            // Add the new appointment to the table
            tableModel.addRow(new Object[]{selectedPatient.getName(), selectedDoctor, appointmentDate});

            JOptionPane.showMessageDialog(this, "Appointment Scheduled Successfully!");
            dispose(); // Close the frame after scheduling
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    public static void main(String[] args) {
        // For testing purpose, you can pass a dummy list of patients here
        // Create patients with additional required parameters
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("John Doe", "123 Main St", "123-456-7890"));
        patientList.add(new Patient("Jane Smith", "456 Oak St", "987-654-3210"));

        SwingUtilities.invokeLater(() -> new AppointmentFrame(patientList));
    }
}