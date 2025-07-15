import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
    JTextField nameText, fnameText, emailText, addressText, cityText, stateText, pincodeText;
    JRadioButton male, female, married, unmarried, others;
    JDateChooser dobChoose;
    JButton next;
    Random gen = new Random();
    int FormNo = 1000 + gen.nextInt(9000);
    SignUpOne(){

        System.out.println(FormNo);
        setSize(800, 850);
        setLocation(375, 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Additional customer details");
        setLayout(null);

        JLabel Title = new JLabel("Application Form Number ."+FormNo);
        Title.setBounds(100, 50, 600, 100);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        add(Title);

        JLabel SubTitle = new JLabel("Page 1: Personal Details");
        SubTitle.setBounds(220, 170, 600, 50);
        SubTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(SubTitle);

        JLabel name = new JLabel("Name:");
        name.setBounds(110, 240, 100, 30);
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(name);
        nameText = new JTextField();
        nameText.setBounds(370, 240, 300, 30);
        nameText.setFont(new Font("Railway", Font.BOLD, 15));
        add(nameText);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(110, 290, 200, 30);
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(fname);
        fnameText = new JTextField();
        fnameText.setBounds(370, 290, 300, 30);
        fnameText.setFont(new Font("Railway", Font.BOLD, 15));
        add(fnameText);

        JLabel dob = new JLabel("Date of birth:");
        dob.setBounds(110, 340, 250, 30);
        dob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(dob);
        dobChoose = new JDateChooser();
        dobChoose.setBounds(370, 340, 300, 30);
        add(dobChoose);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(110, 390, 100, 30);
        gender.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(370, 390, 100, 30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(490, 390, 100, 30);
        female.setBackground(Color.white);
        add(female);
        //This is done so that no two options can be selected together if only 1 is allowed
        ButtonGroup genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);


        JLabel email = new JLabel("Email:");
        email.setBounds(110, 440, 100, 30);
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(email);
        emailText = new JTextField();
        emailText.setBounds(370, 440, 300, 30);
        emailText.setFont(new Font("Railway", Font.BOLD, 15));
        add(emailText);

        JLabel marriage = new JLabel("Marital status:");
        marriage.setBounds(110, 490, 150, 30);
        marriage.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(marriage);
        married = new JRadioButton("Married");
        married.setBounds(370, 490, 100, 30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(490, 490, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        others = new JRadioButton("Others");
        others.setBounds(610, 490, 100, 30);
        others.setBackground(Color.white);
        add(others);
        //This is done so that no two options can be selected together if only 1 is allowed
        ButtonGroup marstat = new ButtonGroup();
        marstat.add(married);
        marstat.add(unmarried);
        marstat.add(others);

        JLabel address = new JLabel("Residential Address:");
        address.setBounds(110, 540, 190, 30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);
        addressText = new JTextField();
        addressText.setBounds(370, 540, 300, 30);
        addressText.setFont(new Font("Railway", Font.BOLD, 15));
        add(addressText);

        JLabel city = new JLabel("City:");
        city.setBounds(110, 590, 100, 30);
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(city);
        cityText = new JTextField();
        cityText.setBounds(370, 590, 300, 30);
        cityText.setFont(new Font("Railway", Font.BOLD, 15));
        add(cityText);

        JLabel state = new JLabel("State:");
        state.setBounds(110, 640, 100, 30);
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(state);
        stateText = new JTextField();
        stateText.setBounds(370, 640, 300, 30);
        stateText.setFont(new Font("Railway", Font.BOLD, 15));
        add(stateText);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setBounds(110, 690, 100, 30);
        pincode.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(pincode);
        pincodeText = new JTextField();
        pincodeText.setBounds(370, 690, 300, 30);
        pincodeText.setFont(new Font("Railway", Font.BOLD, 15));
        add(pincodeText);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Arial", Font.BOLD, 20));
        next.setBounds(570, 740, 100, 30);
        next.addActionListener(this);
        add(next);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        //Database will take values in the form of string
        String Form = "" + FormNo;
        //getText() brings any value entered inside the textfield in the form
        String name = nameText.getText();
        String fname = fnameText.getText();
        //getText() func works only on textfields so first from date chooser extract everything then convert to textfield
        String dob = ((JTextField)dobChoose.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailText.getText();
        String marriage = null;
        if(married.isSelected()){
            marriage = "Married";
        } else if (unmarried.isSelected()) {
            marriage = "Unmarried";
        } else if (others.isSelected()) {
            marriage = "Others";
        }

        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pincode = pincodeText.getText();

        try{
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Entering name is mandatory");
            }
            else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Entering father's name is mandatory");
            }
            else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Entering Date of birth is mandatory");
            }
            else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Entering E-mail address is mandatory");
            }
            else{
                Conn c = new Conn();
                String query = "insert into userinfo(FormNo, name, father_name, dob, gender, email, marriage, address, city, state, pincode) " +
                        "values ('"+Form+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marriage+"','"+address+"','"+city+"','"+state+"','"+pincode+"');";
                c.s.executeUpdate(query);
                //After successfully adding info to the DB Page 1 closes Page 2 opens
                setVisible(false);
                //The form number is unique and thus acts as a primary key so we pass it as an argument to the next page also to link both the pages togehter
                new SignUpTwo(Form).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
