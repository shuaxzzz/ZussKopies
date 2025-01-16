import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderCoffee extends JFrame
{
    private JLabel label1,label2,label3,tittle;
    private JCheckBox cold,hot;
    private JRadioButton sugar1,sugar2,sugar3;
    private JRadioButton whipped1, whipped2;
    private JList coffee1, coffee2;
    private Container contain;

    public OrderCoffee()
    {
        tittle = new JLabel("**=======<3=======**");
        tittle.setFont(new Font("Times New Roman", Font.BOLD, 30));

        setSize(500,600); //size kotak
        setLocation(300,100); //jarak dari hujung screen;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contain = getContentPane();
        contain.setBackground(new Color(173,200,220)); // tukar background color
        contain.setLayout(new FlowLayout());

        contain.add(tittle, BorderLayout.NORTH);

        sejuk();

    }
    private void sejuk()
    {
        label1 = new JLabel("HOT OR COLD?");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 3,4 ));
        panel.setBorder(new EmptyBorder(1,2,3,4));
        panel.setBackground(new Color(40,230,220));

        contain.add(panel,BorderLayout.CENTER);

        cold = new JCheckBox("COLD?(If yes, Click on the box)");

        panel.add(label1);
        panel.add(cold);
    }

    public static void main(String[]args)
    {
        OrderCoffee cd = new OrderCoffee();
        cd.setVisible(true);
    }
}
