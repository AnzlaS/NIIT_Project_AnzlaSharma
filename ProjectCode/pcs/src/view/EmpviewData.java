package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import controller.CommonClass;
import controller.EmployeeController;




public class EmpviewData extends JFrame implements ActionListener {
	JButton Go,back;
JLabel set,img;
	JComboBox<?> C1;
	String R1[]= {"N/A","Password","Mobile","Skills"};
	

public void viewData()

{
	String path=new CommonClass().getImagePath();
	 img=new JLabel(new ImageIcon(path));
	img.setBounds(5,0,105,100);
	set=new JLabel ("**Select what you want to update**");
	set.setBounds(150, 100, 280, 40);
		Go=new JButton("Go");
		Go.setBounds(320,150,80,20);
		back=new JButton("Back");
		back.setBounds(200,200,80,20);
		C1 = new JComboBox (R1);
	C1.setBounds(150, 150, 180, 20);
	 add(C1);
	 add(set);
     add(Go);
     add (back);
     add(img);
     Go.addActionListener(this);
     back.addActionListener(this);

	 getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
	 getContentPane().setBackground(Color.white);
      
      setSize(500,500);
      setLayout(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Go) {
			 String role=C1.getSelectedItem().toString();
			
			if(role==("Password"))
			{
		     ChangePassword obj=new ChangePassword();
				obj.setVisible(true);
				this.hide();
				obj.mainpass();
		}
			if(role==("Mobile"))
			{
		     ChangeMobile obj=new ChangeMobile();
				obj.setVisible(true);
				this.hide();
				obj.mainmobile();
		}
			if(role==("Skills"))
			{
		     Changeskills obj=new Changeskills();
				obj.setVisible(true);
				this.hide();
				obj.mainskill();
		}
	    }
			if(e.getSource()==back) {
				EmployeeWindow obj=new EmployeeWindow();
					obj.setVisible(true);
					this.hide();
					obj.mainEmp();
			}
			}
}
