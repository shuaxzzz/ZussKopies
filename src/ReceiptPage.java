import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ReceiptPage extends JFrame {

    private JTextArea receiptArea;
    private JButton closeButton;
    private ArrayList<String> selectedItems;
    private ArrayList<Double> itemPrices;

    public ReceiptPage(ArrayList<String> selectedItems, ArrayList<Double> itemPrices) {
        this.selectedItems = selectedItems;
        this.itemPrices = itemPrices;

        setTitle("Receipt");
        setSize(400, 500);
        setLocation(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(receiptArea);

        closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(closeButton, BorderLayout.SOUTH);

        add(contentPanel);

        generateReceipt();
    }

    private void generateReceipt() {
        StringBuilder receiptText = new StringBuilder();
        receiptText.append("============================\n");
        receiptText.append("        RECEIPT\n");
        receiptText.append("============================\n");

        double totalPrice = 0.0;

        for (int i = 0; i < selectedItems.size(); i++) {
            receiptText.append(selectedItems.get(i)).append(" - RM").append(String.format("%.2f", itemPrices.get(i))).append("\n");
            totalPrice += itemPrices.get(i);
        }

        receiptText.append("\n----------------------------\n");
        receiptText.append("Total Price: RM").append(String.format("%.2f", totalPrice)).append("\n");
        receiptText.append("============================\n");
        receiptText.append("Thank you for your order!\n");

        receiptArea.setText(receiptText.toString());
    }

    public static void main(String[] args) {

    }
}
