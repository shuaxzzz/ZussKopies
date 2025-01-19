import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Food extends JFrame {
    private JPanel foodLayout; //layout for food
    private JLabel header; //header
    private JScrollPane scrollFood;//scroll layout
    private JTextArea receiptArea;
    private double totalPrice = 0.0;
    private ArrayList<String> receiptItems = new ArrayList<>();//List of food


    public Food(String username) {
        super.setTitle("Welcome to Food Section,Zussies !");
        super.setSize(700, 650);


        //header for food setup
        header.setText("˚ʚ The Warm Mug by Zuss Kopiess ɞ˚");

        //shopping cart
        createFoodItems();

        Container cp = super.getContentPane();
        cp.add(foodLayout);

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void createFoodItems(){
        JPanel foodPanel=new JPanel(new GridLayout(2,3,10,10)); //2*3 layout for food
        foodPanel.setBackground(Color.GRAY);
        String[] foodNames = {"Ayam Masak Merah With Rice", "Chicken Lasagna", "Korean Mac & Cheese", "Mee Hoon Goreng Siam", "Biscoff Baked Cheese Cake", "Burnt Cheese Cake","Kampung Fried Rice","Pak Naseer's Nasi Lemak Ayam Rendang"}; //food name
        double[] foodPrices = {12.90, 13.90, 12.90, 7.90, 13.50, 13.50,11.90,12,90}; //food price
        String[] foodImages = {"C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Ayam Masak Merah With Rice.jpg", "C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Chicken Lasagna.jpg", "C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Korean Mac & Cheese.jpg", "C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Mee Hoon Goreng Siam.jpg", "C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Biscoff Baked Cheese Cake.jpg", "C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Burnt Cheese Cake.jpg","C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Kampung Fried Rice.jpg","C:\\Users\\NUR FATEHA\\IdeaProjects\\TheWarmMug\\src\\Pak Naseer's Nasi Lemak Ayam Rendang.jpg"};

        for (int i = 0; i < foodNames.length; i++) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS)); //vertical layout for each food

            ImageIcon foodIcon = new ImageIcon(foodImages[i]);
            Image foodImage = foodIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Resize image to fit the box
            JLabel foodImageLabel = new JLabel(new ImageIcon(foodImage));
            foodImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel foodName = new JLabel(foodNames[i], SwingConstants.CENTER); // Food name
            foodName.setFont(new Font("Monospaced", Font.PLAIN, 20));
            foodName.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel foodPrice = new JLabel("RM" + foodPrices[i], SwingConstants.CENTER); // Food price
            foodPrice.setFont(new Font("Monospaced", Font.PLAIN, 15));
            foodPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton addButton = new JButton("Add to Cart :)"); // "Add to Cart" button
            addButton.setFont(new Font("Tahoma", Font.BOLD, 14));
            addButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button

            int index = i; // Capture the index for use in the ActionListener
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addToCart(foodNames[index], foodPrices[index]);
                }
            });

            // Add components to item panel
            itemPanel.add(foodImageLabel);
            itemPanel.add(foodName);
            itemPanel.add(foodPrice);
            itemPanel.add(addButton);

            // Add item panel to the food panel
            foodPanel.add(itemPanel);
        }

        // Make the food panel scrollable
        scrollFood = new JScrollPane(foodPanel);
        scrollFood.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Enable horizontal scrolling
        foodLayout.add(scrollFood, BorderLayout.CENTER);

        // Receipt area (bottom part)
        JPanel receiptPanel = new JPanel(new BorderLayout());
        receiptArea = new JTextArea(10, 30);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        JScrollPane scrollReceipt = new JScrollPane(receiptArea); // Make receipt scrollable
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Verdana", Font.BOLD, 16));
        checkoutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showReceipt();
                ((JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource())).dispose();
            }

        });

        // Add components to the receipt panel
        receiptPanel.add(scrollReceipt, BorderLayout.CENTER);
        receiptPanel.add(checkoutButton, BorderLayout.SOUTH);

        // Add receipt panel to the main layout
        foodLayout.add(receiptPanel, BorderLayout.SOUTH);
    }

    // Add item to cart and update the receipt
    private void addToCart(String foodName, double foodPrice) {
        receiptItems.add(foodName + " - RM " + foodPrice);
        totalPrice += foodPrice;
        receiptArea.setText("Items in Cart:\n" + String.join("\n", receiptItems) + "\n\nTotal: RM " + String.format("%.2f", totalPrice));

        // Write to file
        try (FileWriter writer = new FileWriter("orders.txt", true)) {
            writer.write(foodName + " - RM " + foodPrice + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    // Show receipt in a popup dialog
    private void showReceipt() {
        JOptionPane.showMessageDialog(null, "Receipt:\n" + String.join("\n", receiptItems) + "\n\nTotal: RM " + String.format("%.2f", totalPrice),
                "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Replace "username" with the actual username you want to use
        SwingUtilities.invokeLater(() -> {
            new Food("User"); // Initialize with a username
        });

    }

    }


