package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import controller.EmployeeController;

public class Empview extends JFrame implements ActionListener{
	JTextField emp,user,pas,fN,LN,Mo,gender,DOB,ver,skil,joiningdate,role;
	JLabel empid,userid,password,FirstN,LastN,Mob,gen,dob,vertical,crntR,skills,doj;
    JButton back,additionalSkills;
	public void view() {
		setTitle ("Employee Information");
		empid=new JLabel("Employee ID");
		empid.setBounds(50, 40, 100, 20);
		
		userid=new JLabel("User ID");
		userid.setBounds(50, 75, 100, 20);
		
		password=new JLabel("Password");
		password.setBounds(50, 105, 100, 20);
	
		FirstN=new JLabel("First Name");
		FirstN.setBounds(50, 140, 100, 20);
		
		LastN=new JLabel("Last Name");
		LastN.setBounds(50, 175, 100, 20);
		
		Mob=new JLabel("Mobile");
		Mob.setBounds(50, 210, 100, 20);
		dob=new JLabel("Date Of Birth");
		dob.setBounds(50, 245, 100, 20);
		
		gen=new JLabel("Gender");
		gen.setBounds(50, 280, 100, 20);
		
		
		
		vertical=new JLabel("Vertical");
		vertical.setBounds(50, 315, 100, 20);
		
		crntR=new JLabel("Current Role");
		crntR.setBounds(50, 350, 100, 20);
		
		skills=new JLabel("Skills");
		skills.setBounds(50, 375, 100, 20);
		
		doj=new JLabel("Date Of Joining");
		doj.setBounds(50, 405, 100, 20);
		
		
		emp=new JTextField();
		emp.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		emp.setEditable(false);
		emp.setBounds(150, 40, 200, 20);
		
	
		
		user=new JTextField();
		user.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		user.setBounds(150, 75, 200, 20);
		user.setEditable(false);

		pas=new JTextField();
		pas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		pas.setBounds(150, 105, 200, 20);
		pas.setEditable(false);

		fN=new JTextField();
		fN.setBounds(150, 140, 200, 20);
        fN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		fN.setEditable(false);

       LN=new JTextField();
		LN.setBounds(150, 175, 200, 20);
		LN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		LN.setEditable(false);

		Mo=new JTextField();
		Mo.setBounds(150, 210, 200, 20);
		Mo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		Mo.setEditable(false);
	
		DOB=new JTextField();
	    DOB.setBounds(150, 245, 200, 20);
		DOB.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		DOB.setEditable(false);
		
		gender=new JTextField();
		gender.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        gender.setEditable(false);
		gender.setBounds(150,280, 200, 20);
		


	//	G1 = new JComboBox(R2);
		//G1.setBounds(150, 240, 200, 20);
		

		ver=new JTextField();
		 ver.setBounds(150, 315, 200, 20);
		ver.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		ver.setEditable(false);
		
		role=new JTextField();
		role.setBounds(150, 345, 200, 20);
		role.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		role.setEditable(false);

		//C1.setBounds(50, 340, 100, 20);
		skil=new JTextField();
		skil.setBounds(150, 375 ,200, 20);
		skil.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		skil.setEditable(false);
		
		additionalSkills=new JButton("Additional Skills");
		additionalSkills.setBounds(355, 375, 125, 30);
		additionalSkills.addActionListener(this);
		

		joiningdate=new JTextField();
	    joiningdate.setBounds(150, 405, 200, 20);
		joiningdate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		
		joiningdate.setEditable(false);
		back=new JButton("Back");
		back.setBounds(100, 450, 200, 30);
		back.addActionListener(this);
		add(back);
		add(additionalSkills);
		add(empid);
		add(userid);
		add(password);
		add(FirstN);
		add(LastN);
		add(Mob);
        add(dob);
        add(vertical);
        add(crntR);
        add(skills);
        add(doj);
        add(role);
		add(emp);
		add(user);
		add(gen);
		add(gender);
		add(pas);
		add(fN);
		add(LN);
		add(Mo);
		add(DOB);
		add(crntR);
		add(ver);
		add(skil);
		add(joiningdate);
		
	setSize(500,600);
    setLayout(null);
    setVisible(true);
   
    ResultSet message= new EmployeeController().view();
    getContentPane().setBackground(Color.white);
		 
	try
	{
		 while(message.next())
		 {
			
			 
			 String empid=message.getString("Employee_ID");
			 emp.setText(empid);
			 String fname=message.getString("First_Name");
			
			 fN.setText(fname);
			 String Lname=message.getString("Last_Name");
			 LN.setText(Lname);
        	 
			 String userid=message.getString("User_ID");
			 user.setText(userid);
			 String pass=message.getString("Password");
			 pas.setText(pass);
			 String gen=message.getString("Gender");
			 gender.setText(gen);
			 String mobile=message.getString("Mobile");
			 Mo.setText(mobile);
			 
			 String dob=message.getString("DOB");
			 DOB.setText(dob);
			 String version=message.getString("vertical");
			 ver.setText(version);
			 String crnt=message.getString("Current_Role");
			 role.setText(crnt);
			 
			 String skill=message.getString("Skills");
			 skil.setText(skill);
			 String doj=message.getString("JoiningDate");
			 joiningdate.setText(doj);
			 
			 
			
			
		 }
	}
	catch(Exception e1)
	{
		e1.getStackTrace();
		
	}
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==back) {
		EmployeeWindow obj=new EmployeeWindow();
		obj.setVisible(true);
		this.hide();
		obj.mainEmp();
	}
		
		else if(e.getSource()==additionalSkills)
		{
			
			ShowSkills obj=new ShowSkills();
			obj.setVisible(true);
			this.hide();
			obj.EmpSkills();
		}

	}
}
