package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.CommonClass;
import controller.EmployeeController;

public class Empskill extends JFrame implements ActionListener {
	JButton Go,back;
JLabel set,img;
	JComboBox<?> C1;
	String R1[]= {"N/A","GIS","Oracle","SAP","Java","Unix",".Net","ERP","Cloud Computing"};
	

public void viewskill()
{       
	String path=new CommonClass().getImagePath();
	 img=new JLabel(new ImageIcon(path));
	img.setBounds(5,0,105,100);
	set=new JLabel ("**Select the skill you want to add**");
	set.setForeground(Color.BLUE);

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
      
      setSize(500,500);
      setLayout(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setBackground(Color.white);

		}


@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==Go) {
		 String skil=C1.getSelectedItem().toString();
		 String message= new EmployeeController().message(skil);

		 JOptionPane.showMessageDialog(Go, "Request generated");

	
	}

if(e.getSource()==back) {
	EmployeeWindow obj=new EmployeeWindow();
		obj.setVisible(true);
		this.hide();
		obj.mainEmp();
}
	}
}
