package gui;

import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddPatientFrame extends JFrame {
    private JTextField nameField;
    private JTextField idField;
    private JTextField symptomsField;
    private List<Patient> patientList; // Reference to the patient list

    public AddPatientFrame(List<Patient> patientList) {
        this.patientList = patientList; // Assign to the class variable
        setTitle("Add Patient");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Create input fields
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel symptomsLabel = new JLabel("Symptoms:");
        symptomsField = new JTextField();

        // Create the add button
        JButton addButton = new JButton("Add Patient");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient(); // Call method to add patient
            }
        });

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(symptomsLabel);
        add(symptomsField);
        add(addButton);

        setVisible(true);
    }

    private void addPatient() {
        String name = nameField.getText();
        String id = idField.getText();
        String symptoms = symptomsField.getText();

        // Validate input
        if (name.isEmpty() || id.isEmpty() || symptoms.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        // Create a new patient object and add it to the list
        Patient patient = new Patient(name, id, symptoms);
        patientList.add(patient);
        JOptionPane.showMessageDialog(this, "Patient added successfully!");

        // Optionally clear fields after adding
        nameField.setText("");
        idField.setText("");
        symptomsField.setText("");
    }
}