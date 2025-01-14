import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Zuss Coffee - Welcome");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new FlowLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Zuss Coffee!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomePanel.add(welcomeLabel);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());  // Placeholder
        loginPanel.add(loginButton);

        JPanel membershipPanel = new JPanel();
        membershipPanel.setLayout(new FlowLayout());

        JButton notMembershipButton = new JButton("Not a Member?");
        membershipPanel.add(notMembershipButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Placeholder for authentication logic
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        notMembershipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Please visit the counter to register for membership.", "Membership", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(welcomePanel, BorderLayout.NORTH);
        frame.add(loginPanel, BorderLayout.CENTER);
        frame.add(membershipPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
