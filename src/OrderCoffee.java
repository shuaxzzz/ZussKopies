import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OrderCoffee extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4, label6, label5, tittle;
    private JCheckBox cold;
    private JComboBox sugar1, coffeechoice;
    private JRadioButton whipped1, whipped2;
    private JRadioButton coffee1, coffee2;
    private JTextField quantity;
    private JButton addcart;
    private Container contain;
    private java.util.ArrayList<CoffeeType> coffeetypes;
    private CoffeeType kopi; // Declare the CoffeeType object
    private Image backgroundImage; // Background image
    private JTextArea receiptArea;


    public OrderCoffee(CoffeeType kopi) {
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\TheWarmMug\\src\\cat5.jpeg")); // Adjust the path
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the custom panel as the content pane
        OrderCoffee.BackgroundPanel backgroundPanel = new OrderCoffee.BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);
        this.kopi = kopi;
        tittle = new JLabel("**=======<3=======**");
        tittle.setFont(new Font("Times New Roman", Font.BOLD, 30));

        coffeetypes = new ArrayList<>();

        setSize(700, 500); //size kotak
        setLocation(300, 100); //jarak dari hujung screen;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contain = getContentPane();
        contain.setBackground(new Color(173, 200, 220)); // tukar background color
        contain.setLayout(new FlowLayout());

        coffeetypes = new ArrayList<>();

        contain.add(tittle, BorderLayout.NORTH);

        pilihankopi();
        sejuk();
        sugarlevel();
        whippedcream();
        CoffeeTypee();
        quant();
        button();
    }
    private void pilihankopi()
    {
        // Label for sugar level
        label5 = new JLabel("CHOOSE YOUR COFFEE");
        label5.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Panel with GridLayout for layout
        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, 10px gaps
        panel5.setBorder(new EmptyBorder(10, 200, 10, 200)); // Padding around the panel
        panel5.setBackground(new Color(210, 180, 140)); // Background color

        // Adding the panel to the container
        contain.add(panel5, BorderLayout.CENTER);

        // Sugar level options
        String[] cf = {"Americano", "Cappucino", "Vanilla Latte", "Mocha", "Caramel Latte"};
        coffeechoice = new JComboBox<>(cf); // Add generic type <String>
        coffeechoice.setSelectedIndex(0); // Set a valid index (0 to 2)

        // Add components to the panel
        panel5.add(label5);
        panel5.add(coffeechoice);
    }
    private void sejuk()
    {
        label1 = new JLabel("HOT OR COLD?");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 3,4 ));
        panel.setBorder(new EmptyBorder(1,200,3,200));
        panel.setBackground(new Color(210, 180, 140));

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
        panel2.setBorder(new EmptyBorder(10, 200, 10, 200)); // Padding around the panel
        panel2.setBackground(new Color(210, 180, 140)); // Background color

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
        panel3.setBorder(new EmptyBorder(10, 200, 10, 200)); // Padding around the panel
        panel3.setBackground(new Color(210, 180, 140)); // Background color

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
        panel4.setBorder(new EmptyBorder(10, 200, 10, 200)); // Padding around the panel
        panel4.setBackground(new Color(210, 180, 140)); // Background color

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
        panel7.setLayout(new GridLayout(1, 2, 100, 100)); // 1 row, 2 columns, 10px gaps
        panel7.setBorder(new EmptyBorder(10, 200, 10, 200)); // Padding around the panel
        panel7.setBackground(new Color(210, 180, 140));

        contain.add(panel7,BorderLayout.SOUTH);

        quantity.addActionListener(this);

        panel7.add(label6);
        panel7.add(quantity);

    }
    private void button()
    {
        addcart = new JButton("Add To Cart<3");
        addcart.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JPanel panell = new JPanel();

        panell.setLayout(new GridLayout(1,1,1,1));
        panell.setBorder(new EmptyBorder(1,1,1,1));

        contain.add(panell, BorderLayout.SOUTH);
        addcart.addActionListener(this);

        panell.add(addcart);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double total = 0;
        int totalcup = 0;
        String temp = "";
        //CountCoffee kira = new CountCoffee();
        // Save whether coffee is cold or hot
        String selectedOption1 = (String) coffeechoice.getSelectedItem();
        kopi.setCoffee(selectedOption1);

        if (cold.isSelected()) {
            kopi.setCold("cold");
            temp = "cold;";
        } else {
            kopi.setCold("hot");
            temp = "hot";
        }

        String[] temperature = {temp};

        // Save sugar level
        String selectedOption = (String) sugar1.getSelectedItem();
        kopi.setSugar(selectedOption);

        // Save whipped cream preference
        String whip = "";
        if (whipped1.isSelected()) {
            selectedOption = "yes";
            whip = "yes";
            kopi.setCream(selectedOption);
        } else if (whipped2.isSelected()) {
            selectedOption = "no";
            whip = "no";
            kopi.setCream(selectedOption);
        }

        String[] whipped = {whip};


        // Save coffee type
        String rasa = "";
        if (coffee1.isSelected()) {
            selectedOption = "boss";
            rasa = "boss";
            kopi.setTypecoffee(selectedOption);
        } else if (coffee2.isSelected()) {
            selectedOption = "lydia";
            rasa = "lydia";
            kopi.setTypecoffee(selectedOption);
        }

        String[] taste = {rasa};

        // Save quantity and check if it's a valid number
        String inputText = quantity.getText();
        if (inputText.matches("\\d+")) {  // Check if the input is a valid number
            int number = Integer.parseInt(inputText); // Convert to integer
            totalcup = number;
            kopi.setQuantity(number);
            // Assuming kopi is an object of CoffeeType and calcTotal() returns a double
            total = kopi.calcTotal();

// Display the total in a message dialog
            JOptionPane.showMessageDialog(null, "The total is: RM" + total);
            // Close the window
            ((JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource())).dispose();
        }
        coffeetypes.add(new CoffeeType(selectedOption1,totalcup,temp,rasa,whip,selectedOption ));
        if (e.getSource() == addcart)
        {
            // Confirmation dialog to ensure data is saved
            JOptionPane.showMessageDialog(null, "ADDED TO CART");

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
        CoffeeType cc = new CoffeeType();
        OrderCoffee oc = new OrderCoffee(cc);
        oc.setVisible(true);

        System.out.println(cc.getCoffee());
    }
}
