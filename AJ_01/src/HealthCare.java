import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//
import graminSewa.Application;

import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

class LoginPage  implements ActionListener  {
	
	

	JFrame frame= new JFrame();
	
	JButton loginButton=new JButton("Login");
	JButton resetButton=new JButton("Reset");
	JTextField userIDField=new JTextField();
	JPasswordField userPasswordField=new JPasswordField(); 
	JLabel userIDLabel=new JLabel("userID:");
	JLabel userPasswordLabel=new JLabel("Password");
	JLabel messageLabel=new JLabel("WELCOME ");
	
	static String USERID, PASS;
	
	HashMap<String,String>logininfo =new HashMap<String,String>();
	
	LoginPage(HashMap<String,String>loginInfoOriginal){
		
		logininfo=loginInfoOriginal;
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		ImageIcon background_image=new ImageIcon("E:/Images/Image1.jpeg");
		
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.RIGHT);
		background.setBounds(400,100, 900, 600);
		frame.getContentPane().add(background);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(messageLabel);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(messageLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,1000);
		frame.setLayout(null);
		frame.setVisible(true);
		
	    frame.pack();
	    frame.setLocation(400,200);
	    frame.setVisible(true);
		
			
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource()==loginButton) {
			String userID=userIDField.getText();
			String password=String.valueOf(userPasswordField.getPassword());
			USERID = userID;
			PASS = password;
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("LOGIN SUCCESSFULL");
					
					frame.dispose();
			
					
				}
				
				
				Scanner Sc=new Scanner (System.in);
			//	if(authenticated == 1) {
					
					System.out.println("\n\n##### WELCOME ######");
					
					while(true) {
						
						System.out.println("\n  1> Display Your Profile");
						System.out.println("  2> Add Family Member");
						System.out.println("  3> Family Member Profile");
						System.out.println("  4> Health Page");
						System.out.println("  5> Logout");
						
					int	choice2 = Sc.nextInt();
						
						if(choice2 == 1) {
							AllUser.SetIndex(LoginPage.getInfo());
							int a = AllUser.getIndex();
							AllUser.Profile(a);
						}
						else if(choice2 == 2) {
							AllUser.SetIndex(LoginPage.getInfo());
							do {
								AllUser.AddFamilyMembers();
								
								System.out.println("\n     1> add More Members");
								System.out.println("     2> back to home screem");
								
							int	choice3 = Sc.nextInt();
								if(choice3 == 2) {
									break;
								}
								
							} while(true);
							
									
						}
						
						else if(choice2 == 3) {
							//AllUser.SetIndex(LoginPage.getInfo());
							AllUser.FamilyProfile(AllUser.getIndex());
						}
						else if(choice2 == 4) {
							Application a=new Application();
							Scanner sc=new Scanner(System.in);
							int ch;
							boolean choice22=true;
							
							Application p= new Application();
							
							while(choice22)
							{
								System.out.println("1.Health");
								System.out.println("8. EXIT");
								System.out.println("");
								System.out.println("Enter the choice");
								ch=sc.nextInt();
								switch(ch)
								{
								case 1:	
								    p.Health();		
									break;
								
								case 8:
									System.out.println("THANK YOU FOR VISITING US");
									System.exit(0);
									break;
								default:
										System.out.println("INVALID OPTION!!!!");
								}
								System.out.println("Go To Main Page(true/false)");
								choice22=sc.nextBoolean();
								
							} 
							
								} 
							
						else if(choice2 ==5)
						{
							break;
						}
							
					}//inner while loop ends
					
				
				
			}//outer while loop ends		
			
				
		/*		Scanner sc=new Scanner(System.in);
				int ch;
				boolean choice=true;
				
				Application a= new Application();
				
				while(choice)
				{
					System.out.println("1.Health");
					System.out.println("8. EXIT");
					System.out.println("");
					System.out.println("Enter the choice");
					ch=sc.nextInt();
					switch(ch)
					{
					case 1:	
					    a.Health();		
						break;
					
					case 8:
						System.out.println("THANK YOU FOR VISITING US");
						System.exit(0);
						break;
					default:
							System.out.println("INVALID OPTION!!!!");
					}
					System.out.println("Go To Main Page(true/false)");
					choice=sc.nextBoolean();
					
				} 
				
					} */
				
				
				
				
				
				
					
					else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText(" WRONG Password");
					
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
	
	
	
	public static String getInfo() {
		return USERID;
	}
}

