import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame implements ActionListener {

    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnNotMember;
    private Container cp; // content pane

    public WelcomePage() {
        super.setTitle("Zuss Coffee - Welcome");
        super.setSize(350, 200);
        cp = super.getContentPane();

        prepareCenterPanel();
        prepareSouthPanel();

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void prepareSouthPanel() {
        btnLogin = new JButton("Login");
        btnNotMember = new JButton("Not a Member");

        btnLogin.addActionListener(this);
        btnNotMember.addActionListener(this);

        // create a JPanel using GridLayout, 1x2
        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(new GridLayout(1, 2, 10, 0));

        // add elements to pnlSouth
        pnlSouth.add(btnLogin);
        pnlSouth.add(btnNotMember);

        // add pnlSouth to Content Pane
        pnlSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
        cp.add(pnlSouth, BorderLayout.SOUTH);
    }

    private void prepareCenterPanel() {
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        // create a JPanel with GridLayout
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(2, 2, 10, 10));

        // add elements to pnlCenter
        pnlCenter.add(lblUsername);
        pnlCenter.add(txtUsername);
        pnlCenter.add(lblPassword);
        pnlCenter.add(txtPassword);

        // add pnlCenter to Content Pane
        pnlCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
        cp.add(pnlCenter, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new WelcomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            // verify username and password
            String username = txtUsername.getText();
            char[] passwordArr = txtPassword.getPassword();
            String password = String.valueOf(passwordArr);

            if (username.equals("admin") && password.equals("secret")) {
                JOptionPane.showMessageDialog(this, "Login Success! Welcome to Zuss Coffee.");

                super.setVisible(false);
                // Proceed to the main order frame or other actions
                // Example: OrderFrame of = new OrderFrame(username);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username/password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnNotMember) {
            JOptionPane.showMessageDialog(this, "Welcome! Please sign up for a membership or explore as a guest.");
            // Add additional logic for non-membership users if needed
            // Example: new GuestWelcomeFrame();
        }
    }
}
