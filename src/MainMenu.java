import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame
{
    private JButton btnCalculate, btnReset;
    private JComboBox cbMenu;
    private JTextField txtQty;

    public MainMenu()
    {
        super.setTitle("THE WARM CUP BY ZUSS KOPIES <3");
        super.setSize(500,500);

        JFrame jf = new JFrame();

        //get content pane
        Container cp = super.getContentPane();
        cp.setBackground(Color.blue);

        JLabel lblMenu = new JLabel("Menu");
        cp.add(lblMenu);
        String[] menus = {"Americano","Latte","Spanish Latte"};
        JComboBox cbMenu = new JComboBox(new DefaultComboBoxModel(menus));
        cp.add(cbMenu);


        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);


    }
}
