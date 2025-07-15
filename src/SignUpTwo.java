import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener {
    JTextField panText, aadharText;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religionC, categoryC, incomeC, educationC, occupationC;
    JButton next;
    String form;
    SignUpTwo(String FormNo){
        this.form = FormNo;

        setSize(800, 850);
        setLocation(375, 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Additional customer details");
        setLayout(null);

        JLabel Title = new JLabel("Page 2: New Account Application");
        Title.setBounds(100, 50, 600, 100);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        add(Title);

        JLabel SubTitle = new JLabel("Page 2: Personal Details");
        SubTitle.setBounds(220, 170, 600, 50);
        SubTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(SubTitle);

        JLabel Form = new JLabel("Form No. "+form);
        Form.setBounds(600, 50, 100,20);
        Form.setFont(new Font("Times New Roman", Font.BOLD, 10));
        add(Form);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(110, 240, 100, 30);
        religion.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(religion);
        // To add a drop down bar, we use the combobox class and pass array of strings into it of the values the dropdown will have
        String[] valRel = {"Hindu", "Muslim", "Sikh", "Christianity", "Others"};
        religionC = new JComboBox<>(valRel);
        religionC.setBackground(Color.white);
        religionC.setBounds(370, 240, 300, 30);
        religionC.setFont(new Font("Railway", Font.BOLD, 15));
        add(religionC);

        JLabel category = new JLabel("Category:");
        category.setBounds(110, 290, 200, 30);
        category.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(category);
        String[] valCat = {"General", "OBC", "SC", "ST", "Others"};
        categoryC = new JComboBox(valCat);
        categoryC.setBackground(Color.white);
        categoryC.setBounds(370, 290, 300, 30);
        categoryC.setFont(new Font("Railway", Font.BOLD, 15));
        add(categoryC);

        JLabel income = new JLabel("Income:");
        income.setBounds(110, 340, 250, 30);
        income.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(income);
        String[] valIncome = {"NULL", "Less than 1,50,000", "Less than 2,50,00", "Less than 5,00,000", "Upto 10,00,000"};
        incomeC = new JComboBox(valIncome);
        incomeC.setBackground(Color.white);
        incomeC.setBounds(370, 340, 300, 30);
        incomeC.setFont(new Font("Railway", Font.BOLD, 15));
        add(incomeC);


        JLabel education = new JLabel("Educational Qualification:");
        education.setBounds(110, 390, 250, 30);
        education.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(education);
        String[] valEdu = {"Non-Graduate", "Graduation", "Post-Graduation", "Doctorate", "Others"};
        educationC = new JComboBox(valEdu);
        educationC.setBackground(Color.white);
        educationC.setBounds(370, 390, 300, 30);
        educationC.setFont(new Font("Railway", Font.BOLD, 15));
        add(educationC);


        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(110, 440, 150, 30);
        occupation.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(occupation);
        String[] valOccupation = {"Salaried", "Self-employed", "Business", "Student", "Retired", "Others"};
        occupationC = new JComboBox(valOccupation);
        occupationC.setBackground(Color.white);
        occupationC.setBounds(370, 440, 300, 30);
        occupationC.setFont(new Font("Railway", Font.BOLD, 15));
        add(occupationC);


        JLabel pan = new JLabel("Pan Number:");
        pan.setBounds(110, 490, 190, 30);
        pan.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(pan);
        panText = new JTextField();
        panText.setBounds(370, 490, 300, 30);
        panText.setFont(new Font("Railway", Font.BOLD, 15));
        add(panText);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(110, 540, 150, 30);
        aadhar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(aadhar);
        aadharText = new JTextField();
        aadharText.setBounds(370, 540, 300, 30);
        aadharText.setFont(new Font("Railway", Font.BOLD, 15));
        add(aadharText);

        JLabel senior = new JLabel("Are you a senior citizen?");
        senior.setBounds(110, 590, 300, 30);
        senior.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(senior);
        syes = new JRadioButton("Yes");
        syes.setBounds(370, 590, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(490, 590, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        //This is done so that no two options can be selected together if only 1 is allowed
        ButtonGroup seniorB = new ButtonGroup();
        seniorB.add(syes);
        seniorB.add(sno);

        JLabel existing  = new JLabel("Have an existing account?");
        existing.setBounds(110, 640, 300, 30);
        existing.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(existing);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(370, 640, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(490, 640, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        //This is done so that no two options can be selected together if only 1 is allowed
        ButtonGroup exisitingB = new ButtonGroup();
        exisitingB.add(eyes);
        exisitingB.add(eno);

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
        String Form = "" + form;
        //Database will take values in the form of string
        //getSelectedItem() brings any value chosen on the drop-down in form of object which is then type casted to string
        String religion = (String) religionC.getSelectedItem();
        String category = (String) categoryC.getSelectedItem();
        String income = (String) incomeC.getSelectedItem();
        String education = (String) educationC.getSelectedItem();
        String occupation = (String) occupationC.getSelectedItem();

        String senior = null;
        if(syes.isSelected()){
            senior = "Yes";
        } else if (sno.isSelected()) {
            senior = "No";
        }

        String exisiting = null;
        if(eyes.isSelected()){
            exisiting = "Yes";
        } else if (eno.isSelected()) {
            exisiting = "No";
        }

        String PanNo = panText.getText();
        String AadharNo = aadharText.getText();

        try{
            if (AadharNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Entering Aadhar number is mandatory");
            }
//            else if (senior.isEmpty("")) {
//                JOptionPane.showMessageDialog(null, "Entering father's name is mandatory");
//            }
//            else if (exisiting.isEmpty("")) {
//                JOptionPane.showMessageDialog(null, "Entering Date of birth is mandatory");
//            }
            else{
                Conn c = new Conn();
                String query = "insert into userinfo2(FormNo, religion, category, income, education, occupation, pan, aadhar, senior, exisiting) " +
                        "values ('"+Form+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+PanNo+"','"+AadharNo+"','"+senior+"','"+exisiting+"');";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(Form).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
