package gui;

import model.Drug;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacyFrame extends JFrame {
    private List<Drug> drugList; // List to store drugs
    private DefaultTableModel tableModel;

    public PharmacyFrame() {
        // Initialize the drug list
        drugList = new ArrayList<>();

        // Set up the frame
        setTitle("Pharmacy Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center window on screen

        // Use a SpringLayout to position components
        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);

        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Pharmacy Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel);

        // Panel for Adding Drugs
        JPanel addDrugPanel = new JPanel();
        addDrugPanel.setLayout(new GridLayout(4, 2, 10, 10));

        // Add Drug Form Inputs
        JLabel drugNameLabel = new JLabel("Drug Name:");
        JTextField drugNameField = new JTextField(15);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(10);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(10);

        JButton addDrugButton = new JButton("Add Drug");

        // Add components to the panel
        addDrugPanel.add(drugNameLabel);
        addDrugPanel.add(drugNameField);
        addDrugPanel.add(quantityLabel);
        addDrugPanel.add(quantityField);
        addDrugPanel.add(priceLabel);
        addDrugPanel.add(priceField);
        addDrugPanel.add(addDrugButton);

        mainPanel.add(addDrugPanel);

        // Table Panel for Viewing Drugs
        String[] columns = {"Drug Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable drugTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(drugTable);
        mainPanel.add(scrollPane);

        // Add Drug Action Listener
        addDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String drugName = drugNameField.getText();
                int quantity;
                double price;

                try {
                    quantity = Integer.parseInt(quantityField.getText());
                    price = Double.parseDouble(priceField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PharmacyFrame.this, "Please enter valid numbers for quantity and price.");
                    return;
                }

                // Create new drug object
                Drug newDrug = new Drug(drugName, quantity, price);
                drugList.add(newDrug);
                tableModel.addRow(new Object[]{drugName, quantity, price});

                // Save the updated list to a file
                saveDrugsToFile();

                // Clear form after adding the drug
                drugNameField.setText("");
                quantityField.setText("");
                priceField.setText("");
            }
        });

        // Set layout constraints to prevent overlap
        layout.putConstraint(SpringLayout.NORTH, titlePanel, 10, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, titlePanel, 10, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, addDrugPanel, 50, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, addDrugPanel, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, addDrugPanel, -10, SpringLayout.EAST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, scrollPane, 150, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, mainPanel);

        // Add mainPanel to the JFrame
        setContentPane(mainPanel);
        setVisible(true);
    }

    // Save the list of drugs to a file
    private void saveDrugsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("drugs.ser"))) {
            oos.writeObject(drugList); // Save the drug list
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data.");
            e.printStackTrace();
        }
    }

    // Load the drug list from a file (optional)
    private void loadDrugsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("drugs.ser"))) {
            drugList = (List<Drug>) ois.readObject();
            for (Drug drug : drugList) {
                tableModel.addRow(new Object[]{drug.getDrugName(), drug.getQuantity(), drug.getPrice()});
            }
        } catch (IOException | ClassNotFoundException e) {
            // Handle exception or if file does not exist
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PharmacyFrame frame = new PharmacyFrame();
            frame.loadDrugsFromFile(); // Load drugs on startup if available
            frame.setVisible(true);
        });
    }
}