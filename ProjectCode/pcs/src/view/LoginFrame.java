package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import controller.CommonClass;
import controller.EmployeeController;

public class LoginFrame  extends JFrame implements ActionListener{


    JFrame fr=new JFrame("Login page");
	JLabel Lhead, Luser,Lpass,LRole,lMessage,log,background,img;
	ImageIcon logo;
	JTextField Tuser;
	JPasswordField Tpass;
	JPanel p;
	
	JComboBox<?> C1;
	JButton Blogin;
	static JButton Rlogin;
	String R1[]= {"N/A","EMP","HR","PM"};
//	JLabel img=new JLabel(new ImageIcon("file:///E:/New%20Folder%20(2)/pcs/src/view/imagesource/desk.jpg"));
	
	

	
	public void mainwindow() 
	{
		
		//ImageIcon background_image = new ImageIcon("file:/E:/New%20Folder%20(2)/imagesource/desk.jpg"); 
		  //background = new JLabel("",background_image,JLabel.RIGHT);
		  //background.setBounds(50,30,10,10);
		  
	        // create a label to display image 
		  
		
	//	 g.setColor=(Color,blue);
		String path=new CommonClass().getImagePath();
		 img=new JLabel(new ImageIcon(path));
		img.setBounds(5,0,105,100);
		Lhead = new JLabel("Login Here");
		//log.setBounds(10,20, 50, 20);
		Lhead.setForeground(Color.BLUE);
		Lhead.setBounds(200,20,350,200);
	
		Luser = new JLabel("User ID ");
		Luser.setBounds(70,145,100,30);
		Tuser=new JTextField ();
		Tuser.setBounds(150,150,180,20);
		Tuser.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		
		Lpass = new JLabel("Password ");
		Lpass.setBounds(70,180,100,30);
		Tpass=new JPasswordField ();
		Tpass.setBounds(150,185,180,20);
		Tpass.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		
		LRole = new JLabel("Role ");
		LRole.setBounds(70, 220, 100, 30);
		
		
		C1 = new JComboBox(R1);
		C1.setBounds(150, 225, 180, 20);
		Blogin=new JButton ("LOGIN");
		Blogin.setForeground(Color.BLUE);
		Blogin.setBounds(70, 340, 100, 20);
		
		Rlogin=new JButton ("REGISTRATION");
		
		Rlogin.setForeground(Color.BLUE);
		Rlogin.setBounds(200, 340, 120, 20);
		Rlogin.addActionListener(this);
		
		Blogin.addActionListener(this);
		lMessage=new JLabel();
		lMessage.setBounds(70, 280, 180, 20);
		lMessage.setForeground(Color.RED);
		
         add(Lhead);
         add(Luser);
         add(Tuser);
         add(Lpass);
         add(Tpass);
        add(LRole);
         add(Tpass);
         add(C1);
         add(Blogin);
         add(Rlogin);
       add(lMessage);
    // add(background);
        add(img);
       
      
         getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
       
         setSize(500,500);
         setLayout(null);
        
       
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setBackground(Color.white);
	}
	
	
public void actionPerformed(ActionEvent e) {
	
	
		if(e.getSource()==Blogin) {
				String id=Tuser.getText();
				String pass=Tpass.getText();
			    String role=C1.getSelectedItem().toString();
			    
			   String message= new EmployeeController().Login(id,pass,role);
			   if(message==null)
			   {
				   lMessage.setText("Sorry!wrong entry!");
				   
			   }
			   else if(role==("EMP"))
			   {
				 EmployeeWindow emp=new EmployeeWindow();
				 emp.setVisible(true);
				  this.hide();
				  emp.mainEmp();
				  
			   }
		
		
		
			   else if(role.equals("PM")){
					PMEHome phome=new PMEHome();
					phome.setVisible(true);
					this.hide();
					phome.mainpm();
				}
				else if(role.equals("HR")){
					
					HRHome hr=new HRHome();
					hr.setVisible(true);
					this.hide();
					hr.mainHr();
				}
			   
		}		
	   if(e.getSource()==Rlogin) {
			dispose();
			
			registration_form obj=new registration_form();
			obj.setVisible(true);
			obj.main_reg();

	   }
		
	  
	  
	 
		}
}
  
		


	
		
		
	

		
		




