package com.devansh.surveysystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Survey System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Create input fields and labels
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ratingLabel = new JLabel("Rating (1-5):");
        JComboBox<Integer> ratingBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});

        JLabel feedbackLabel = new JLabel("Feedback:");
        JTextArea feedbackArea = new JTextArea(3, 20);
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);

        // Create a submit button
        JButton submitButton = new JButton("Submit");

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ratingLabel);
        frame.add(ratingBox);
        frame.add(feedbackLabel);

        // Add feedback area inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        frame.add(scrollPane);
        frame.add(new JLabel()); // Spacer for alignment
        frame.add(submitButton);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Integer rating = (Integer) ratingBox.getSelectedItem();
                String feedback = feedbackArea.getText();

                // Display a thank you message
                JOptionPane.showMessageDialog(frame, "Thank you for your feedback, " + name + "!\n" +
                        "Rating: " + rating + "\nFeedback: " + feedback, "Thank You", JOptionPane.INFORMATION_MESSAGE);

                // Clear fields after submission
                nameField.setText("");
                ratingBox.setSelectedIndex(0);
                feedbackArea.setText("");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
