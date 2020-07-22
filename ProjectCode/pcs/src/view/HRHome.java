package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.CommonClass;

public class HRHome extends JFrame implements ActionListener{
	JButton view,deactive,update,act,deactivate,job;
	JLabel img,la,v1,u1,a1,d1,j1;
	Date dt;
	public void mainHr(){
		dt=new Date();
		dt.getDate();
		la=new JLabel(dt.toLocaleString());
		la.setBounds(420, 50, 230, 10);
		
		String path=new CommonClass().getImagePath();
		 img=new JLabel(new ImageIcon(path));
			img.setBounds(1,0,105,100);
			setTitle ("HR Window");
		
		view=new JButton("view records");
		view.setForeground(Color.BLUE);
		view.setBounds(200, 120, 180, 30);		
		view.addActionListener(this);
		v1=new JLabel("(View Employee's record)");
		v1.setForeground(Color.BLUE);
		v1.setBounds(220, 100, 280, 10);
		
		update=new JButton("Activate skills");
		update.setForeground(Color.BLUE);
		update.setBounds(200, 186, 180, 30);
		update.addActionListener(this);
	u1=new JLabel("(Activate Skills of Employee)");
		u1.setForeground(Color.BLUE);
		u1.setBounds(220, 170, 280, 10);
		
		act=new JButton("Activate Employee");
		act.setForeground(Color.BLUE);
		act.setBounds(200, 252, 180, 30);
		act.addActionListener(this);
		a1=new JLabel("(Activate new Employee)");
		a1.setForeground(Color.BLUE);
		a1.setBounds(220, 235, 280, 10);
		
		
		deactivate=new JButton("Deactivate");
		deactivate.setForeground(Color.BLUE);
		deactivate.setBounds(200,318, 180, 30);
		deactivate.addActionListener(this);	
		d1=new JLabel("(Deactivate)");
		d1.setForeground(Color.BLUE);
		d1.setBounds(250, 300, 280, 10);
		
		job=new JButton("Activate job");
		job.setForeground(Color.BLUE);
		job.setBounds(200, 384, 180, 30);
		job.addActionListener(this);
		j1=new JLabel("(Activate new jobs)");
		j1.setForeground(Color.BLUE);
		j1.setBounds(250, 366, 280, 10);
		
		
		
	    deactive=new JButton("Logout");
		deactive.setForeground(Color.BLUE);
		deactive.setBounds(480, 418, 80, 30);
		deactive.addActionListener(this);
		
		
		
		
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		
		add(view);
		add(job);
		add(j1);
		add(deactive);
		add(update);
		add(img);
		add(la);
		add(v1);
		add(a1);
		add(act);
		add(u1);
		add(d1);
		add(deactivate);
		setSize(600,600);
	    setLayout(null);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setBackground(Color.white);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==view) {
			    HRview obj=new HRview();
				obj.setVisible(true);
				this.hide();
				obj.view();
				
       }
		 if(e.getSource()==update) {
			    Hrskil obj=new Hrskil();
				obj.setVisible(true);
				this.hide();
				obj.skil();
				
		 }
		 if(e.getSource()==deactivate) {
			    DeactivateEmp obj=new DeactivateEmp();
				obj.setVisible(true);
				this.hide();
				obj.deactiveEmp();
				
				  
		   }
		 if(e.getSource()==deactive) {
			   LoginFrame obj=new LoginFrame();
				obj.setVisible(true);
				this.hide();
				obj.mainwindow();
				
				  
		   }
		 if(e.getSource()==job) {
			   alljob obj=new alljob();
				obj.setVisible(true);
				this.hide();
				obj.jobs();
				
				  
		   }
		 if(e.getSource()==act) {
			   ActivateEmp obj=new ActivateEmp();
				obj.setVisible(true);
				this.hide();
				obj.activeEmp();
				
				  
		   }
	
	}
}
