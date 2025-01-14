import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame implements ActionListener {

    private JLabel lblWelcome, lblUsername, lblPassword, lblImage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnNotMember;
    private Container cp; //

    public WelcomePage () {
        super.setTitle("Zus Coffee - Welcome");
        super.setSize(350, 400);
        cp = super.getContentPane();

        prepareNorthPanel();
        prepareCenterPanel();
        prepareSouthPanel();

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void prepareNorthPanel() {
        lblWelcome = new JLabel("Welcome to our Zuss Coffee!", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));
        lblWelcome.setBorder(new EmptyBorder(10, 10, 10, 10));


        ImageIcon coffeeIcon = new ImageIcon("zuscoffee.png"); // Update with actual path
        lblImage = new JLabel(coffeeIcon);
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);


        JPanel pnlNorth = new JPanel();
        pnlNorth.setLayout(new BorderLayout());
        pnlNorth.add(lblWelcome, BorderLayout.NORTH);
        pnlNorth.add(lblImage, BorderLayout.CENTER);

        cp.add(pnlNorth, BorderLayout.NORTH);
    }

    private void prepareSouthPanel() {
        btnLogin = new JButton("Login");
        btnNotMember = new JButton("Not a Member?");

        btnLogin.addActionListener(this);
        btnNotMember.addActionListener(this);

        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(new GridLayout(1, 2, 10, 0));

        pnlSouth.add(btnLogin);
        pnlSouth.add(btnNotMember);

        pnlSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
        cp.add(pnlSouth, BorderLayout.SOUTH);
    }

    private void prepareCenterPanel() {
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();


        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(2, 2, 10, 10));


        pnlCenter.add(lblUsername);
        pnlCenter.add(txtUsername);
        pnlCenter.add(lblPassword);
        pnlCenter.add(txtPassword);


        pnlCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
        cp.add(pnlCenter, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new WelcomePage ();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {

            String username = txtUsername.getText();
            char[] passwordArr = txtPassword.getPassword();
            String password = String.valueOf(passwordArr);

            if (username.equals("admin") && password.equals("secret")) {
                JOptionPane.showMessageDialog(this, "Login Success! Welcome to Zuss Coffee.");

                super.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username/password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnNotMember) {
            JOptionPane.showMessageDialog(this, "Welcome! Please sign up for a membership or explore as a guest.");

        }
    }
}
