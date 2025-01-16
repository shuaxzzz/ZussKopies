import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coffee extends JFrame implements ActionListener
{   //fungsi ActionListener tu supaya sebarang action dibuat, akan masuk kat class bawah (boleh calculate etc)
    private JLabel title,lblc1, lblc2, lblc3, lblc4, lblc5;
    private JButton btnc1, btnc2, btnc3, btnc4, btnc5, about;
    private JLabel img1, img2, img3, img4, img5, imgcat;
    private Container contain;


    public Coffee()
    {
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

        north();
        centerr();
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
        pnlnorth.setLayout(new GridLayout(1, 5, 50, 10)); //set layout
        pnlnorth.setBorder(new EmptyBorder(10, 100, 10, 100)); //set border

        pnlnorth.setBackground(new Color(173,216,230)); //set background image kpd biru

        img1.setHorizontalAlignment(SwingConstants.CENTER);
        img2.setHorizontalAlignment(SwingConstants.CENTER);
        img1.setHorizontalAlignment(SwingConstants.CENTER);
        img2.setHorizontalAlignment(SwingConstants.CENTER);
        img1.setHorizontalAlignment(SwingConstants.CENTER);

        contain.add(pnlnorth,BorderLayout.CENTER);
        pnlnorth.add(img1,BorderLayout.CENTER);
        pnlnorth.add(img2,BorderLayout.CENTER);
        pnlnorth.add(img3,BorderLayout.CENTER);
        pnlnorth.add(img4,BorderLayout.CENTER);
        pnlnorth.add(img5,BorderLayout.CENTER);

    }

    private void centerr()
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

    }
    private void south()
    {
        about = new JButton("About Us OwO<3");
        about.setFont(new Font("Times New Roman", Font.PLAIN,20));

        JPanel pnlsouth = new JPanel();
        contain.add(pnlsouth, BorderLayout.WEST);
        pnlsouth.setLayout(new GridLayout(1, 1, 1, 1));
        pnlsouth.setBorder(new EmptyBorder(0, 0, 0, 0));

        pnlsouth.add(about);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        CoffeeType[] kopi = new CoffeeType[5];
        kopi[0] = new extendsCoffeeType("Americano", 16.90, 0, "","","","");
        kopi[1] = new extendsCoffeeType("Cappucino", 16.90, 0, "","","","");
        kopi[2] = new extendsCoffeeType("Vanilla", 16.90, 0, "","","","");
        kopi[3] = new extendsCoffeeType("Mocha", 16.90, 0, "","","","");
        kopi[4] = new extendsCoffeeType("Caramel", 16.90, 0, "","","","");
        if (e.getSource() == btnc1)
        {
            OrderCoffee of = new OrderCoffee();
            of.setVisible(true);
        }
        else if (e.getSource() == btnc2)
        {
            OrderCoffee of = new OrderCoffee();
            of.setVisible(true);
        }
        else if (e.getSource() == btnc3)
        {
            OrderCoffee of = new OrderCoffee();
            of.setVisible(true);
        }
        else if (e.getSource() == btnc4)
        {
            OrderCoffee of = new OrderCoffee();
            of.setVisible(true);
        }
        else if (e.getSource() == btnc5)
        {
            OrderCoffee of = new OrderCoffee();
            of.setVisible(true);
        }

    }

    public static void main(String[]args)
    {

        Coffee cc = new Coffee(); //ambil dari class atas
        cc.setVisible(true);

    }
}

