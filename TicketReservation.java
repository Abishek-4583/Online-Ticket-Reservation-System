// TicketReservation.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TicketReservation extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField ticketTypeField;
    private JButton bookButton;
    private JTextArea registeredUsersArea;
    private ArrayList<String> registeredUsers;

    public TicketReservation() {
        registeredUsers = new ArrayList<>();

        setLayout(new BorderLayout());

        // Create fields for ticket reservation
        nameField = new JTextField(10);
        emailField = new JTextField(10);
        phoneNumberField = new JTextField(10);
        ticketTypeField = new JTextField(10);

        // Create book button
        bookButton = new JButton("Book Ticket");

        // Add action listener to button
        bookButton.addActionListener(new BookButtonListener());

        // Create panel for fields and button
        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Ticket Type:"));
        panel.add(ticketTypeField);
        panel.add(bookButton);

        // Create text area to display registered users
        registeredUsersArea = new JTextArea(10, 20);
        registeredUsersArea.setEditable(false);

        // Create scroll pane for text area
        JScrollPane scrollPane = new JScrollPane(registeredUsersArea);

        // Add panel and scroll pane to frame
        add(panel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.EAST);

        // Set frame properties
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class BookButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get user input
            String name = nameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String ticketType = ticketTypeField.getText();

            // Validate user input
            if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || ticketType.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
                return;
            }

            // Book ticket and display confirmation message
            JOptionPane.showMessageDialog(null, "Ticket booked successfully!");

            // Add user to registered users list
            registeredUsers.add("Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nTicket Type: " + ticketType + "\n");

            // Update registered users text area
            updateRegisteredUsersArea();

            // Clear fields
            nameField.setText("");
            emailField.setText("");
            phoneNumberField.setText("");
            ticketTypeField.setText("");
        }
    }

    private void updateRegisteredUsersArea() {
        StringBuilder sb = new StringBuilder();
        for (String user : registeredUsers) {
            sb.append(user).append("\n\n");
        }
        registeredUsersArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new TicketReservation();
    }
}