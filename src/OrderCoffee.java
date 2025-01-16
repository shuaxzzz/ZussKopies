import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderCoffee extends JFrame implements ActionListener
{
    private JLabel label1,label2,label3,label4,label6,tittle;
    private JCheckBox cold;
    private JComboBox sugar1;
    private JRadioButton whipped1, whipped2;
    private JRadioButton coffee1, coffee2;
    private JTextField quantity;
    private Container contain;
    private java.util.ArrayList<CoffeeType> coffeetypes;
    private CoffeeType kopi; // Declare the CoffeeType object


    public OrderCoffee(CoffeeType kopi)
    {
        this.kopi = kopi;
        tittle = new JLabel("**=======<3=======**");
        tittle.setFont(new Font("Times New Roman", Font.BOLD, 30));

        setSize(700,500); //size kotak
        setLocation(300,100); //jarak dari hujung screen;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contain = getContentPane();
        contain.setBackground(new Color(173,200,220)); // tukar background color
        contain.setLayout(new FlowLayout());

        coffeetypes=new ArrayList<>();

        contain.add(tittle, BorderLayout.NORTH);

        //pilihankopi();
        sejuk();
        sugarlevel();
        whippedcream();
        CoffeeTypee();
        quant();

    }
    /*private void pilihankopi()
    {
        // Label for sugar level
        label5 = new JLabel("CHOOSE YOUR COFFEE");
        label5.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Panel with GridLayout for layout
        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, 10px gaps
        panel5.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel
        panel5.setBackground(new Color(40, 230, 220)); // Background color

        // Adding the panel to the container
        contain.add(panel5, BorderLayout.CENTER);

        // Sugar level options
        String[] cf = {"Americano", "Cappucino", "Vanilla Latte", "Mocha", "Caramel Latte"};
        coffeechoice = new JComboBox<>(cf); // Add generic type <String>
        coffeechoice.setSelectedIndex(0); // Set a valid index (0 to 2)

        // Add components to the panel
        panel5.add(label5);
        panel5.add(coffeechoice);
    }*/
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

        cold.addActionListener(this);
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

        sugar1.addActionListener(this);
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

        whipped1.addActionListener(this);
        whipped2.addActionListener(this);
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

        coffee1.addActionListener(this);
        coffee2.addActionListener(this);

        panel4.add(label4);
        panel4.add(coffee1);
        panel4.add(coffee2);
    }
    private void quant()
    {
        // Label for sugar level
        label6 = new JLabel("QUANTITY");
        label6.setFont(new Font("Times New Roman", Font.BOLD, 20));


        quantity = new JTextField();
        //quantity.setBackground(new Color(1,1,1));

        JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, 10px gaps
        panel7.setBorder(new EmptyBorder(10, 100, 10, 100)); // Padding around the panel
        panel7.setBackground(new Color(40, 230, 220));

        contain.add(panel7,BorderLayout.SOUTH);

        quantity.addActionListener(this);

        panel7.add(label6);
        panel7.add(quantity);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double total = 0;

        // Save whether coffee is cold or hot
        if (cold.isSelected()) {
            kopi.setCold("cold");
        } else {
            kopi.setCold("hot");
        }

        // Save sugar level
        String selectedOption = (String) sugar1.getSelectedItem();
        kopi.setSugar(selectedOption);

        // Save whipped cream preference
        if (whipped1.isSelected()) {
            selectedOption = "yes";
            kopi.setCream(selectedOption);
        } else if (whipped2.isSelected()) {
            selectedOption = "no";
            kopi.setCream(selectedOption);
        }

        // Save coffee type
        if (coffee1.isSelected()) {
            selectedOption = "boss";
            kopi.setTypecoffee(selectedOption);
        } else if (coffee2.isSelected()) {
            selectedOption = "lydia";
            kopi.setTypecoffee(selectedOption);
        }

        // Save quantity and check if it's a valid number
        String inputText = quantity.getText();
        if (inputText.matches("\\d+")) {  // Check if the input is a valid number
            int number = Integer.parseInt(inputText); // Convert to integer
            kopi.setQuantity(number);

            // Confirmation dialog to ensure data is saved
            JOptionPane.showMessageDialog(null, "All data saved successfully!");
            // Assuming kopi is an object of CoffeeType and calcTotal() returns a double
            total = kopi.calcTotal();

// Display the total in a message dialog
            JOptionPane.showMessageDialog(null, "The total is: $" + total);
            // Close the window
            ((JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource())).dispose();
        }
    }
}
