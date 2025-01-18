import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class WelcomePage extends JFrame implements ActionListener {

    private JLabel lblWelcome, lblUsername, lblPassword, lblImage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnNotMember;
    private Container cp;
    private ArrayList<Customers> customers;
    private Clip clip;

    public WelcomePage() {
        super.setTitle("Zuss Kopiess App - Welcome");
        super.setSize(350, 400);
        super.setLocation(600,250); //jarak dari hujung screen;
        cp = super.getContentPane();

        // Initialize audio playback
        playAudio("C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\espressoSong.wav");

        customers = new ArrayList<>();
        customers.add(new Customers("user1", "password1"));
        customers.add(new Customers("admin", "admin"));

        prepareNorthPanel();
        prepareCenterPanel();
        prepareSouthPanel();

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void playAudio(String audioFilePath) {
        try {
            File audioFile = new File(audioFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // Play the audio
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Optional: Loop the audio
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error playing audio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void prepareNorthPanel() {
        lblWelcome = new JLabel("˚ʚ Welcome to Zuss Kopiess ɞ˚ ", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
        lblWelcome.setBorder(new EmptyBorder(10, 10, 10, 10));
        lblWelcome.setForeground(Color.black);

        ImageIcon coffeeIcon = new ImageIcon(getClass().getResource("/download.png"));
        Image scaledImage = coffeeIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        coffeeIcon = new ImageIcon(scaledImage);

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
        btnLogin.setBackground(new Color(34, 139, 34));
        btnLogin.setForeground(Color.WHITE);
        btnNotMember.setBackground(new Color(255, 69, 0));
        btnNotMember.setForeground(Color.WHITE);

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

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        lblUsername.setFont(labelFont);
        lblPassword.setFont(labelFont);

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        txtUsername.setBackground(Color.LIGHT_GRAY);
        txtPassword.setBackground(Color.LIGHT_GRAY);
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(2, 2, 10, 10));

        Font customFont = new Font("Tahoma", Font.PLAIN, 16);
        txtPassword.setFont(customFont);
        txtUsername.setFont(customFont);

        pnlCenter.add(lblUsername);
        pnlCenter.add(txtUsername);
        pnlCenter.add(lblPassword);
        pnlCenter.add(txtPassword);

        pnlCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
        cp.add(pnlCenter, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new WelcomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            char[] passwordArr = txtPassword.getPassword();
            String password = String.valueOf(passwordArr);

            boolean userFound = false;

            // Check for admin login
            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login Success! Welcome to Zuss Kopiess :)");
                stopAudio();
                new Coffee().setVisible(true);
                this.dispose();
                return;
            }

            // Check for regular user login
            for (Customers customer : customers) {
                if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(this, "Welcome back, " + username + ":) !");
                    userFound = true;
                    stopAudio();
                    new Coffee().setVisible(true);
                    this.dispose();
                    break;
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(this, "Invalid username/password", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == btnNotMember) {
            String newUsername = JOptionPane.showInputDialog(null, "Enter a username:");
            if (newUsername == null || newUsername.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty");
                return;
            }

            for (Customers customer : customers) {
                if (customer.getUsername().equals(newUsername)) {
                    JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different one.");
                    return;
                }
            }

            String newPassword = JOptionPane.showInputDialog(null, "Enter a password:");
            if (newPassword == null || newPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password cannot be empty.");
                return;
            }

            customers.add(new Customers(newUsername, newPassword));
            JOptionPane.showMessageDialog(this, "Sign-up successful! You can log in now.");
        }
    }

    private void stopAudio() {
        if (clip != null && clip.isRunning()) {
           // clip.stop();
        }
    }
}
