import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReceiptPage extends JFrame {
    public ReceiptPage() {
        setTitle("Receipt");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);

        double totalPrice = 0.0;
        StringBuilder receiptContent = new StringBuilder("Receipt:\n\n");

        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                receiptContent.append(line).append("\n");
                if (line.contains("RM")) {
                    String pricePart = line.substring(line.lastIndexOf("RM") + 2).trim();
                    totalPrice += Double.parseDouble(pricePart);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        receiptContent.append("\nTotal: RM ").append(String.format("%.2f", totalPrice));
        receiptArea.setText(receiptContent.toString());

        add(scrollPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReceiptPage::new);
    }
}
