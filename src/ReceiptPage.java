import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ReceiptPage extends JFrame {
    public ReceiptPage() {
        setTitle("Receipt");
        setSize(700, 625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout for the frame
        setLayout(new BorderLayout());

        // Create JTextArea to display the receipt
        JTextArea receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Use monospaced font for alignment
        receiptArea.setMargin(new Insets(10, 10, 10, 10)); // Add padding for better visuals
        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setPreferredSize(new Dimension(600, 525));

        double totalPrice = 0.0;
        StringBuilder receiptContent = new StringBuilder();

        // Add a formal header to the receipt
        receiptContent.append("==================================================================================\n");
        receiptContent.append("                                    ZUSS KOPIESS          \n");
        receiptContent.append("==================================================================================\n");
        receiptContent.append("Date: ").append(java.time.LocalDate.now()).append("\n");
        receiptContent.append("Time: ").append(java.time.LocalTime.now().withNano(0)).append("\n");
        receiptContent.append("==================================================================================\n\n");

        receiptContent.append("Items Purchased:\n");

        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("RM")) {
                    int priceIndex = line.lastIndexOf("RM");
                    String itemName = line.substring(0, priceIndex).trim();
                    String pricePart = line.substring(priceIndex).trim();

                    // Format item and price for proper alignment
                    receiptContent.append(String.format("%-70s %10s\n", itemName, pricePart));

                    double price = Double.parseDouble(pricePart.substring(2).trim()); // Extract numeric part
                    totalPrice += price;
                } else {
                    receiptContent.append(line).append("\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Add a line to separate items from the total
        receiptContent.append("\n=================================================================================\n");
        receiptContent.append(String.format("%-70s %10s\n", "Total Amount Due:", String.format("RM %.2f", totalPrice)));
        receiptContent.append("=================================================================================\n\n");
        receiptContent.append("Thank you for your purchase!\n");
        receiptContent.append("Please visit us again.\n");

        receiptArea.setText(receiptContent.toString());

        // Write the receipt to receipt.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt"))) {
            writer.write(receiptContent.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Add the scroll pane to the center
        add(scrollPane, BorderLayout.CENTER);

        // Create a close button and add it to the bottom
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setPreferredSize(new Dimension(100, 40));
        closeButton.addActionListener(e -> dispose()); // Close the window when the button is clicked

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton); // Center the button in the panel

        add(buttonPanel, BorderLayout.SOUTH); // Add the button panel to the bottom

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReceiptPage::new);
    }
}
