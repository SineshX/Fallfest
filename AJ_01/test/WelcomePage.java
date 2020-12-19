
import javax.swing.*;
import java.awt.event.*;


public class WelcomePage extends JFrame implements ActionListener 
{

    private JButton jButton1;
    private JButton jButton2;   
   
    
    public WelcomePage() 
    {
        initComponents ();
    }

    private void initComponents() 
    {
        JPanel panel=new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        panel.setLayout(null);
        setName("Welcome Page");
        setTitle("ALLEVIATE AID ADVISORY");
        panel.setForeground(java.awt.Color.lightGray);
        panel.setBackground(new java.awt.Color (0, 200, 0));

        jButton1.setText("Register");
        jButton1.setBounds(40, 100, 90, 30);
        panel.add(jButton1);
        jButton1.addActionListener(this);// register about

        jButton2.setText("Login");
        jButton2.setLocation(40, 150);
        jButton2.setSize(jButton2.getPreferredSize());
        panel.add(jButton2);
        jButton2.addActionListener(this);// login htu
    
        getContentPane().add(panel);
        setVisible(true);
        setSize(575,475);
    }


    public static void main (String args[]) 
    {
        new WelcomePage ();
    }//main


    public void actionPerformed(ActionEvent e)
    {
        JButton button= (JButton)e.getSource();
        if(button.equals(jButton1))
        {
             new Register();
            this.dispose();
        }
    
        else if(button.equals(jButton2))
        {
            // new Login();
            AllUser idpassword = new AllUser();
			LoginPage loginPage = new LoginPage(idpassword.getLoginInfo());
            this.dispose();
        }

        else
        {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            System.exit(0);
        
        }
    
     }



}