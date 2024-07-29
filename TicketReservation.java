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

       
        nameField = new JTextField(10);
        emailField = new JTextField(10);
        phoneNumberField = new JTextField(10);
        ticketTypeField = new JTextField(10);

       
        bookButton = new JButton("Book Ticket");


        bookButton.addActionListener(new BookButtonListener());

      
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

        registeredUsersArea = new JTextArea(10, 20);
        registeredUsersArea.setEditable(false);

     
        JScrollPane scrollPane = new JScrollPane(registeredUsersArea);

    
        add(panel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.EAST);

      
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class BookButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           
            String name = nameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String ticketType = ticketTypeField.getText();

          
            if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || ticketType.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
                return;
            }

        
            JOptionPane.showMessageDialog(null, "Ticket booked successfully!");

        
            registeredUsers.add("Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nTicket Type: " + ticketType + "\n");

           
            updateRegisteredUsersArea();

           
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