/*class WelcomePage {
	
	JFrame frame= new JFrame();
	JLabel welcomeLabel=new JLabel("WELCOME IN");
	JLabel welcomeLabel2=new JLabel(" GRAMIN Sewa");
	
	
	void Welcome(){	
		welcomeLabel.setBounds(0, 0, 200, 35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("PORTAL WELCOMES ");
		
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.dispose();
	}
}	*/






class AllUser {

    static int I = 1, Index = 0, Familyindex = 0;

    static String user, pass1, name, phone, pass2, email;
    static String User, pass, identity;
    static int i, check = 0, k;
    
    static Scanner sc = new Scanner(System.in);
    
    static HashMap<String,String> logininfo=new HashMap<String,String>();
    static String[][] detail = new String[10][4];
    static String[][][] familyMembers = new String[10][5][3];

    public static void CreateUser() {

        System.out.println("\n----------------------------------");
        System.out.println("--> Enter Your Details Carefully :");
        System.out.println("----------------------------------");
        

        System.out.println("\nEnter your name : ");
        name = sc.next();

        System.out.println("\nEnter your Phone Number : ");
        phone = sc.next();
        
        System.out.println("\nEnter your Email : ");
        email = sc.next();

        System.out.println("\nEnter your Password : ");
        pass1 = sc.next();

        System.out.println("\nConfirm Password : ");
        pass2 = sc.next();

        System.out.println("\n#########################");

        if (pass1.equals(pass2)) {
        	
        	detail[I-1][0] = name;
        	detail[I-1][1] = phone;
        	detail[I-1][2] = pass1;
        	detail[I-1][3] = email;
        	
        	User = detail[I-1][0];
        	pass = detail[I-1][2];
        	logininfo.put(User, pass);

            Index = I;
            I++;

            System.out.println(" Succesfully Registered!");
            System.out.println("#########################");
        } else {
            System.out.println("Password Doesn't Match");
        }

    }
    
    /*
    public static void print() {
    	for(int i=0; i<10; i++) {
    		for(int j=0; j<4; j++) {
    			System.out.print(detail[i][j] + " ");
    		}
    		System.out.println();
    	}
    }*/
    
    public static boolean CheckUser() {

        Scanner sc = new Scanner(System.in);
        
        if(detail[0][0] != null && detail[0][2] != null) {
 
        	return true;
        }
        return false;
    }
    
    public static void SetIndex(String N) {
    	
    	for(int x=0 ; x<=I ; x++) {
    		
    		if(detail[x][0].equals(N)) {
    			Index = x + 1;
    			//System.out.println("Yes: "+ detail[x][0]);
    			break;
    		}
    	}
    }
    
    public static void Profile(int I1) {

        System.out.println("  PROFILE :-");
        System.out.println("  --> Name :      " + detail[I1-1][0]);
        System.out.println("  --> Email Id :  " + detail[I1-1][3]);
    }
    
    
    
    public static void AddFamilyMembers() {
    	
    	System.out.print("\n  Enter Details of Family Member :");
    	System.out.print("\n    Enter Name : ");
    	familyMembers[Index - 1][Familyindex][0] = sc.next();
    	
    	System.out.print("    Enter Gender : ");
    	familyMembers[Index - 1][Familyindex][1] = sc.next();
    	
    	System.out.print("    Enter Age : ");
    	familyMembers[Index - 1][Familyindex][2] = sc.next();
    	
    	Familyindex ++;
    	
    	
    }
    
