import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;

public class minis extends JFrame implements ActionListener {
    String pin;
    minis(String Pin){
        this.pin = Pin;


        setTitle("Mini-Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel stat = new JLabel();
        stat.setBounds(20,140,400,380);
        add(stat);

        JLabel name = new JLabel("Bank of Raj");
        name.setBounds(150,50,100,30);
        name.setFont(new Font("System", Font.BOLD, 15));
        name.setForeground(Color.BLACK);
        add(name);

        JLabel card = new JLabel();
        card.setBounds(20,105,300,20);
        add(card);
        try{
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from login where pinnumber = '"+pin+"';");
            while(rs1.next()){
                card.setText("Card Number: "+ rs1.getString("cardnumber").substring(0,4) + "-XXXX-XXXX-" + rs1.getString("cardnumber").substring(12,16));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try{
            Conn c = new Conn();
            ResultSet rs2 = c.s.executeQuery("select * from bank where pin = '"+pin+"';");
            while(rs2.next()){
                stat.setText(stat.getText() + "<html>" + rs2.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs2.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs2.getString("amount") + "<br><br><html>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel balance = new JLabel("");
        balance.setBounds(20,490, 300, 30);
        add(balance);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pin+"';");
            int bal = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")) {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("You available balance is Rs. "+bal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){

    }
    public static void main(String[] args) {
        new minis("");
    }
}
