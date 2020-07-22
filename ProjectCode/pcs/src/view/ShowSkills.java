package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CommonClass;
import controller.EmployeeController;

public class ShowSkills extends JFrame implements ActionListener{
	
	
	JButton button;
	
	JLabel label;
	//JPanel panel;
	static JTable table;
	static DefaultTableModel tableModel;
	ResultSet rs;
	JScrollPane sp;
public void EmpSkills() {
	setLayout(new BorderLayout());
	
	
	
	//add(button, BorderLayout.NORTH);
	
	button=new JButton("Back");
	button.addActionListener(this);

	add(button, BorderLayout.NORTH);

	
	table=new JTable();
	tableModel = new DefaultTableModel();
	
	
    setVisible(true);
	setSize(1000,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 rs=new EmployeeController().EmpSkills();
	 sp=new JScrollPane(table);
	 table=new CommonClass().FillTable(rs,tableModel,table);
	 
	 sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
     sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
 		add(sp, BorderLayout.CENTER);
 		
 	setVisible(true);
   
	 System.out.println(tableModel.getRowCount());
	
	}
public void actionPerformed(ActionEvent e) {
	

	if(e.getSource()==button) {
		//Toolkit tab=table.getToolkit();
		PMEHome obj=new PMEHome();
		obj.setVisible(true);
		this.hide();
		obj.mainpm(); 
	}
	

 
 }
}