    public static void FamilyProfile(int Fi) {
    	System.out.print(" Enter the Name of family Member : ");
    	identity = sc.next();
    	
    	for(k=0 ; k < Familyindex; k++) {
    		
    		if(familyMembers[Fi - 1][k][0].equals(identity)) {
    			check = 1;
    			
    			System.out.println("\n  Profile:-");
    			System.out.println("\n  --> Name : " + familyMembers[Fi-1][k][0]);
    			System.out.println("  --> Gender : "+ familyMembers[Fi-1][k][1]);
    			System.out.println("  --> Age : " + familyMembers[Fi-1][k][2] + "\n");
		
    		}else {
    			check = 0;
    		}
    		
    	}
 
    	if(check == 0) {
    			System.out.print(" Member not Found!\n");
    	}
    	
    }
    
    protected HashMap getLoginInfo() {
    	
    	  return logininfo;
    }
    
    public static int getIndex() {
    	return Index;
    }
    
    /*
    public static void printfamily() {
    	
    	for(int l=0; l<10; l++) {
    		for(int m=0; m<5; m++) {
    			for(int n=0; n<3; n++) {
    				System.out.print(familyMembers[l][m][n] + " ");
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
    	
    }*/
}

interface I1{
public void Health();
	
}




class Application implements I1         //class for applications for portal 
{
	
	Scanner sc=new Scanner (System.in);
	Boolean b=true;
	
	
	public void Health()
    {
    	int b=1;
    	while(b==1) {
    		
    	System.out.println("Health Team welcomes You");
    	System.out.println("1. Hospital Issues");
    	System.out.println("2. Medicine Issues");
    	System.out.println("3. Doctor's Advice ");
    	System.out.println("4. PatientHelp");
    	System.out.println("5.DiseaseRisk");
    	int c=sc.nextInt();
    	
    		switch(c)
    		{
    		case 1:
    			HospitalIssues();
    			break;
    		case 2:
    			MedicineIssues();
    			break;
    		case 3:
    			DoctorAdvice();
    		case 4:
    			PatientHelp();
    		case 5:
    			DiseaseRisk();
    		default:
    			System.out.println("INVALID CHOICE");
    		}
    		System.out.println("");
    		System.out.println("Press 1 to Revisit Health Page");
    		System.out.println("Press 0 to Exit");
    		b=sc.nextInt();
    	}
    	if(b==0)
    	{
    		System.out.println("THANK YOU FOR VISITING US");
    	}
    }
   
    public  void HospitalIssues (){
    {
    	System.out.println("We Are Here to help you with Hospital Issues");
    	System.out.println("Press 1 to see Hospitals Details ");
    	int Hospital=sc.nextInt();
    	if(Hospital==1) {
    	try {
    		int ch;
    	BufferedReader file1=new BufferedReader(new FileReader("E:/Project/GraminSewaHospitalTimings.txt"));
    	while((ch=file1.read())!=-1) {
    		System.out.print((char)ch);
    	}
    	file1.close();
    	}catch(IOException e)
    	{
    		System.out.println(e.getMessage());
    	}
    	}
    	else
    	{
    		System.out.println("THANK YOU FOR VISITING US");
    		System.exit(0);
    	}
    }
    
    }
    private void MedicineIssues()
    {
    	System.out.println("Welcome To Medicine Related Issues");
    	System.out.println("Press 1 to know more about Medicines");
    	int Medicine=sc.nextInt();
    	if(Medicine==1)
    	{
    		try {
    		int ch;
    		BufferedReader file2=new BufferedReader(new FileReader("E:/Project/Medicineinfo.txt"));
    		while((ch=file2.read())!=-1)
    		{
    			System.out.print((char)ch);
    		}
    		file2.close();
    		}catch(IOException e)
    		{
    			System.out.println(e.getMessage());
    		}
    		}
    	else
    	{
    		System.out.println("Thank YOU For visiting Us");
    	}
    	
    	}
    
