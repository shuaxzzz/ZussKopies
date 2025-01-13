import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZussCoffee extends JFrame{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Zuss Coffee Ordering System");

        // Set frame size and behavior
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create components
        JLabel nameLabel = new JLabel("Enter your name: ");
        JTextField nameField = new JTextField(20);

        JLabel coffeeLabel = new JLabel("Select your coffee: ");
        String[] coffeeOptions = {"Espresso - $2.50", "Latte - $3.50", "Cappuccino - $4.00",
                "Americano - $3.00", "Mocha - $4.50"};
        JComboBox<String> coffeeComboBox = new JComboBox<>(coffeeOptions);

        JLabel quantityLabel = new JLabel("Enter quantity: ");
        JTextField quantityField = new JTextField(5);

        JButton orderButton = new JButton("Place Order");

        JTextArea orderSummaryArea = new JTextArea(6, 30);
        orderSummaryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderSummaryArea);

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(coffeeLabel);
        frame.add(coffeeComboBox);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(orderButton);
        frame.add(scrollPane);

        // Action listener for the order button
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String coffeeChoice = (String) coffeeComboBox.getSelectedItem();
                String quantityText = quantityField.getText();

                if (name.isEmpty() || quantityText.isEmpty() || !quantityText.matches("\\d+")) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields correctly.");
                    return;
                }

                int quantity = Integer.parseInt(quantityText);
                double price = 0.0;
                String coffeeType = "";

                // Determine the coffee type and price based on the selection
                if (coffeeChoice.contains("Espresso")) {
                    coffeeType = "Espresso";
                    price = 2.50;
                } else if (coffeeChoice.contains("Latte")) {
                    coffeeType = "Latte";
                    price = 3.50;
                } else if (coffeeChoice.contains("Cappuccino")) {
                    coffeeType = "Cappuccino";
                    price = 4.00;
                } else if (coffeeChoice.contains("Americano")) {
                    coffeeType = "Americano";
                    price = 3.00;
                } else if (coffeeChoice.contains("Mocha")) {
                    coffeeType = "Mocha";
                    price = 4.50;
                }

                double totalCost = price * quantity;

                // Display the order summary in the text area
                String orderSummary = "Customer: " + name + "\n" +
                        "Coffee: " + coffeeType + "\n" +
                        "Quantity: " + quantity + "\n" +
                        "Total Cost: $" + totalCost;

                orderSummaryArea.setText(orderSummary);
            }
        });

        // Set frame visible
        frame.setVisible(true);
    }
}

