import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coffee extends JFrame implements ActionListener
{   //fungsi ActionListener tu supaya sebarang action dibuat, akan masuk kat class bawah (boleh calculate etc)
    private JLabel title,lblc1, lblc2, lblc3, lblc4, lblc5;
    private JButton btnc1, btnc2, btnc3, btnc4, btnc5;
    private JLabel img1, img2, img3, img4, img5;
    private Container contain;

    public Coffee()
    {
        //yang ni boleh declare super, x perlu pon x pe
        setTitle("THE WARM CUP BY ZUSS KOPIES <3"); //Tajuk besar
        setSize(400,400); //size kotak
        setLocation(500,200); //jarak dari hujung screen;
        setDefaultCloseOperation(EXIT_ON_CLOSE); //supaya tekan pangkah, terus tutup


        contain = getContentPane(); //declare dari class J yang tersedia, untuk isi apa ii dalam pane
        contain.setBackground(new Color(173,216,230)); // tukar background color
        contain.setLayout(new FlowLayout());

        JLabel mainText = new JLabel("THE WARM CUP BY ZUSS KOPIES <3");
        contain.add(mainText);
    }

    private void north()
    {

    }
    private void centre()
    {

    }
    private void south()
    {

    }
    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String[]args)
    {
        Coffee cc = new Coffee(); //ambil dari class atas
        cc.setVisible(true);


    }
}
