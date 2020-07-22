package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.CommonClass;
import controller.EmployeeController;

public class EmployeeWindow extends JFrame implements ActionListener{
	JButton view,deactive,update,skill,info;
	JLabel v1,u1,sk,la,img,apply;
    Date dt;
	public void mainEmp(){
	
		/* setLayout(new BorderLayout());
         la= new JLabel();
         la.setHorizontalAlignment(JLabel.CENTER);
         la.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 48f));
         la.setBounds(250, 10, 50,10);
         //tickTock();
         add(la);
*/
	dt=new Date();
	dt.getDate();
	la=new JLabel(dt.toLocaleString());
	la.setBounds(420, 50, 230, 10);
	//DateFormat dateFormatEn=DateFormat.getDateInstance(DateFormat.DEFAULT,locale01);
	//DateFormat timeFormatEn=DateFormat.getTimeInstance(DateFormat.DEFAULT,locale01);
	String path=new CommonClass().getImagePath();
	 img=new JLabel(new ImageIcon(path));
		img.setBounds(1,0,105,100);
		setTitle ("Employee Window");
		
		view=new JButton("view");
		view.setForeground(Color.BLUE);
		view.setBounds(200, 125, 180, 30);
		view.addActionListener(this);
		v1=new JLabel("(View your information)");
		v1.setForeground(Color.BLUE);
		v1.setBounds(230, 100, 280, 20);
		
		update=new JButton("Update");
		update.setForeground(Color.BLUE);
		update.setBounds(200, 191, 180, 30);
		update.addActionListener(this);
	u1=new JLabel("(Update your information)");
		u1.setForeground(Color.BLUE);
		u1.setBounds(220, 170, 280, 20);
		
		skill=new JButton("Bag a skill");
		skill.setForeground(Color.BLUE);
		skill.setBounds(200, 257, 180, 30);
		skill.addActionListener(this);
		sk=new JLabel("(Add your skills)");
		sk.setForeground(Color.BLUE);
		sk.setBounds(240, 235, 280, 20);
	
		info=new JButton("View/Apply");
		info.setForeground(Color.BLUE);
		info.setBounds(200, 323, 180, 30);
		info.addActionListener(this);
		apply=new JLabel("(View and apply for job)");
		apply.setForeground(Color.BLUE);
		apply.setBounds(220, 301, 280, 20);
		
		deactive=new JButton("Logout");
		deactive.setForeground(Color.BLUE);
		deactive.setBounds(480, 418, 80, 30);
		deactive.addActionListener(this);
	//	s1=new JLabel("Add your skills");
		
		
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		
		add(view);
		add(skill);
		add(deactive);
	    add(img);
		 
		
		add(v1);
	    add(u1);
		add(sk);
		add(la);
		add(apply);
        add(info);
		//JFrame.add(Locale);
	
		
		add(update);
	//	add(deactivate);
		setSize(600,600);
	    setLayout(null);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setBackground(Color.white);
	  
	}

	private void la(String string) {
		// TODO Auto-generated method stub
		
	}

	private void add(Date dt2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==update) {
			    EmpviewData obj=new EmpviewData();
				obj.setVisible(true);
				this.hide();
				obj.viewData();
				
				  
		   }
		 if(e.getSource()==deactive) {
			    LoginFrame obj=new LoginFrame();
				obj.setVisible(true);
				this.hide();
				obj.mainwindow();
				
				  
		   }
		 if(e.getSource()==skill) {
				
			    Empskill obj=new Empskill();
				obj.setVisible(true);
				obj.viewskill();
				this.hide();
		 }
		
		 if(e.getSource()==view) {
			
			    Empview obj=new Empview();
				obj.setVisible(true);
				obj.view();
				this.hide();
			
				 
				
				  
		   }
		 if(e.getSource()==info) {
				
			    Empjob obj=new Empjob();
				obj.setVisible(true);
				obj.Emjob();
				this.hide();
			
				 
				
				  
		   }
	}
	}
 

