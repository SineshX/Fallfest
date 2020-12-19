import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;

public class Register extends JFrame implements ActionListener 
{
    JLabel lblHeading;
	JLabel lblAcctType;
	JLabel lblName;
    JLabel lblSex;
    JLabel lblAge;
    JLabel lblEmailID;
    JLabel lblStuPwd;
    JLabel lblCnfStuPwd;
    JLabel lblPhone;

    JComboBox lstAcctType;
    JTextField txtName;
    JComboBox lstSex;
    JTextField txtAge;
    JTextField txtEmailID;
	JTextField txtAdminID;
	JPasswordField txtStuPwd;
    JPasswordField txtCnfStuPwd;
    JTextField txtPhone;

    Font font =new Font("Helvetica",Font.BOLD,24);
	Color DARKBLUE=new Color(0,0,64);
	Color FONTCOLOR=new Color(100,100,100);
    
    FileInputStream fis;
	DataInputStream dis;
	String saves[][] = new String [500][20];
	String records[][] = new String [500][20];
	int count = 0;
	int rows = 0;
	int total = 0;

	JButton btnSubmit;
	JButton btnCancel;   

   
    
    public Register() 
    {       
        this.setTitle("Registration Page");
		JPanel panel=new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbCons=new GridBagConstraints();

		gbCons.gridx=0;
		gbCons.gridy=0;
		lblHeading=new JLabel("Registration");
		lblHeading.setFont(font);
        lblHeading.setForeground(new Color(10,100,10));
        
        lblHeading.setVerticalAlignment(SwingConstants.TOP);
		gbCons.anchor=GridBagConstraints.EAST;
        panel.add(lblHeading,gbCons);
        
        gbCons.gridx=0;
		gbCons.gridy=0;
		lblHeading=new JLabel("Registration");
		lblHeading.setFont(font);
		lblHeading.setForeground(new Color(10,0,10));
		lblHeading.setVerticalAlignment(SwingConstants.TOP);
		gbCons.anchor=GridBagConstraints.EAST;
		panel.add(lblHeading,gbCons);



		gbCons.gridx=0;
		gbCons.gridy=1;
		lblAcctType=new JLabel("Account Type ");
		gbCons.anchor=GridBagConstraints.WEST;
		lblAcctType.setForeground(FONTCOLOR);
		panel.add(lblAcctType,gbCons);

		gbCons.gridx=1;
		gbCons.gridy=1;
		String[] type={"Doctor","Patient"};
		lstAcctType = new JComboBox(type);
		lstAcctType.setSelectedIndex(1);
		panel.add(lstAcctType,gbCons);

		gbCons.gridx=0;
		gbCons.gridy=2;
		lblName=new JLabel("Name : ");
		lblName.setForeground(FONTCOLOR);
		panel.add(lblName,gbCons);

		gbCons.gridx=1;
		gbCons.gridy=2;
		txtName=new JTextField(20);
		panel.add(txtName,gbCons);

		gbCons.gridx=0;
		gbCons.gridy=5;
		lblSex=new JLabel("Sex ");
		lblSex.setForeground(FONTCOLOR);
		panel.add(lblSex,gbCons);



		gbCons.gridx=1;
		gbCons.gridy=5;
		String[] sex={"Male","Female"};
		lstSex = new JComboBox(sex);
		lstSex.setSelectedIndex(0);
		panel.add(lstSex,gbCons);


		gbCons.gridx=0;
		gbCons.gridy=6;
		lblAge=new JLabel("Age ");
		lblAge.setForeground(FONTCOLOR);
		panel.add(lblAge,gbCons);

		gbCons.gridx=1;
		gbCons.gridy=6;
		txtAge=new JTextField(20);
		panel.add(txtAge,gbCons);


		gbCons.gridx=0;
		gbCons.gridy=10;
		lblEmailID=new JLabel("Email Address ");
		lblEmailID.setForeground(FONTCOLOR);
		panel.add(lblEmailID,gbCons);


		gbCons.gridx=1;
		gbCons.gridy=10;
		txtEmailID=new JTextField(20);
		panel.add(txtEmailID,gbCons);


		gbCons.gridx=0;
		gbCons.gridy=12;
		lblStuPwd=new JLabel("Password ");
		lblStuPwd.setForeground(FONTCOLOR);
		panel.add(lblStuPwd,gbCons);


		gbCons.gridx=1;
		gbCons.gridy=12;
		txtStuPwd=new JPasswordField(20);
		panel.add(txtStuPwd,gbCons);



		gbCons.gridx=0;
		gbCons.gridy=13;
		lblCnfStuPwd=new JLabel("Confirm Password ");
		lblCnfStuPwd.setForeground(FONTCOLOR);
		panel.add(lblCnfStuPwd,gbCons);



		gbCons.gridx=1;
		gbCons.gridy=13;
		txtCnfStuPwd=new JPasswordField(20);
		panel.add(txtCnfStuPwd,gbCons);


		gbCons.gridx=0;
		gbCons.gridy=14;
		lblPhone=new JLabel("Phone ");
		lblPhone.setForeground(FONTCOLOR);
		panel.add(lblPhone,gbCons);


		gbCons.gridx=1;
		gbCons.gridy=14;
		txtPhone=new JTextField(20);
		panel.add(txtPhone,gbCons);



		JPanel btnPanel=new JPanel();
		btnPanel.setBackground(DARKBLUE);
		btnSubmit=new JButton("Submit");
		btnPanel.add(btnSubmit);
		btnSubmit.addActionListener(this);


		btnCancel=new JButton("Cancel");
		btnPanel.add(btnCancel);
		btnCancel.addActionListener(this);


		gbCons.gridx=1;
		gbCons.gridy=15;
		gbCons.anchor=GridBagConstraints.EAST;
		panel.add(btnPanel,gbCons);

		panel.setBackground(DARKBLUE);

		getContentPane().add(panel);



		setVisible(true);
		setSize(450,450);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
        


    }
    public static void main (String args[]) 
    {
        new Register();
    }//main

    public void actionPerformed(ActionEvent e)
    {
        JButton button=(JButton)e.getSource();

				if(button.equals(btnCancel))
				{
					new WelcomePage();
					this.dispose();
				}

				else if(button.equals(btnSubmit))
				{
					String name = txtFirstName.getText();
					// int var=verify();

					// if(var==1)
					{
						// populateArray();
						// findRec();
						this.dispose();
					}

					// else
					{
						// showErrordlg();
					}
                }
                else
                {
                    this.dispose();
                }
    
     }



}