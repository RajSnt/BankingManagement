import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton Sav, Curr, FD, RD;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String form;
    SignUpThree(String Form){
        this.form = Form;

        setSize(800, 850);
        setLocation(375, 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Bank Account info");
        setLayout(null);

        JLabel Title = new JLabel("Page 3: Account Information");
        Title.setBounds(150, 50, 600, 100);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        add(Title);

        JLabel Form3 = new JLabel("Form No. "+form);
        Form3.setBounds(600, 50, 100,20);
        Form3.setFont(new Font("Times New Roman", Font.BOLD, 10));
        add(Form3);

        JLabel Acc = new JLabel("Account Type:" );
        Acc.setBounds(100, 170, 200, 50);
        Acc.setFont(new Font("Raleway", Font.BOLD, 25));
        add(Acc);

        Sav = new JRadioButton("Savings Account");
        Sav.setBackground(Color.white);
        Sav.setBounds(100, 230, 200, 30);
        Sav.setFont(new Font("Raleway",Font.PLAIN, 17));
        add(Sav);

        Curr = new JRadioButton("Current Account");
        Curr.setBackground(Color.white);
        Curr.setBounds(100, 270, 200, 30);
        Curr.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(Curr);

        FD = new JRadioButton("Fixed Deposit Account");
        FD.setBackground(Color.white);
        FD.setBounds(350, 230, 200, 30);
        FD.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(FD);

        RD = new JRadioButton("Recurring Deposit Account");
        RD.setBackground(Color.white);
        RD.setBounds(350, 270, 250, 30);
        RD.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(RD);

        ButtonGroup accounts = new ButtonGroup();
        accounts.add(Sav);
        accounts.add(Curr);
        accounts.add(FD);
        accounts.add(RD);

        JLabel card = new JLabel("Card Number:" );
        card.setBounds(100, 320, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 25));
        add(card);
        JLabel refcard = new JLabel("XXXX-XXXX-XXXX-9876" );
        refcard.setBounds(300, 320, 300, 30);
        refcard.setFont(new Font("Raleway", Font.BOLD, 25));
        add(refcard);
        JLabel info1 = new JLabel("(Your 16 digit card number)");
        info1.setBounds(100, 355, 200, 15 );
        info1.setFont(new Font("Times New Roman", Font.PLAIN,14));
        add(info1);

        JLabel pin = new JLabel("Pin:" );
        pin.setBounds(100, 380, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        add(pin);
        JLabel refpin = new JLabel("XXXX" );
        refpin.setBounds(300, 380, 300, 30);
        refpin.setFont(new Font("Raleway", Font.BOLD, 25));
        add(refpin);
        JLabel info2 = new JLabel("(Your 4 digit pin)");
        info2.setBounds(100, 415, 200, 15 );
        info2.setFont(new Font("Times New Roman", Font.PLAIN,14));
        add(info2);

        JLabel services = new JLabel("Services required:" );
        services.setBounds(100, 450, 250, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 25));
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setBounds(100, 490, 200, 20);
        c1.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(320, 490, 200, 20);
        c2.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100, 520, 200, 20);
        c3.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(c3);
        c4 = new JCheckBox("E-mail and SMS alerts");
        c4.setBackground(Color.white);
        c4.setBounds(320, 520, 200, 20);
        c4.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(c4);
        c5 = new JCheckBox("Chequebook");
        c5.setBackground(Color.white);
        c5.setBounds(100, 550, 200, 20);
        c5.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(c5);
        c6 = new JCheckBox("E-statement");
        c6.setBackground(Color.white);
        c6.setBounds(320, 550, 200, 20);
        c6.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(c6);

        c7 = new JCheckBox("*I hereby declare that the above entered details are correct to my best knowledge");
        c7.setBackground(Color.white);
        c7.setBounds(100, 610, 500, 20);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        submit.setBounds(250, 690, 100, 35);
        add(submit);
        submit.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cancel.setBounds(450, 690, 100, 35);
        add(cancel);
        cancel.addActionListener(this);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            String account = null;
            if(Sav.isSelected()){
                account = "Savings Account";
            } else if (Curr.isSelected()) {
                account = "Current Account";
            } else if(FD.isSelected()){
                account = "Fixed Deposit Account";
            } else if(RD.isSelected()){
                account = "Recurring Deposit Account";
            }

            Random ran = new Random();
            String cardno = ""+(7531951300000000L + ran.nextLong(90000000));
            String pinno = ""+(1000 + ran.nextInt(9000));

            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            } else if(c2.isSelected()){
                facility = facility + "Internet Banking";
            } else if(c3.isSelected()){
                facility = facility + "Mobile Banking";
            }  else if(c4.isSelected()){
                facility = facility + "E-mail and SMS alerts";
            }  else if(c5.isSelected()){
                facility = facility + "Chequebook";
            }  else if(c6.isSelected()){
                facility = facility + "E-statement";
            }

            String FormNo = form;

            try{
                if(account == null){
                    JOptionPane.showMessageDialog(null, "Account type is a required field");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into userinfo3(FormNo, account, cardnumber, pinnumber, facility) " +
                            "values ('"+FormNo+"','"+account+"','"+cardno+"','"+pinno+"','"+facility+"');";
                    conn.s.executeUpdate(query1);
                    String query2 = "insert into login(FormNo, cardnumber, pinnumber) " +
                            "values ('"+FormNo+"','"+cardno+"','"+pinno+"');";
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number : "+cardno+"\n Pin :"+pinno);

                    setVisible(false);
                    new deposit(pinno).setVisible(true);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
