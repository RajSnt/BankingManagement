import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class deposit extends JFrame implements ActionListener {
    JButton deposit, back;
    JTextField amt;
    String pinnumber;
    deposit(String Pin){
        this.pinnumber = Pin;
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/Images/atm.jpg"));
        Image scaled = i1.getImage().getScaledInstance(900,900, Image.SCALE_SMOOTH);
        ImageIcon screen = new ImageIcon(scaled);
        JLabel screen1 = new JLabel(screen);
        screen1.setBounds(0,0,900,900);
        add(screen1);

        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setBounds(170,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        screen1.add(text);

        amt = new JTextField();
        amt.setFont(new Font("Raleway", Font.BOLD, 22));
        amt.setBounds(170,345,330,35);
        screen1.add(amt);

        deposit = new JButton("Deposit");
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(355,485,150,30);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        deposit.addActionListener(this);
        screen1.add(deposit);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(355,520,150,30);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.addActionListener(this);
        screen1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String pin = pinnumber;
        if(e.getSource() == deposit){
            String amount = amt.getText();
            //Make an object of Date class to get date
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"');";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" deposited successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        } else if (e.getSource()== back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new deposit("");
    }
}
