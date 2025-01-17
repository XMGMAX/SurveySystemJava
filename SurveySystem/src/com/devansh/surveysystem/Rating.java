package com.devansh.surveysystem;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Rating {
JFrame rating = new JFrame();
private JPanel ratingPanel = new JPanel();
private JSlider slider1 = new JSlider();
private JTextField textField1 = new JTextField();
private JTextArea textArea1 = new JTextArea();
private JButton SUBMITButton = new JButton();
private JLabel rate = new JLabel();
public Rating() {
rating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
rating.setContentPane(ratingPanel);
rating.pack();
rating.setLocationRelativeTo(null);
rating.setVisible(true);
slider1.setMinimum(0);
slider1.setMaximum(5);
slider1.setPaintTicks(true);
slider1.setPaintLabels(true);
slider1.setMajorTickSpacing(1);
SUBMITButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (textField1.getText().equals("") || textArea1.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Please Fill NAME and Feedback to submit.");
} else {
try {
String sql = "insert into rate" + "(Name,Rating,Feedback)" + "values (?,?,?)";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "vishu@2004");
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, textField1.getText());
statement.setString(2, String.valueOf(slider1.getValue()));
statement.setString(3, textArea1.getText());
statement.executeUpdate();
JOptionPane.showMessageDialog(null, "RATED SUCCESSFULLY");
textField1.setText("");
textArea1.setText("");
} catch (Exception ex) {
JOptionPane.showMessageDialog(null, ex.getMessage());
}
}
}
});
slider1.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
rate.setText(String.valueOf(slider1.getValue())+" Star");
}
});
}
}
