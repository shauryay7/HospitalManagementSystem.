package gui;

import model.Patient;
import model.Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Date;

public class AppointmentFrame extends JFrame {
    private List<Patient> patientList;
    private JComboBox<String> doctorComboBox;
    private JComboBox<Patient> patientComboBox;
    private JSpinner dateSpinner;

    public AppointmentFrame(List<Patient> patientList) {
        this.patientList = patientList;

        setTitle("Schedule Appointment");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Create components
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

        // Add components to frame
        add(patientLabel);
        add(patientComboBox);
        add(doctorLabel);
        add(doctorComboBox);
        add(dateLabel);
        add(dateSpinner);
        add(new JLabel()); // Empty label for spacing
        add(scheduleButton);

        setVisible(true);
    }

    private void scheduleAppointment() {
        Patient selectedPatient = (Patient) patientComboBox.getSelectedItem();
        String selectedDoctor = (String) doctorComboBox.getSelectedItem();
        Date appointmentDate = (Date) dateSpinner.getValue(); // Get the selected date from the JSpinner

        if (selectedPatient != null && selectedDoctor != null && appointmentDate != null) {
            Appointment appointment = new Appointment(selectedPatient, selectedDoctor, appointmentDate);
            JOptionPane.showMessageDialog(this, "Appointment Scheduled Successfully!");
            // You can now store the appointment or display it in a list.
            dispose(); // Close the frame after scheduling
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }
}