    private void DoctorAdvice()
    {
    	System.out.println("ASK YOUR QUERIES TO DOCTORS");
    	sc.nextLine();
    	String st=sc.nextLine();
    	System.out.println("YOUR QUERY IS RECORDED CONCERNED DOCTOR WILL GUIDE YOU SOON");
    }    
  public void PatientHelp()
  {
	  System.out.println("What Type of problem do you have???");
	  System.out.println("1.HAIR RELATED");
	  System.out.println("2.HEAD RELATED");
	  System.out.println("3.EAR RELATED");
	  System.out.println("4.EYES RELATED");
	  System.out.println("5.Digestion RELATED");  
	  System.out.println("6.NOSE RELATED");
	  System.out.println("7.SKIN RELATED");
	  System.out.println("8.TEETH  RELATED");
	  System.out.println("9.THYROID RELATED");
	  System.out.println("10.JOINTS RELATED");
	  System.out.println("11.STOMACH RELATED");
	  System.out.println("12.HEART RELATED");
	  System.out.println("13.RESPIRATORY RELATED");
	  System.out.println("14.KIDNEY RELATED");
	  System.out.println("15.BURNING RELATED ");
	  System.out.println("16.Others");
	  int ch=sc.nextInt();
	  switch(ch)
	  {
	  case 1:
		  
		 int op=1;
		 while(op==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file1=new BufferedReader(new FileReader("E:/Team15/Hair related.txt"));
			  while((c=file1.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file1=new BufferedReader(new FileReader("E:/Team15/Hairtype1.txt"));
				  while((c=file1.read())!=-1)
				  {
					  System.out.print((char)c);
					  
				  }
				  file1.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader Tfile2=new BufferedReader(new FileReader("E:/Team15/HAIRTYPE2.txt"));
				  while((c=Tfile2.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
				  Tfile2.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		  }
		  System.out.println(" ");
		System.out.println("PRESS 1 TO GO ON HAIR PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
		op=sc.nextInt();
	}
	if(op==2)
	{
		System.out.println("Hope we helped you!!");
	}
	break;
	case 2:
		  int opt=1;
			 while(opt==1)
		{	 
			  System.out.println("SPECIFY YOUR SYMPTOMS");
			  try
			  {
				  int c;
				  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Head Related.txt"));
				  while((c=file3.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
				  file3.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }
			  System.out.println("Enter Type number of symptoms To Know More");
			  int a=sc.nextInt();
			  if(a==1)
			  {
				  try
				  {
					  int c;
					  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Head type1.txt"));
					  while((c=file4.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
					  file4.close();
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
				  
			  }
			  else if(a==2)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Head type2.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
					  file5.close();
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			  }
			  else if(a==3)
			  {
				  int c;
				  try {
				  BufferedReader file6=new BufferedReader(new FileReader("E:/Team15/HEAD TYPE3.txt"));
				  while((c=file6.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
				  file6.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
				  
			  }
			  else if(a==4)
			  {
				  int c;
				  try {
				  BufferedReader file7=new BufferedReader(new FileReader("E:/Team15/HEAD TYPE4.txt"));
				  while((c=file7.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
				  file7.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }    
			  }
			  
			  else if(a==5)
			  {
				  int c;
				  try {
				  BufferedReader file8=new BufferedReader(new FileReader("E:/Team15/HEAD TYPE5.txt"));
				  while((c=file8.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
				  file8.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }      
			  } 
			  
			System.out.println("PRESS 1 TO GO ON Head PROBLEMS PAGE");
			System.out.println("Press 2 to exit");
			System.out.println("");
			opt=sc.nextInt();
		}
		if(opt==2)
		{
			System.out.println("Hope we helped you!!");
		}
		break;
	  case 3:
		  int opti=1;
			 while(opti==1)
		{	 
			  System.out.println("SPECIFY YOUR SYMPTOMS");
			  try
			  {
				  int c;
				  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/EAR RELATED.txt"));
				  while((c=file3.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }
			  System.out.println("");
			  System.out.println("Enter Type Number To Know More");
			  int a=sc.nextInt();
			  if(a==1)
			  {
				  try
				  {
					  int c;
					  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/EAR TYPE 1.txt"));
					  while((c=file4.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
				  
			  }
			  else if(a==2)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/EAR TYPE 2.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			  }
			  else if(a==3)
			  {
				  int c;
				  try {
				  BufferedReader file6=new BufferedReader(new FileReader("E:/Team15/EAR TYPE 3.txt"));
				  while((c=file6.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
				  file6.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
				  
			  }
		
			  System.out.println("");
			  
			System.out.println("PRESS 1 TO GO ON Ear PROBLEMS PAGE");
			System.out.println("Press 2 to exit");	
			opti=sc.nextInt();
		}
		if(opti==2)
		{
			System.out.println("Hope we helped you!!");
		}
		break;
	  case 4:
		  int optio=1;
			 while(optio==1)
		{	 
			  System.out.println("SPECIFY YOUR SYMPTOMS");
			  try
			  {
				  int c;
				  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/EYE RELATED.txt"));
				  while((c=file3.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }
			  System.out.println("Enter Type Number To Know More");
			  int a=sc.nextInt();
			  if(a==1)
			  {
				  try
				  {
					  int c;
					  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/EYE TYPE 1.txt"));
					  while((c=file4.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
				  
			  }
			  else if(a==2)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/EYE TYPE 2.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			  }
			  else if(a==3)
			  {
				  int c;
				  try {
				  BufferedReader file6=new BufferedReader(new FileReader("E:/Team15/EYE TYPE 3.txt"));
				  while((c=file6.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
				  file6.close();
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
				  
			  }
		
			  System.out.println("");
			System.out.println("PRESS 1 TO GO ON Eye PROBLEMS PAGE");
			System.out.println("Press 2 to exit");
		
			optio=sc.nextInt();
		}
		if(optio==2)
		{
			System.out.println("Hope we helped you!!");
		}
		break; 
	  case 5:
		  int option=1;
			 while(option==1)
		{	 
			  System.out.println("SPECIFY YOUR SYMPTOMS");
			  try
			  {
				  int c;
				  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Digestion.txt"));
				  while((c=file3.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }
			  System.out.println("Enter Type Number To Know More");
			  int a=sc.nextInt();
			  if(a==1)
			  {
				  try
				  {
					  int c;
					  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Digestiontype1.txt"));
					  while((c=file4.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
				  
			  }
			  else if(a==2)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Digestiontype2.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			 }
		
			  System.out.println("");
			System.out.println("PRESS 1 TO GO ON Digestion PROBLEMS PAGE");
			System.out.println("Press 2 to exit");
		
			option=sc.nextInt();
		}
		if(option==2)
		{
			System.out.println("Hope we helped you!!");
		}
		break;
	  case 6:
		  
		  int option1=1;
			 while(option1==1)
		{	 
			  System.out.println("SPECIFY YOUR SYMPTOMS");
			  try
			  {
				  int c;
				  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Nose related.txt"));
				  while((c=file3.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }
			  System.out.println("");
			  System.out.println("Enter Type Number To Know More");
			  int a=sc.nextInt();
			  if(a==1)
			  {
				  try
				  {
					  int c;
					  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/NOSE TYPE1.txt"));
					  while((c=file4.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
				  
			  }
			  else if(a==2)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/NOSE TYPE2.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			 }
		
			  System.out.println("");
			System.out.println("PRESS 1 TO GO ON NOSE PROBLEMS PAGE");
			System.out.println("Press 2 to exit");
		
			option1=sc.nextInt();
		}
		if(option1==2)
		{
			System.out.println("Hope we helped you!!");
		}
		break;
	  case 7:
		  
		  int option2=1;
			 while(option2==1)
		{	 
			  System.out.println("SPECIFY YOUR SYMPTOMS");
			  try
			  {
				  int c;
				  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Skinrelated.txt"));
				  while((c=file3.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }
			  System.out.println("");
			  System.out.println("Enter Type Number To Know More");
			  int a=sc.nextInt();
			  if(a==1)
			  {
				  try
				  {
					  int c;
					  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/SKIN TYPE1.txt"));
					  while((c=file4.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
				  
			  }
			  else if(a==2)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/SKIN TYPE2.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			 }
			  
			  
			  else if(a==3)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/SKIN TYPE3.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			 }
			  
			  else if(a==4)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/skin type4.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			 }
			  
		
			System.out.println("");
			System.out.println("PRESS 1 TO GO ON SKIN PROBLEMS PAGE");
			System.out.println("Press 2 to exit");
		
			option2=sc.nextInt();
		}
		if(option2==2)
		{
			System.out.println("Hope we helped you!!");
		}
		break;
	 case 8:
		  
		  int option3=1;
			 while(option3==1)
		{	 
			  System.out.println("SPECIFY YOUR SYMPTOMS");
			  try
			  {
				  int c;
				  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Teeth disease Symptoms.txt"));
				  while((c=file3.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }
			  System.out.println("");
			  System.out.println("Enter Type Number To Know More");
			  int a=sc.nextInt();
			  if(a==1)
			  {
				  try
				  {
					  int c;
					  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Teeth Type1.txt"));
					  while((c=file4.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
				  
			  }
			  else if(a==2)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Teeth Type2.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			 }
			  else if(a==3)
			  {
				  try
				  {
					  int c;
					  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Teeth Type3.txt"));
					  while((c=file5.read())!=-1)
					  {
						  System.out.print((char)c);
					  }
				  } catch(IOException e)
					  {
						  System.out.println(e.getMessage());
					  }  
			 }	  
		
			  System.out.println("");
			System.out.println("PRESS 1 TO GO ON Teeth PROBLEMS PAGE");
			System.out.println("Press 2 to exit");
		
			option3=sc.nextInt();
		}
		if(option3==2)
		{
			System.
			out.println("Hope we helped you!!");
		}
		break;
		
	 case 9:		  
		int option4=1;
		 while(option4==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Thyroid disease Symptoms.txt"));
			  while((c=file3.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("");
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Thyroid Type1.txt"));
				  while((c=file4.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Thyroid Type2.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }
		  else if(a==3)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Thyroid Type3.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }	  
	
		  System.out.println("");
		System.out.println("PRESS 1 TO GO ON Thyroid PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
	
		option4=sc.nextInt();
	}
	if(option4==2)
	{
		System.
		out.println("Hope we helped you!!");
	}
	break;
	
	 case 10:
		 
		 int option5=1;
		 while(option5==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Joint disease Symptoms.txt"));
			  while((c=file3.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("");
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Joint Type1.txt"));
				  while((c=file4.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Joint type2.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }
	
		System.out.println("");
		System.out.println("PRESS 1 TO GO ON NOSE PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
	
		option5=sc.nextInt();
	}
	if(option5==2)
	{
		System.out.println("Hope we helped you!!");
	}
	break;
		
	 case 11:
		 
		 int option6=1;
		 while(option6==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Stomach disease Symptoms.txt"));
			  while((c=file3.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("");
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Stomach type1.txt"));
				  while((c=file4.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Stomach type2.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }
		  else if(a==3)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Stomach type3.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }	  
	
		  System.out.println("");
		System.out.println("PRESS 1 TO GO ON Stomach PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
	
		option6=sc.nextInt();
	}
	if(option6==2)
	{
		System.
		out.println("Hope we helped you!!");
	}
	break;
		 
	 case 12:
		
		 int option7=1;
		 while(option7==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Heart disease Symptoms.txt"));
			  while((c=file3.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("");
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Heart type1.txt"));
				  while((c=file4.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Heart Type2.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }
	
		  System.out.println("");
		System.out.println("PRESS 1 TO GO ON Heart PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
	
		option7=sc.nextInt();
	}
	if(option7==2)
	{
		System.out.println("Hope we helped you!!");
	}
	break;
		
	 case 13:
              
		 int option8=1;
		 while(option8==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Respiratory.txt"));
			  while((c=file3.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("");
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Respiratorytype1.txt"));
				  while((c=file4.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Respiratorytype2.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }
	
		  System.out.println("");
		System.out.println("PRESS 1 TO GO ON Respiration PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
	
		option8=sc.nextInt();
	}
	if(option8==2)
	{
		System.out.println("Hope we helped you!!");
	}
	break;
		 
	 case 14:
		 
		 int option9=1;
		 while(option9==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/Kidney.txt"));
			  while((c=file3.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("");
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/Kidneytype1.txt"));
				  while((c=file4.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/Kidneytype2.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }
	
		  System.out.println("");
		System.out.println("PRESS 1 TO GO ON Kidney PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
	
		option9=sc.nextInt();
	}
	if(option9==2)
	{
		System.out.println("Hope we helped you!!");
	}
	break;
	 case 15:
		 
		 int option10=1;
		 while(option10==1)
	{	 
		  System.out.println("SPECIFY YOUR SYMPTOMS");
		  try
		  {
			  int c;
			  BufferedReader file3=new BufferedReader(new FileReader("E:/Team15/burn.txt"));
			  while((c=file3.read())!=-1)
			  {
				  System.out.print((char)c);
			  }
		  } catch(IOException e)
			  {
				  System.out.println(e.getMessage());
			  }
		  System.out.println("");
		  System.out.println("Enter Type Number To Know More");
		  int a=sc.nextInt();
		  if(a==1)
		  {
			  try
			  {
				  int c;
				  BufferedReader file4=new BufferedReader(new FileReader("E:/Team15/burntype1.txt"));
				  while((c=file4.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
			  
		  }
		  else if(a==2)
		  {
			  try
			  {
				  int c;
				  BufferedReader file5=new BufferedReader(new FileReader("E:/Team15/burntype2.txt"));
				  while((c=file5.read())!=-1)
				  {
					  System.out.print((char)c);
				  }
			  } catch(IOException e)
				  {
					  System.out.println(e.getMessage());
				  }  
		 }
	
		  System.out.println("");
		System.out.println("PRESS 1 TO GO ON Burning PROBLEMS PAGE");
		System.out.println("Press 2 to exit");
	
		option10=sc.nextInt();
	}
	if(option10==2)
	{
		System.out.println("Hope we helped you!!");
	}
	break;
		 
	 case 16:
		 System.out.println("WRITE COMPLETE DETAILS OF YOUR DISEASE HERE!!!!");
		 System.out.println("");
		 sc.nextLine();
		 String ask=sc.nextLine();
		 try
		 {
			 BufferedWriter filead=new BufferedWriter (new FileWriter("E:/Team15/Others"));
			 filead.write(ask);
		 }catch(IOException e)
		 {
			 System.out.println(e.getMessage());
		 }
		 System.out.println("GOT YOUR QUERY");
		 System.out.println("Concerned Doctor will  answer YOU SOON!!!");
		 break;
		 }
	  }
  public void DiseaseRisk()
  {
	  int setPoints=0,setPoints1=0, setPoints2=0;
	  String high,low,medium;
	  int  time;
	
	  System.out.println("#########################");
	  System.out.println("KNOW YOUR DISEASE RISK");
	
	  System.out.println("About How Much Time You are facing these Symptom's??");
	  time=sc.nextInt();
	  if(time<=2 )
	  {
		  setPoints=setPoints+2;
	  }
	  else if(time>2 && time<=5)
	  {
		  setPoints=setPoints+4;
	  }
	  else if(time>5)
	  {
		  setPoints=setPoints+7;
	  }
	  System.out.println("How much it affected your body??");
	  System.out.println("1. NOT SO MUCH");
	  System.out.println("2.FEELING BAD");
	  System.out.println("3.AFFECTED VERY MUCH ");
	  System.out.println("ENTER YOUR CHOICE");
	  int choice=sc.nextInt();
	  if(choice==1 )
	  {
		  setPoints1=setPoints1+2;
	  }
	  else if(choice==2)
	  {
		  setPoints1=setPoints1+4;
	  }
	  
	  else if(choice==3)
	  {
		  setPoints1=setPoints1+7;
	  }
	 System.out.println("Can you able to walk on your own??");
	 System.out.println("PRESS 1 FOR YES");
	 System.out.println("PRESS 2 FOR NO");
	 System.out.println("");
	 int choice1=sc.nextInt();
	 if(choice1==1 )
	  {
		  setPoints2=setPoints2+7;
	  }
	  else if(choice1==2)
	  {
		  setPoints2=setPoints2+5;
	  }
	 int count=setPoints+setPoints1+setPoints2;
	 if(count<10)
	 {
		 System.out.println("RISK LEVEL => LOW");
	 }
	 else if(count>10 && count<18)
	 {
		 System.out.println("RISK LEVEL => MEDIUM");
	 }
	 else if(count>=18)
	 {
		 System.out.println("Risk Level => HIGH");
	 }
  }
    

}






public class HealthCare   {
   
	public static void main(String args[])
	{
		int choice, authenticated = 0 , choice2, choice3,option;
		Scanner Sc = new Scanner(System.in);
	
		System.out.println("#### WELCOME TO ONLINE HEALTHCARE SYSTEM ####");
		
		 
		
		
			System.out.println("\n1>(ALREADY HAVE AN ACCOUNT) Login");
			System.out.println("2> Register(NEW USER)");
			System.out.println("3> Exit");
		
			choice = Sc.nextInt();
		
			if(choice == 1) {
				
				boolean T = AllUser.CheckUser();
				
				if(T == true) {
                    
                	AllUser idpassword = new AllUser();
					LoginPage loginPage = new LoginPage(idpassword.getLoginInfo());
					authenticated=1;
					
				}
				else {
					System.out.println("You do not have an account...Register First.");
				}
			}
			else if(choice == 2) {
				 AllUser.CreateUser();
	             //authenticated = 1;
				System.out.println("PRESS 1 TO LOGIN");
				System.out.println("PRESS 0 TO EXIT");
				option=Sc.nextInt();
				if(option==1)
				{
					 
                	AllUser idpassword = new AllUser();
					LoginPage loginPage = new LoginPage(idpassword.getLoginInfo());
				}
				else if(option==2)
				{
					System.out.println("THANK YOU FOR REGISTRATION !!!");
					System.exit(0);
				}
				
			}
			else if(choice == 3) {
				System.exit(1);
			}
			/*
			else if(choice == 4) {
				AllUser.print();
			}
			else if(choice == 5) {
				AllUser.printfamily();
			}
			else if(choice == 6) {
				System.out.println(AllUser.getIndex());
			}*/
			
			
			
		//	if(authenticated == 1) {
				
		//		System.out.println("\n\n##### WELCOME ######");
				
			//	while(true) {
					
			/*		System.out.println("\n  1> Display Your Profile");
					System.out.println("  2> Add Family Member");
					System.out.println("  3> Family Member Profile");
					System.out.println("  4> Health Page");
					System.out.println("  5> Logout");
					
					choice2 = Sc.nextInt();
					
					if(choice2 == 1) {
						AllUser.SetIndex(LoginPage.getInfo());
						int a = AllUser.getIndex();
						AllUser.Profile(a);
					}
					else if(choice2 == 2) {
						AllUser.SetIndex(LoginPage.getInfo());
						do {
							AllUser.AddFamilyMembers();
							
							System.out.println("\n     1> add More Members");
							System.out.println("     2> back to home screem");
							
							choice3 = Sc.nextInt();
							if(choice3 == 2) {
								break;
							}
							
						} while(true);
						
								
					}
					
					else if(choice2 == 3) {
						//AllUser.SetIndex(LoginPage.getInfo());
						AllUser.FamilyProfile(AllUser.getIndex());
					}
					else if(choice2 == 4) {
						Application a=new Application();
						Scanner sc=new Scanner(System.in);
						int ch;
						boolean choice22=true;
						
						Application p= new Application();
						
						while(choice22)
						{
							System.out.println("1.Health");
							System.out.println("8. EXIT");
							System.out.println("");
							System.out.println("Enter the choice");
							ch=sc.nextInt();
							switch(ch)
							{
							case 1:	
							    p.Health();		
								break;
							
							case 8:
								System.out.println("THANK YOU FOR VISITING US");
								System.exit(0);
								break;
							default:
									System.out.println("INVALID OPTION!!!!");
							}
							System.out.println("Go To Main Page(true/false)");
							choice22=sc.nextBoolean();
							
						} 
						
							} 
						
					else if(choice2 ==5)
					{
						break;
					}
						
				}//inner while loop ends
				
			}
			
		}*///outer while loop ends		
		
	
 }
}
