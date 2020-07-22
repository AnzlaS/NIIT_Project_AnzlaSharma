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

public class PMEHome extends JFrame implements ActionListener{
	JButton view,deactive,update,act,deactivate,dejob;
	JLabel img,la,v1,u1,a1,d1,j1;
	Date dt;
	public void mainpm(){
		dt=new Date();
		dt.getDate();
		la=new JLabel(dt.toLocaleString());
		la.setBounds(420, 50, 230, 10);
		
		String path=new CommonClass().getImagePath();
		 img=new JLabel(new ImageIcon(path));
			img.setBounds(1,0,105,100);
			setTitle ("Manager Window");
		
		view=new JButton("Add Job");
		view.setForeground(Color.BLUE);
		view.setBounds(200, 120, 180, 30);		
		view.addActionListener(this);
		v1=new JLabel("(Add new job for employee's)");
		v1.setForeground(Color.BLUE);
		v1.setBounds(210, 100, 280, 20);
		
		update=new JButton("(View skills)");
		update.setForeground(Color.BLUE);
		update.setBounds(200, 191, 180, 30);
		update.addActionListener(this);
	u1=new JLabel("(View Skills of Employee)");
		u1.setForeground(Color.BLUE);
		u1.setBounds(220, 170, 280, 20);
		
		act=new JButton("View posted jobs");
		act.setForeground(Color.BLUE);
		act.setBounds(200, 257, 180, 30);
		act.addActionListener(this);
		a1=new JLabel("(View all posted jobs)");
		a1.setForeground(Color.BLUE);
		a1.setBounds(220, 235, 280, 20);
		
		
		deactivate=new JButton("Applied Candidate");
		deactivate.setForeground(Color.BLUE);
		deactivate.setBounds(200,323, 180, 30);
		deactivate.addActionListener(this);	
		d1=new JLabel("(Employee applied for the job)");
		d1.setForeground(Color.BLUE);
		d1.setBounds(210, 300, 280, 20);
		
		dejob=new JButton("Deactivate Job");
		dejob.setForeground(Color.BLUE);
		dejob.setBounds(200,389, 180, 30);
		dejob.addActionListener(this);	
		j1=new JLabel("(Remove the job)");
		j1.setForeground(Color.BLUE);
		j1.setBounds(230, 365, 280, 20);
		
		
	    deactive=new JButton("Logout");
		deactive.setForeground(Color.BLUE);
		deactive.setBounds(480, 438, 80, 30);
		deactive.addActionListener(this);
		
		
		
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		
		
		//add(skill);
		add(view);
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
		add(j1);
		add(dejob);
	//	add(deactivate);
		setSize(600,600);
	    setLayout(null);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setBackground(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==view) {
			    Pmview obj=new Pmview();
				obj.setVisible(true);
				this.hide();
				obj.mainpm();
				
				  
		   }
		 if(e.getSource()==update) {
			   Pmviewskil obj=new Pmviewskil();
				obj.setVisible(true);
				this.hide();
				obj.allskill();
				
				  
		   }
		 if(e.getSource()==act) {
				
			   Pmallskills obj=new Pmallskills();
				obj.setVisible(true);
				this.hide();
				obj.pmskill();
		 }
		
		 if(e.getSource()==deactivate) {
			
			    ApplyEmp obj=new ApplyEmp();				
				obj.Emp();
				obj.setVisible(true);
				this.hide();
			  }
		/* if(e.getSource()==act) {
				
			    Pactivejob obj=new Pactivejob();
				obj.setVisible(true);
				obj.active();
				this.hide();
			  }*/
		 if(e.getSource()==deactive) {
				
			    LoginFrame obj=new LoginFrame();
				obj.setVisible(true);
				obj.mainwindow();
				this.hide();
			  }
		 
		 if(e.getSource()==dejob) {
				
			    JobDeactivate obj=new JobDeactivate();
				obj.setVisible(true);
			obj.deactivate();
			this.hide();
			  }
	}
	}
 

