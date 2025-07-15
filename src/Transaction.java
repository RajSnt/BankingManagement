import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit, withdraw, fast, mini, pinchange, enq, exit;
    String pinnumber;
    Transaction(String Pin){
        this.pinnumber = Pin;

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
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        screen1.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        screen1.add(deposit);

        withdraw = new JButton(" Cash Withdrawl");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        screen1.add(withdraw);

        fast = new JButton("Fast Cash");
        fast.setBounds(170,450,150,30);
        fast.addActionListener(this);
        screen1.add(fast);

        mini = new JButton("Mini-Statement");
        mini.setBounds(355,450,150,30);
        mini.addActionListener(this);
        screen1.add(mini);

        pinchange = new JButton("Change PIN");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        screen1.add(pinchange);

        enq = new JButton(" Balance Enquiry");
        enq.setBounds(355,485,150,30);
        enq.addActionListener(this);
        screen1.add(enq);

        exit = new JButton("Exit");
        exit.setBounds(170,520,150,30);
        exit.addActionListener(this);
        screen1.add(exit);
        //To remove the white part that comes at top
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String pin = pinnumber;
        if(e.getSource()==exit){
            System.exit(0);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new deposit(pin).setVisible(true);
        } else if (e.getSource()==withdraw) {
            setVisible(false);
            new withdraw(pin).setVisible(true);
        } else if (e.getSource()==fast){
            setVisible(false);
            new fast(pin).setVisible(true);
        } else if (e.getSource()==pinchange) {
            setVisible(false);
            new pinchange(pin).setVisible(true);
        } else if(e.getSource()==enq){
            setVisible(false);
            new balenq(pin).setVisible(true);
        } else if (e.getSource()==mini) {
            new minis(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
