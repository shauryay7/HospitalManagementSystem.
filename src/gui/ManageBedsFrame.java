package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Bed;

public class ManageBedsFrame extends JFrame {
    private ArrayList<Bed> beds;
    private JTextArea bedStatusArea;
    private JTextField bedIdField;

    public ManageBedsFrame() {
        beds = new ArrayList<>();
        // Initialize some beds
        for (int i = 1; i <= 10; i++) {
            beds.add(new Bed("Bed " + i));
        }

        setTitle("Manage Beds");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        bedStatusArea = new JTextArea();
        bedStatusArea.setEditable(false);
        updateBedStatus();

        bedIdField = new JTextField(10);
        JButton occupyButton = new JButton("Occupy Bed");
        JButton vacateButton = new JButton("Vacate Bed");

        occupyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                occupyBed();
            }
        });

        vacateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vacateBed();
            }
        });

        // Input Panel in ManageBedsFrame
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false); // Make it transparent
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Centered layout

        occupyButton.setPreferredSize(new Dimension(120, 30)); // Set preferred size
        vacateButton.setPreferredSize(new Dimension(120, 30)); // Set preferred size

        inputPanel.add(new JLabel("Bed ID:"));
        inputPanel.add(bedIdField);
        inputPanel.add(occupyButton);
        inputPanel.add(vacateButton);

        // Add scroll pane for the bed status area
        JScrollPane scrollPane = new JScrollPane(bedStatusArea);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        backgroundPanel.add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void occupyBed() {
        String bedId = bedIdField.getText();
        for (Bed bed : beds) {
            if (bed.getBedId().equalsIgnoreCase(bedId) && !bed.isOccupied()) {
                bed.occupy();
                updateBedStatus();
                JOptionPane.showMessageDialog(this, "Bed " + bedId + " occupied.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Bed " + bedId + " is not available or does not exist.");
    }

    private void vacateBed() {
        String bedId = bedIdField.getText();
        for (Bed bed : beds) {
            if (bed.getBedId().equalsIgnoreCase(bedId) && bed.isOccupied()) {
                bed.vacate();
                updateBedStatus();
                JOptionPane.showMessageDialog(this, "Bed " + bedId + " vacated.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Bed " + bedId + " is already vacant or does not exist.");
    }

    private void updateBedStatus() {
        StringBuilder status = new StringBuilder("Bed Status:\n");
        for (Bed bed : beds) {
            status.append(bed.getBedId()).append(": ")
                    .append(bed.isOccupied() ? "Occupied" : "Available").append("\n");
        }
        bedStatusArea.setText(status.toString());
    }
}