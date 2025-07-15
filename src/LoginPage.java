import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {
    //Declaring buttons globally so that they can be used in all classes and methods
    JButton Sign, Clear, SignUp;
    JTextField CardInfo;
    JPasswordField PinInfo;

    LoginPage(){
        // This is to set the frame size and location on where will the frame appear on screen
        setSize(800,650);
        setLocation(375,175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Change the background color of the frame, the getContentPane() returns an object of the frame container so we can change it
        getContentPane().setBackground(Color.WHITE);
        // Setting the default layout to null so that we can place our items according to our choices
        setLayout(null);

        // Title of the window that opens when program is run
        setTitle("Banking Management System");


        // Getting the image from the directory and scaling it to be put onto the window
        // Here getClass() was used because it is less riskier and trickier than ClassLoader and is more prefered
        ImageIcon BankLogo = new ImageIcon(getClass().getResource("/Images/LoginLogo.jpg"));
        // Image cant be directly scaled thus Image ka object banake scaling hota hai and then again load it to the waiting area to put it on stage
        Image ScaledLogo = BankLogo.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(ScaledLogo);

        // For putting anything on the frame use JLabel
        // Putting the icon on the window with the help of JLabel, The set bound decides where the photo will be positioned on the window
        JLabel logo1 = new JLabel(logo);
        logo1.setBounds(50, 100, 100, 100);
        add(logo1);

        //Since default layout is set null every element has to be positioned accordingly with its texts
        JLabel text = new JLabel("Welcome to the Banking System");
        text.setFont(new Font("Oswald", Font.BOLD, 30));
        text.setBounds(190, 100, 500, 100);
        add(text);

        JLabel Card = new JLabel("Card Number: ");
        Card.setFont(new Font("Railway", Font.BOLD, 25));
        Card.setBounds(120, 250, 200, 50);
        add(Card);
        CardInfo = new JTextField();
        CardInfo.setFont(new Font("Arial", Font.BOLD, 20));
        CardInfo.setBounds(330, 250, 260, 50);
        add(CardInfo);

        JLabel Pin = new JLabel("PIN: ");
        Pin.setFont(new Font("Railway", Font.BOLD, 25));
        Pin.setBounds(120, 350, 100, 50);
        add(Pin);
        PinInfo = new JPasswordField();
        PinInfo.setFont(new Font("Arial", Font.BOLD, 20));
        PinInfo.setBounds(330, 350, 260, 50);
        add(PinInfo);


        //Add buttons and set their background and text color and position them
        //The this keyword calls actionPerformed class whenever the button is clicked saying this button i.e. an object of class LoginPage has called the method.
        Sign = new JButton("Sign In");
        Sign.setBackground(Color.BLACK);
        Sign.setForeground(Color.white);
        Sign.setBounds(330, 430, 115, 50);
        Sign.addActionListener(this);
        add(Sign);

        Clear = new JButton("Clear");
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.white);
        Clear.setBounds(475, 430, 115, 50);
        Clear.addActionListener(this);
        add(Clear);

        SignUp = new JButton("Sign Up");
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.white);
        SignUp.setBounds(330, 500, 260, 50);
        SignUp.addActionListener(this);
        add(SignUp);


        setVisible(true);
    }

    //Action Listener has an Abstract method which is below so we have to write and override it to make use
    //ActionEvent is a class and e is its object on which action can be performed
    public void actionPerformed(ActionEvent e){
        //the getSource() checks whether the button was clicked or not
        if (e.getSource()==Sign){
            String card = CardInfo.getText();
            String pin = PinInfo.getText();
            Conn c = new Conn();
            String query = "Select * from login where cardnumber = '"+card+"' and pinnumber = '"+pin+"';";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else if (e.getSource()==Clear) {
            CardInfo.setText("");
            PinInfo.setText("");
        }
        else if (e.getSource()==SignUp) {
            //The initial login page will close and the signupone class object will come to work and its window will open as set visible of it is set to true
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
