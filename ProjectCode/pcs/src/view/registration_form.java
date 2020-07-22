package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginFrame;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import controller.EmployeeController;
import model.Employee;

public class registration_form extends JFrame implements ActionListener {

	JLabel Reg,userid,password,FirstN,LastN,Mob,gen,dob,vertical,crntR,skills,doj,IMessage;
	JTextField user,pas,fN,LN,Mo,DOB,ver,skil,joiningdate;
	JComboBox G1;
	JButton Save,reset;
	JComboBox<?> C1;
	String R1[]= {"","EMP","HR","PM"};
	String R2[]= {"","Male","Female"};
	//registration_form empp=new registration_form();

	public void main_reg()
	{
	//JFrame frame=new JFrame();
	
	Reg=new JLabel("Registration Form");
	Reg.setForeground(Color.BLUE);
	Reg.setBounds(170,10,200,40);
	userid=new JLabel("User ID");
	userid.setBounds(50, 75, 100, 20);
	password=new JLabel("Password");
	password.setBounds(50, 105, 100, 20);
	FirstN=new JLabel("First Name");
	FirstN.setBounds(50, 140, 100, 20);
	LastN=new JLabel("Last Name");
	LastN.setBounds(50, 175, 100, 20);
	Mob=new JLabel("Mobile");
	Mob.setBounds(50, 205, 100, 20);
	gen=new JLabel("Gender");
	gen.setBounds(50, 240, 100, 20);
	dob=new JLabel("Date Of Birth");
	dob.setBounds(50, 275, 100, 20);
	vertical=new JLabel("Vertical");
	vertical.setBounds(50, 305, 100, 20);
	crntR=new JLabel("Current Role");
	crntR.setBounds(50, 340, 100, 20);
	C1 = new JComboBox(R1);
	C1.setBounds(150, 340, 200, 20);
	
	skills=new JLabel("Skills");
	skills.setBounds(50, 375, 100, 20);
	doj=new JLabel("Experience");
	doj.setBounds(50, 405, 100, 20);
	IMessage=new JLabel();
	IMessage.setBounds(60, 280, 180, 20);

	user=new JTextField();
	user.setBounds(150, 75, 200, 20);
	user.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	pas=new JTextField();
	pas.setBounds(150, 105, 200, 20);
	pas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	fN=new JTextField();
	fN.setBounds(150, 140, 200, 20);
	fN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	LN=new JTextField();
	LN.setBounds(150, 175, 200, 20);
	LN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	Mo=new JTextField();
	Mo.setBounds(150, 205, 200, 20);
	Mo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	G1 = new JComboBox(R2);
	G1.setBounds(150, 240, 200, 20);
	DOB=new JTextField();
	DOB.setBounds(150, 275, 200, 20);
	DOB.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	ver=new JTextField();
	ver.setBounds(150, 305, 200, 20);
	ver.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

//	C1.setBounds(50, 340, 100, 20);
	skil=new JTextField();
	skil.setBounds(150, 375, 200, 20);
	skil.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	joiningdate=new JTextField();
	joiningdate.setBounds(150, 405, 200, 20);
	joiningdate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	Save=new JButton("Save");
	Save.setForeground(Color.BLUE);
	
	Save.setBounds(110, 450, 80, 20);
	Save.addActionListener(this);
	
	reset=new JButton("Reset");
	reset.setForeground(Color.BLUE);
	reset.addActionListener(this);
	reset.setBounds(220, 450, 80, 20);
	add(Reg);
	add(userid);
	add(password);
	add(FirstN);
	add(LastN);
	add(Mob);
	add(gen);
	add(dob);
	add(vertical);
	add(crntR);
	add(skills);
	add(doj);
	add(user);
	add(pas);
	add(fN);
	add(LN);
	add(Mo);
	add(G1);
	add(DOB);
	add(ver);
	add(C1);
	add(skil);
	add(joiningdate);
	add(Save);
	add(reset);
	add(IMessage);
	getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
	setSize(500,600);
    setLayout(null);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
	
	}

public void actionPerformed(ActionEvent e) {
	
	
	String msg=null;
		String user1=user.getText();
	    String pas1=pas.getText();
	    String fN1=fN.getText();
	    String LN1=LN.getText();
	    String Mo1=Mo.getText();
	    String gender1=G1.getSelectedItem().toString();
	    String DOB1=DOB.getText();
	 //  
	    String ver1=ver.getText();
	    String crntR11=C1.getSelectedItem().toString();
	    String skil1=skil.getText();
	    String joiningdate1=joiningdate.getText();
	  	  
	if(e.getSource()==Save)
	{
		
		 if(crntR11.equals("HRA"))
			 
			 msg= new EmployeeController().save(fN1, LN1, user1, pas1, gender1, Mo1, DOB1, ver1, crntR11, skil1, joiningdate1 ,"true");
			else
				msg= new EmployeeController().save(fN1, LN1, user1, pas1, gender1, Mo1, DOB1, ver1, crntR11, skil1, joiningdate1,"false" );
	 			
		if(msg!=null)
		   {
			 
			 LoginFrame log=new LoginFrame();
			 log.setVisible(true);
			 log.mainwindow();
			 this.hide();
			  
		   }
		
		 
		   }
	   else if(e.getSource()==reset)
	   {

			
			 user.setText(null);
			 pas.setText(null);
			 fN.setText(null);
			 LN.setText(null);
			 Mo.setText(null);
			 G1.setToolTipText(null);
			 DOB.setText(null);
			 ver.setText(null);
			 C1.setToolTipText(null);
			skil.setText(null);
			joiningdate.setText(null);
		}
	   else {
		   IMessage.setText("Sorry!wrong entry!");
	   }
	}
	/*if(message!=null)
	   {
		   IMessage.setText(message);
		   LoginFrame log=new LoginFrame();
			 log.setVisible(true);
	         log.setVisible(true);
	        }
    else
		{
			IMessage.setText("Sorry!wrong entry!");
			 user.setText(null);
			 pas.setText(null);
			 fN.setText(null);
			 LN.setText(null);
			 Mo.setText(null);
			 gender.setText(null);
			 DOB.setText(null);
			 ver.setText(null);
			 crntR1.setText(null);
				skil.setText(null);
				ep.setText(null);
		}*/
		
		
	}
/*public void actionPerformed1(ActionEvent e) {
	String user1=user.getText();
    String pas1=pas.getText();
    String fN1=fN.getText();
    String LN1=LN.getText();
    String Mo1=Mo.getText();
    String gender1=gender.getText();
    String DOB1=DOB.getText();
    String ver1=ver.getText();
    String crntR11=crntR1.getText();
    String skil1=skil.getText();
    String joiningdate1=ep.getText();
   
    Employee emp=new Employee();
    if(crntR11.equals("HRA"))
		emp.setActive("true");
	else
		emp.setActive("false");
    
    
    
   String message= new EmployeeController().save(fN1, LN1, user1, pas1, gender1, Mo1, DOB1, ver1, crntR11, skil1, joiningdate1 );
   if(message!=null)
   {
	  IMessage.setText(message);
	   
	  
	   dispose();
	 LoginFrame log=new LoginFrame();
	 log.setVisible(true);
	  
   }
   
	else
	{
		IMessage.setText("Sorry!wrong entry!");
		 user.setText(null);
		 pas.setText(null);
		 fN.setText(null);
		 LN.setText(null);
		 Mo.setText(null);
		 gender.setText(null);
		 DOB.setText(null);
		 ver.setText(null);
		 crntR1.setText(null);
		skil.setText(null);
		ep.setText(null);
	}
}*/

		




