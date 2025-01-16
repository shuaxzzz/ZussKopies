import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Food extends JFrame {
    public Food() {
        // Parent panel for layout management
        JPanel parentLayout = new JPanel(new BorderLayout());
        parentLayout.setBackground(Color.WHITE); // Set background color for the parent layout

        // Header panel to combine the logo and message
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding
        headerPanel.setBackground(new Color(174,198,207)); // Set background color for header panel

        // Add message
        JLabel lblMessage = new JLabel("˚ʚ The Warm Mug by Zuss Kopiess ɞ˚ ", SwingConstants.CENTER);
        lblMessage.setFont(new Font("Courier New", Font.BOLD, 22));
        lblMessage.setForeground(Color.WHITE); // Text color for header message

        // Add Zuss logo
        ImageIcon zusLogo = new ImageIcon(Food.class.getResource("/images.png"));
        Image scaledImage = zusLogo.getImage().getScaledInstance(70, 50, Image.SCALE_SMOOTH);
        zusLogo = new ImageIcon(scaledImage);

        JLabel lblLogo = new JLabel(zusLogo);
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);

        // Add components to the header panel
        headerPanel.add(lblLogo, BorderLayout.WEST); // Logo on the left
        headerPanel.add(lblMessage, BorderLayout.CENTER); // Message in the center

        // Add the header panel to the parent layout
        parentLayout.add(headerPanel, BorderLayout.NORTH);

        // Grid layout for food items (image + name + radio button)
        JPanel foodGrid = new JPanel(new GridLayout(2, 3, 10, 10));
        foodGrid.setBackground(Color.LIGHT_GRAY); // Set background color for the grid panel

        // Button group for the radio buttons
        ButtonGroup foodGroup = new ButtonGroup();

        // Add food images and names with radio buttons to the grid
        addFoodItemToPanel(foodGrid, foodGroup, "/Burnt Cheese Cake.jpg", "Burnt Cheese Cake");
        addFoodItemToPanel(foodGrid, foodGroup, "/Biscoff Baked Cheese Cake.jpg", "Biscoff Baked Cheese Cake");
        addFoodItemToPanel(foodGrid, foodGroup, "/Chicken Lasagna.jpg", "Chicken Lasagna");
        addFoodItemToPanel(foodGrid, foodGroup, "/Korean Mac & Cheese.jpg", "Korean Mac & Cheese");
        addFoodItemToPanel(foodGrid, foodGroup, "/Mee Hoon Goreng Siam.jpg", "Mee Hoon Goreng Siam");
        addFoodItemToPanel(foodGrid, foodGroup, "/Ayam Masak Merah With Rice.jpg", "Ayam Masak Merah With Rice");

        // Add the food grid panel to the parent layout
        parentLayout.add(foodGrid, BorderLayout.CENTER);

        // Set JFrame properties
        setContentPane(parentLayout);
        setTitle("Welcome to the Food Section, Zussies");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Set background color for the JFrame content pane
        getContentPane().setBackground(Color.WHITE); // Set the background color of the frame's content pane
    }

    // Method to add an image and corresponding radio button for each food item
    private void addFoodItemToPanel(JPanel panel, ButtonGroup group, String imagePath, String foodName) {
        JPanel foodItemPanel = new JPanel();
        foodItemPanel.setLayout(new BoxLayout(foodItemPanel, BoxLayout.Y_AXIS));  // Use BoxLayout to stack components vertically
        foodItemPanel.setBackground(Color.WHITE); // Set background color for each food item panel

        // Load and scale the image
        ImageIcon icon = new ImageIcon(Food.class.getResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        // Add the image to a label
        JLabel lblImage = new JLabel(icon);
        lblImage.setAlignmentX(Component.CENTER_ALIGNMENT); // Align the image to the center

        // Create a radio button for the food item
        JRadioButton foodButton = new JRadioButton(foodName);

        // Set the font for the JRadioButton (family, style, size)
        foodButton.setFont(new Font("Arial", Font.BOLD, 13)); // You can change the font here

        // Set the background of the radio button and make it opaque

        foodButton.setOpaque(true); // Make sure the background is visible
        foodButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align the radio button to the center

        // Add the radio button to the button group
        group.add(foodButton);

        // Add the image and radio button to the food item panel
        foodItemPanel.add(lblImage);
        foodItemPanel.add(foodButton);

        // Add the food item panel to the main panel
        panel.add(foodItemPanel);
    }

    public static void main(String[] args) {
        new Food();
    }
}
