import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener{
    JPasswordField pinc1,pinc2;
    JButton change,back;
    String pinno;
    pinchange(String pin){
        this.pinno = pin;
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
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(260,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        screen1.add(text);

        JLabel pin1 = new JLabel("Enter new PIN: ");
        pin1.setBounds(170,350,300,35);
        pin1.setFont(new Font("System", Font.BOLD, 16));
        pin1.setForeground(Color.white);
        screen1.add(pin1);
        pinc1 = new JPasswordField();
        pinc1.setBounds(320,350,150,32);
        pinc1.setFont(new Font("System", Font.BOLD, 16));
        pinc1.setForeground(Color.BLACK);
        screen1.add(pinc1);

        JLabel pin2 = new JLabel("Re-enter new PIN: ");
        pin2.setBounds(170,390,700,35);
        pin2.setFont(new Font("System", Font.BOLD, 16));
        pin2.setForeground(Color.white);
        screen1.add(pin2);
        pinc2 = new JPasswordField();
        pinc2.setBounds(320,390,150,32);
        pinc2.setFont(new Font("System", Font.BOLD, 16));
        pinc2.setForeground(Color.BLACK);
        screen1.add(pinc2);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        screen1.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        screen1.add(back);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String pin = pinno;
        if(e.getSource() == change){
            try{
                String npin = pinc1.getText();
                String rpin = pinc2.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                }
                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"';";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pin+"';";
                String query3 = "update userinfo3 set pinnumber = '"+rpin+"' where pinnumber = '"+pin+"';";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN Changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if(e.getSource()==back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinchange("");
    }
}
