package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CommonClass;
import controller.EmployeeController;

public class JobDeactivate extends JFrame implements ActionListener{
	JButton button;
	JButton button1;
	JLabel label;
	//JPanel panel;
	static JTable table;
	static DefaultTableModel tableModel;
	ResultSet rs;
	JScrollPane sp;
public void deactivate() {
	setLayout(new BorderLayout());
	
	button1=new JButton("Deactive");
	
	//button.addActionListener(this);
	button1.addActionListener(this);	
	
	//add(button, BorderLayout.NORTH);
	add(button1, BorderLayout.SOUTH);
	button=new JButton("Back");
	button.addActionListener(this);

	add(button, BorderLayout.NORTH);

	
	table=new JTable();
	tableModel = new DefaultTableModel();
	
	
    setVisible(true);
	setSize(1000,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 rs=new EmployeeController().EmpJobsGenerated();
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
	
	 if(e.getSource()==button1)
		{
			
			System.out.println("Line1");
			 int row = table.getSelectedRow();
			 
			 System.out.println("Line3"+row);
				int column = table.getSelectedColumn();
				 System.out.println("Line4"+column);
				Object o = (Object)table.getValueAt(row, column);
				System.out.println(o.toString());
				
				String msg=new EmployeeController().deactivateJob(o.toString());
				 JOptionPane.showMessageDialog(button1, "Deactivate Job Successfully....");
				 tableModel.removeRow(row);
				 
					}

}



}   
