import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderCoffee extends JFrame implements ActionListener
{
    private JLabel label1,label2,label3,label4,tittle;
    private JCheckBox cold;
    private JComboBox sugar1;
    private JRadioButton whipped1, whipped2;
    private JRadioButton coffee1, coffee2;
    private Container contain;

    public OrderCoffee()
    {
        tittle = new JLabel("**=======<3=======**");
        tittle.setFont(new Font("Times New Roman", Font.BOLD, 30));

        setSize(700,500); //size kotak
        setLocation(300,100); //jarak dari hujung screen;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contain = getContentPane();
        contain.setBackground(new Color(173,200,220)); // tukar background color
        contain.setLayout(new FlowLayout());

        contain.add(tittle, BorderLayout.NORTH);

        sejuk();
        sugarlevel();
        whippedcream();
        CoffeeTypee();

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
    private void sugarlevel()
    {
        // Label for sugar level
        label2 = new JLabel("SUGAR LEVEL?");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Panel with GridLayout for layout
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, 10px gaps
        panel2.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel
        panel2.setBackground(new Color(40, 230, 220)); // Background color

        // Adding the panel to the container
        contain.add(panel2, BorderLayout.CENTER);

        // Sugar level options
        String[] sugar = {"No Sugar", "Low Sugar", "Normal"};
        sugar1 = new JComboBox<>(sugar); // Add generic type <String>
        sugar1.setSelectedIndex(0); // Set a valid index (0 to 2)

        // Add components to the panel
        panel2.add(label2);
        panel2.add(sugar1);
    }

    private void whippedcream()
    {

        // Label for sugar level
        label3 = new JLabel("WHIPPED CREAM?");
        label3.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Panel with GridLayout for layout
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, 10px gaps
        panel3.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel
        panel3.setBackground(new Color(40, 230, 220)); // Background color

        // Adding the panel to the container
        contain.add(panel3, BorderLayout.CENTER);

        whipped1 = new JRadioButton("Yes");
        whipped2 = new JRadioButton("No");
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(whipped1);
        group.add(whipped2);

        panel3.add(label3);
        panel3.add(whipped1);
        panel3.add(whipped2);
    }

    private void CoffeeTypee()
    {


        // Label for sugar level
        label4 = new JLabel("COFFEE TYPE?");
        label4.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Panel with GridLayout for layout
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, 10px gaps
        panel4.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel
        panel4.setBackground(new Color(40, 230, 220)); // Background color

        // Adding the panel to the container
        contain.add(panel4, BorderLayout.CENTER);


        coffee1 = new JRadioButton("Boss");
        coffee2 = new JRadioButton("Lydia");
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(coffee1);
        group.add(coffee2);

        panel4.add(label4);
        panel4.add(coffee1);
        panel4.add(coffee2);
    }
    public void actionPerformed(ActionEvent e)
    {
        CoffeeType[] kopi = new CoffeeType[5];
        kopi[0] = new CoffeeType("Americano",  0, "","","","");
        kopi[1] = new CoffeeType("Cappucino",  0, "","","","");
        kopi[2] = new CoffeeType("Vanilla",  0, "","","","");
        kopi[3] = new CoffeeType("Mocha",  0, "","","","");
        kopi[4] = new CoffeeType("Caramel",  0, "","","","");

        if(cold.isSelected() )
        {
            if(kopi[0].getCoffee() == "Americano")
            {

            }
        }
    }

    public static void main(String[]args)
    {
        OrderCoffee cd = new OrderCoffee();
        cd.setVisible(true);
    }
}
