import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;

public class balenq extends JFrame implements ActionListener {
    JButton back;
    String pin;
    balenq(String Pin){
        this.pin = Pin;

        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ATM INTERFACE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/Images/atm.jpg"));
        Image scaled = i1.getImage().getScaledInstance(900,900, Image.SCALE_SMOOTH);
        ImageIcon screen = new ImageIcon(scaled);
        JLabel screen1 = new JLabel(screen);
        screen1.setBounds(0,0,900,900);
        add(screen1);
        //All buttons should be added on top of the image and not top of the frame
        JLabel text = new JLabel("Your available balance is:");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        screen1.add(text);
        int bal = 0;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pin+"';");
            while(rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")) {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel bal1 = new JLabel("Rs "+bal);
        bal1.setForeground(Color.white);
        bal1.setBounds(210,340,700,35);
        bal1.setFont(new Font("System", Font.BOLD, 20));
        screen1.add(bal1);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(355,520,150,30);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.addActionListener(this);
        screen1.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new balenq("");
    }
}
