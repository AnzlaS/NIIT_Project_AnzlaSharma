package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import controller.CommonClass;
import controller.EmployeeController;

public class Pmview extends JFrame implements ActionListener {
	 JLabel jobtitle,jobd,cmpnyame,loc,skil,sal,form,img;
	  JButton but,back;
	  JTextField tit,jd,cn,location,skill,salary;

	  public void mainpm()
	  {
		  String path=new CommonClass().getImagePath();
			 img=new JLabel(new ImageIcon(path));
				img.setBounds(1,0,105,100);
		  
		  setTitle("Project Manager Window");
		  form =new JLabel("Form For Adding Job");
		  form.setBounds(200, 50, 300, 30);
		  form.setForeground(Color.BLUE);
		  
		  jobtitle=new JLabel("Job Title");
		  jobtitle.setBounds(50, 110, 100, 20);
		  tit=new JTextField();
		  tit.setBounds(150, 110, 200, 20);
		  tit.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		  
		  jobd=new JLabel("Job Discription");
		  jobd.setBounds(50, 140, 100, 20);
		  jd=new JTextField();
		  jd.setBounds(150, 140, 200, 20);
		  jd.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		  
		  cmpnyame=new JLabel("Company Name");
		  cmpnyame.setBounds(50, 175, 100, 20);
		  cn=new JTextField();
		  cn.setBounds(150, 175, 200, 20);
		  cn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		  
		 loc=new JLabel("Location");
		  loc.setBounds(50, 210, 100, 20);
		  location=new JTextField();
		  location.setBounds(150, 210, 200, 20);
		  location.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		  
		  skil=new JLabel("Skills");
		  skil.setBounds(50, 240, 100, 20);
		  skill=new JTextField();
		  skill.setBounds(150, 240, 200, 20);
		  skill.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		  
		  sal=new JLabel("Salary");
		  sal.setBounds(50, 275, 100, 20);
		  salary=new JTextField();
		  salary.setBounds(150, 275, 200, 20);
		  salary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		  
		  but=new JButton("Add job");
		  but.setBounds(80, 350, 100, 20);
		  but.addActionListener(this);
		  
		  back=new JButton("Back");
		  back.setBounds(250, 350, 100, 20);
		  back.addActionListener(this);
		 
		  add(but);
		  add(back);
		  add(jobtitle);
		  add(jobd);
		  add(cmpnyame);
		  add(loc);
		  add(skil);
		  add(sal);
		  add(tit);
		  add(jd);
		  add(cn);
		  add(location);
		  add(skill);
		  add(salary);
          add(img);
          add(form);
          getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
	      
	      setSize(500,500);
	      setLayout(null);
	      setVisible(true);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      getContentPane().setBackground(Color.white);
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=null;
		String title=tit.getText();
	    String des=jd.getText();
	    String name=cn.getText();
	  
	    String lock=location.getText();
	   
	    String skl=skill.getText();
	    String sall=salary.getText();
	 //  
	   if(e.getSource()==but)
	   {
		  String message= new EmployeeController().frm(title, des, name, lock, skl, sall );
	   }
		if(e.getSource()==back) {
			PMEHome obj=new PMEHome();
			obj.setVisible(true);
			this.hide();
			obj.mainpm();
		}
		
		
	}

	}


