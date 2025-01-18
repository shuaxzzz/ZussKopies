import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Coffee extends JFrame implements ActionListener
{   //fungsi ActionListener tu supaya sebarang action dibuat, akan masuk kat class bawah (boleh calculate etc)
    private JLabel lblc1, lblc2, lblc3, lblc4, lblc5;
    private JButton placeorder,closee;
    private JLabel img1, img2, img3, img4, img5, imgcat;
    private Container contain;
    private Image backgroundImage; // Background image


    public Coffee()
    {
        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\TheWarmMug\\src\\cat3.jpeg")); // Adjust the path
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the custom panel as the content pane
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        //yang ni boleh declare super, x perlu pon x pe
        JLabel title = new JLabel("THE WARM CUP BY ZUSS KOPIESS <3", SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 27));//Tajuk besar
        setSize(800,600); //size kotak
        setLocation(300,100); //jarak dari hujung screen;
        setDefaultCloseOperation(EXIT_ON_CLOSE); //supaya tekan pangkah, terus tutup

        //cat label
        ImageIcon cat = new ImageIcon(getClass().getResource("cat.jpg"));
        Image scaledImageCat = cat.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        cat = new ImageIcon(scaledImageCat);

        imgcat = new JLabel(cat);

        contain = getContentPane(); //declare dari class J yang tersedia, untuk isi apa ii dalam pane
        contain.setBackground(new Color(173,216,230)); // tukar background color
        contain.setLayout(new FlowLayout());

        imgcat.setBackground(new Color(173,216,230));

        contain.add(title, BorderLayout.NORTH);
        contain.add(imgcat, BorderLayout.NORTH);

        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(1000, 20)); // Width 1, Height 20
        spacer.setOpaque(true); // Make it transparent
        contain.add(spacer, BorderLayout.SOUTH);

        //untuk background
        try {
            // Correct path to the image
            File imageFile = new File("CC:\\Users\\user\\IdeaProjects\\TheWarmMug\\src\\cat3.jpeg"); // Adjust path here
            if (imageFile.exists()) {
                backgroundImage = ImageIO.read(imageFile);
            } else {
                System.out.println("Image file not found: " + imageFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        north();
        labeling();
        //centerr();
        south();


    }

    private void north()
    {
        //image 1
        ImageIcon c1 = new ImageIcon(getClass().getResource("Americano.png"));
        Image scaledImage1 = c1.getImage().getScaledInstance(80, 120, Image.SCALE_SMOOTH);
        c1 = new ImageIcon(scaledImage1);

        //image 2
        ImageIcon c2 = new ImageIcon(getClass().getResource("cappuccino.png"));
        Image scaledImage2 = c2.getImage().getScaledInstance(80, 120, Image.SCALE_SMOOTH);
        c2 = new ImageIcon(scaledImage2);

        //image 3
        ImageIcon c3 = new ImageIcon(getClass().getResource("vanilla.png"));
        Image scaledImage3 = c3.getImage().getScaledInstance(80, 120, Image.SCALE_SMOOTH);
        c3 = new ImageIcon(scaledImage3);

        //image 4
        ImageIcon c4 = new ImageIcon(getClass().getResource("mocha.png"));
        Image scaledImage4 = c4.getImage().getScaledInstance(80, 120, Image.SCALE_SMOOTH);
        c4 = new ImageIcon(scaledImage4);

        //image 5
        ImageIcon c5 = new ImageIcon(getClass().getResource("caramel.png"));
        Image scaledImage5 = c5.getImage().getScaledInstance(80, 120, Image.SCALE_SMOOTH);
        c5 = new ImageIcon(scaledImage5);

        img1 = new JLabel(c1);
        img2 = new JLabel(c2);
        img3 = new JLabel(c3);
        img4 = new JLabel(c4);
        img5 = new JLabel(c5);


        JPanel pnlnorth = new JPanel();  //sediakan panel
        pnlnorth.setLayout(new GridLayout(1, 5, 50, 4)); //set layout
        pnlnorth.setBorder(new EmptyBorder(10, 100, 10, 100)); //set border

        pnlnorth.setBackground(new Color(210, 180, 140)); //set background image kpd biru

        img1.setHorizontalAlignment(SwingConstants.CENTER);
        img2.setHorizontalAlignment(SwingConstants.CENTER);
        img3.setHorizontalAlignment(SwingConstants.CENTER);
        img4.setHorizontalAlignment(SwingConstants.CENTER);
        img5.setHorizontalAlignment(SwingConstants.CENTER);

        img1.setForeground(Color.WHITE);
        img2.setForeground(Color.WHITE);
        img3.setForeground(Color.WHITE);
        img4.setForeground(Color.WHITE);
        img5.setForeground(Color.WHITE);

        contain.add(pnlnorth,BorderLayout.CENTER);
        pnlnorth.add(img1,BorderLayout.CENTER);
        pnlnorth.add(img2,BorderLayout.CENTER);
        pnlnorth.add(img3,BorderLayout.CENTER);
        pnlnorth.add(img4,BorderLayout.CENTER);
        pnlnorth.add(img5,BorderLayout.CENTER);

    }
    private void labeling()
    {
        JPanel panel = new JPanel();
        lblc1 = new JLabel("Americano\n(RM6.90)");
        lblc2 = new JLabel("Cappucino\n(RM9.90)");
        lblc3 = new JLabel("Vanilla Latte\n(RM10.90)");
        lblc4 = new JLabel("Mocha\n(RM12.90)");
        lblc5 = new JLabel("Caramel Latte\n(RM10.90)");

        lblc1.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblc2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblc3.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblc4.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblc5.setFont(new Font("Times New Roman", Font.BOLD, 12));

        panel.setLayout(new GridLayout(1,5,2,3));
        panel.setBorder(new EmptyBorder(10, 100, 10, 100));

        contain.add(panel,BorderLayout.SOUTH);

        panel.add(lblc1);
        panel.add(lblc2);
        panel.add(lblc3);
        panel.add(lblc4);
        panel.add(lblc5);


    }

    /*private void centerr()
    {
        btnc1 = new JButton("Americano<3");
        btnc2 = new JButton("Cappucino<3");
        btnc3 = new JButton("Vanilla Latte<3");
        btnc4 = new JButton("Mocha<3");
        btnc5 = new JButton("Caramel Latte<3");

        btnc1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnc2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnc3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnc4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnc5.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        btnc1.addActionListener(this);
        btnc2.addActionListener(this);
        btnc3.addActionListener(this);
        btnc4.addActionListener(this);
        btnc5.addActionListener(this);

        JPanel pnlcenter = new JPanel();
        pnlcenter.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlcenter.setBorder(new EmptyBorder(20, 100, 100, 100));
        //pnlcenter.setBackground(new Color(173, 216, 230));
        contain.add(pnlcenter, BorderLayout.CENTER);

        pnlcenter.setBackground(new Color(173,216,230)); //set background button kpd blue

        pnlcenter.add(btnc1);
        pnlcenter.add(btnc2);
        pnlcenter.add(btnc3);
        pnlcenter.add(btnc4);
        pnlcenter.add(btnc5);

    }*/
    private void south()
    {

        closee = new JButton("Close <3");
        closee.setFont(new Font("Times New Roman", Font.BOLD, 14));
        closee.addActionListener(this);

        placeorder = new JButton("Place Order <3");
        placeorder.setFont(new Font("Times New Roman", Font.BOLD, 14));
        placeorder.addActionListener(this);


        JPanel pnlsouth = new JPanel();
        contain.add(pnlsouth, BorderLayout.WEST);
        pnlsouth.setLayout(new GridLayout(1, 1, 5, 5));
        pnlsouth.setBorder(new EmptyBorder(0, 0, 0, 0));

        pnlsouth.add(closee);
        pnlsouth.add(placeorder);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        CountCoffee countcp = new CountCoffee();
        CoffeeType kopi = new CoffeeType();
        OrderCoffee of = new OrderCoffee(kopi);
        double total = 0;

        if (e.getSource() == placeorder)
        {
            of.setVisible(true);
        }
        if (e.getSource() == closee)
        {
            // Confirmation dialog to ensure data is saved
            JOptionPane.showMessageDialog(null, "THANK YOU FOR USING ZUSS KOPIESS!<3");

            // Close the window
            ((JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource())).dispose();
        }

    }
    //For background
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
        CoffeeType kopi = new CoffeeType();
        Coffee cc = new Coffee(); //ambil dari class atas
        cc.setVisible(true);

    }
}

