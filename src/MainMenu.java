import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainMenu extends JFrame implements ActionListener
{
    private JLabel tittle, about,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
    private JLabel img1,img2,img3,img4,img5,img6;
    private Container contain;
    private Image backgroundImage;
    private JButton btn1, btn2, close, printReceipt;

    public MainMenu()
    {
        try {
            backgroundImage = ImageIO.read(new File("src/resouces/cat4.jpeg")); // Adjust the path
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the custom panel as the content pane
        MainMenu.BackgroundPanel backgroundPanel = new MainMenu.BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        //sediakan page
        setSize(900,600); //size kotak
        setLocation(300,100); //jarak dari hujung screen;
        setDefaultCloseOperation(EXIT_ON_CLOSE); //supaya tekan pangkah, terus tutup

        JPanel panelTop = new JPanel();//sediakan panel
        JPanel panel2 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel11 = new JPanel();
        panelTop.setBorder(new EmptyBorder(10, 500, 10, 500)); //set border
        panel2.setLayout(new BorderLayout()); //set layout
        panel2.setBorder(new EmptyBorder(20, 20, 20, 20)); //set border
        panel1.setLayout(new GridLayout(1, 5, 50, 4)); //set layout
        panel1.setBorder(new EmptyBorder(10, 500, 10, 500)); //set border
        panel11.setLayout(new GridLayout(1, 5, 50, 4)); //set layout
        panel11.setBorder(new EmptyBorder(10, 500, 10, 500)); //set border

        tittle = new JLabel("WELCOME TO ZUSS KOPIESS!<3");
        tittle.setFont(new Font("Times New Roman", Font.BOLD, 26));
        tittle.setForeground(new Color(255,255,255)); //change word colour
        lbl1 = new JLabel("****  ABOUT US <3  ****");
        lbl1.setForeground(new Color(101, 67, 33)); //change word colour
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Date Label
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        JLabel dateLabel = new JLabel("Today's Date: " + formattedDate);
        dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));


        about = new JLabel(
                "<html><div style='text-align: center; width: 500px;'>"
                        + "Our system is designed to address the challenges a cafe shop faces in managing daily operations effectively. "
                        + "Cafe shops usually encounter difficulties in handling customer orders, maintaining accurate inventory records, "
                        + "and ensuring efficient payment processing, particularly during peak hours. "
                        + "So, we invented the Zus Coffee system to enhance operational efficiency, reduce errors, "
                        + "and support the business's growth in a competitive market."
                        + "</div></html>",
                SwingConstants.CENTER
        );
        about.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        contain = getContentPane(); //declare dari class J yang tersedia, untuk isi apa ii dalam pane
        contain.setLayout(new FlowLayout());
        contain.add(tittle,BorderLayout.NORTH);
        contain.add(panel2,BorderLayout.CENTER);
        contain.add(panel11);
        contain.add(panel1);
        contain.add(panelTop);
        // Add components to panels
        panelTop.add(tittle);
        panel11.add(lbl1);
        panel2.add(about);
        panel1.add(dateLabel);

        panelTop.setBackground(new Color(210, 180, 140));
        panel11.setBackground(new Color(255, 218, 185));
        panel2.setBackground(new Color(245, 222, 179));
        panel1.setBackground(new Color(255, 218, 185));


        // Add panels to the frame
        add(panelTop, BorderLayout.NORTH);
        add(panel11, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel1, BorderLayout.CENTER);

        button();


    }

    private void button()
    {
        btn1 = new JButton("ORDER FOOD <3");
        btn1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btn2 = new JButton("ORDER DRINK <3");
        btn2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        close = new JButton("CLOSE <3");
        close.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        printReceipt = new JButton("PRINT RECEIPT <3");
        printReceipt.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JPanel panel2 = new JPanel();
        panel2.setBorder(new EmptyBorder(1,1,1,1));
        panel2.setLayout(new GridLayout(1, 4, 50, 50)); // 1 row, 4 columns, spacing adjusted

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        close.addActionListener(this);
        printReceipt.addActionListener(this);

        panel2.add(btn1);
        panel2.add(btn2);
        panel2.add(printReceipt);
        panel2.add(close);
        contain.add(panel2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            // Display Food Window
            Food foodWindow = new Food("Example Food");
            foodWindow.setVisible(true);
        } else if (e.getSource() == btn2) {
            // Display Coffee Window
            Coffee coffeeWindow = new Coffee();
            coffeeWindow.setVisible(true);
        } else if (e.getSource() == printReceipt) {
            // Display Receipt with Total Price
            try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
                StringBuilder receiptContent = new StringBuilder();
                String line;
                double totalPrice = 0.0;

                while ((line = br.readLine()) != null) {
                    receiptContent.append(line).append("\n");
                    if (line.contains("Price:")) {
                        String priceString = line.split("Price:")[1].trim();
                        totalPrice += Double.parseDouble(priceString);
                    }
                }

                receiptContent.append("\nTotal Price: RM").append(String.format("%.2f", totalPrice));
                JOptionPane.showMessageDialog(this, receiptContent.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, "Error reading the receipt file.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(this, "Error parsing price from receipt file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == close) {
            // Confirmation dialog to ensure data is saved
            JOptionPane.showMessageDialog(null, "THANK YOU FOR USING ZUSS KOPIESS!<3");
            ((JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource())).dispose();
        } else {
            System.out.println("Unrecognized action");
        }
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[]args)
    {
        MainMenu mainn = new MainMenu();
        mainn.setVisible(true);
    }
}
