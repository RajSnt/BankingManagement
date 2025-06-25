import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SignUpOne extends JFrame {

    SignUpOne(){

        Random gen = new Random();
        int FormNo = 1000 + gen.nextInt(9000);
        System.out.println(FormNo);
        setSize(800, 800);
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

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(110, 290, 200, 30);
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(fname);

        JLabel dob = new JLabel("Date of birth:");
        dob.setBounds(110, 340, 250, 30);
        dob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(dob);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(110, 390, 100, 30);
        gender.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(gender);

        JLabel email = new JLabel("Email:");
        email.setBounds(110, 440, 100, 30);
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(email);

        JLabel marriage = new JLabel("Marital status:");
        marriage.setBounds(110, 490, 150, 30);
        marriage.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(marriage);

        JLabel address = new JLabel("Residential Address:");
        address.setBounds(110, 540, 190, 30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);

        JLabel city = new JLabel("City:");
        city.setBounds(110, 590, 100, 30);
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(city);

        JLabel state = new JLabel("State:");
        state.setBounds(110, 640, 100, 30);
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(state);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setBounds(110, 690, 100, 30);
        pincode.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(pincode);




        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
