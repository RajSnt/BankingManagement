import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

public class fast extends JFrame implements ActionListener {
    JButton deposit, withdraw, fast, mini, pinchange, enq, exit;
    String pinnumber;
    fast(String Pin){
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
        JLabel text = new JLabel("SELECT AMOUNT TO WITHDRAW");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        screen1.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        screen1.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        screen1.add(withdraw);

        fast = new JButton("Rs 1000");
        fast.setBounds(170,450,150,30);
        fast.addActionListener(this);
        screen1.add(fast);

        mini = new JButton(" Rs 2000");
        mini.setBounds(355,450,150,30);
        mini.addActionListener(this);
        screen1.add(mini);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        screen1.add(pinchange);

        enq = new JButton("Rs 10000");
        enq.setBounds(355,485,150,30);
        enq.addActionListener(this);
        screen1.add(enq);

        exit = new JButton("Back");
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
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else {
            String amt = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pin+"';");
                int bal = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdraw")) {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=exit && bal<Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } else {
                    Date date = new Date();
                    String query = "insert into bank values ('" + pin + "','" + date + "','Withdraw','" + amt + "');";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amt + " Withdrawn successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static void main(String[] args) {
        new fast("");
    }
}
