package gui;

import model.Bed;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManageBedsFrame extends JFrame {
    private List<Bed> bedList; // List to store beds
    private DefaultTableModel tableModel;

    public ManageBedsFrame() {
        // Initialize the bed list
        bedList = new ArrayList<>();

        // Set up the frame
        setTitle("Manage Beds");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Background Panel
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Manage Bed Availability");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.black);
        titlePanel.add(titleLabel);
        backgroundPanel.add(titlePanel, BorderLayout.NORTH);

        // Add New Bed Panel
        JPanel addBedPanel = new JPanel();
        addBedPanel.setOpaque(false);
        addBedPanel.setLayout(new GridLayout(5, 2, 10, 10));
        addBedPanel.add(new JLabel("Bed Number:"));
        JTextField bedNumberField = new JTextField();
        addBedPanel.add(bedNumberField);

        addBedPanel.add(new JLabel("Bed Type:"));
        JComboBox<String> bedTypeComboBox = new JComboBox<>(new String[]{"ICU", "General", "Emergency"});
        addBedPanel.add(bedTypeComboBox);

        addBedPanel.add(new JLabel("Status:"));
        JComboBox<String> bedStatusComboBox = new JComboBox<>(new String[]{"Available", "Occupied"});
        addBedPanel.add(bedStatusComboBox);

        // Buttons for adding, clearing, and searching
        JButton addBedButton = new JButton("Add Bed");
        addBedButton.setBackground(new Color(0, 128, 0));
        addBedButton.setForeground(Color.black);
        addBedPanel.add(addBedButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(255, 0, 0));
        clearButton.setForeground(Color.black);
        addBedPanel.add(clearButton);

        backgroundPanel.add(addBedPanel, BorderLayout.CENTER);

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchPanel.setOpaque(false);
        searchPanel.add(new JLabel("Search:"));
        JTextField searchField = new JTextField(15);
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);
        backgroundPanel.add(searchPanel, BorderLayout.SOUTH);

        // Table Panel for Viewing Beds
        String[] columns = {"Bed Number", "Bed Type", "Status", "Actions"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable bedTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bedTable);
        backgroundPanel.add(scrollPane, BorderLayout.EAST);

        // Add Bed Action Listener
        addBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bedNumber = bedNumberField.getText();
                String bedType = (String) bedTypeComboBox.getSelectedItem();
                String bedStatus = (String) bedStatusComboBox.getSelectedItem();

                if (bedNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(ManageBedsFrame.this, "Please enter a bed number.");
                    return;
                }

                Bed newBed = new Bed(bedNumber, bedType, bedStatus);
                bedList.add(newBed);
                tableModel.addRow(new Object[]{bedNumber, bedType, bedStatus, "Edit | Delete"});

                // Clear form after adding the bed
                bedNumberField.setText("");
                bedTypeComboBox.setSelectedIndex(0);
                bedStatusComboBox.setSelectedIndex(0);
            }
        });

        // Clear Form Button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bedNumberField.setText("");
                bedTypeComboBox.setSelectedIndex(0);
                bedStatusComboBox.setSelectedIndex(0);
            }
        });

        // Search Button Action
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                tableModel.setRowCount(0); // Clear the table before searching

                for (Bed bed : bedList) {
                    if (bed.getBedNumber().toLowerCase().contains(searchText) || bed.getBedType().toLowerCase().contains(searchText)) {
                        tableModel.addRow(new Object[]{bed.getBedNumber(), bed.getBedType(), bed.getBedStatus(), "Edit | Delete"});
                    }
                }
            }
        });

        setVisible(true);
    }

    // Bed class
    public class Bed {
        private String bedNumber;
        private String bedType;
        private String bedStatus;

        public Bed(String bedNumber, String bedType, String bedStatus) {
            this.bedNumber = bedNumber;
            this.bedType = bedType;
            this.bedStatus = bedStatus;
        }

        public String getBedNumber() {
            return bedNumber;
        }

        public String getBedType() {
            return bedType;
        }

        public String getBedStatus() {
            return bedStatus;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManageBedsFrame(); // Open the manage beds frame
        });
    }
}