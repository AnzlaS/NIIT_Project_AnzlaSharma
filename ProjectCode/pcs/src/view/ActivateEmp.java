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

public class ActivateEmp extends JFrame implements ActionListener{
	JButton button;
	JButton button1;
	JLabel label;
	//JPanel panel;
	static JTable table;
	static DefaultTableModel tableModel;
	ResultSet rs;
	JScrollPane sp;
public void activeEmp() {
	setLayout(new BorderLayout());
	
	button1=new JButton("Set Active");
	
	
	button1.addActionListener(this);	
	add(button1, BorderLayout.SOUTH);
	button=new JButton("Back");
	button.addActionListener(this);

	add(button, BorderLayout.NORTH);

	
	table=new JTable();
	tableModel = new DefaultTableModel();
	
	
    setVisible(true);
	setSize(1000,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 rs=new EmployeeController().activate();
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
		HRHome obj=new HRHome();
		obj.setVisible(true);
		this.hide();
		obj.mainHr(); 
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
				
				String msg=new EmployeeController().SetSkillActive(o.toString());
				 JOptionPane.showMessageDialog(button1, "Skill Approved");
				 tableModel.removeRow(row);
				 
					}

}

public JTable FillTable(ResultSet rs,DefaultTableModel tableModel, JTable table)
{
	
    try
    {
    	
        sp=new JScrollPane(table);
        label=new JLabel("*Select Skill ID to Activate the skill");
        label.setBounds(10, 20, 200, 30);
    
       ResultSetMetaData mdata = rs.getMetaData();
        int columns = rs.getMetaData().getColumnCount();
       // System.out.println(columns);
        String[] colNames = new String[columns];
        for (int i = 1; i <= columns; i++) {
            colNames[i - 1] = mdata.getColumnName(i);
          }
        
        tableModel.setColumnIdentifiers(colNames);
     
        while(rs.next())
        {  
        	String[] rowData = new String[columns];
          //  Object[] row = new Object[columns];
            
        	for (int i = 1; i <= columns; i++)
            {  
        		 rowData[i - 1] = rs.getString(i);
            }
                	
        	tableModel.addRow(rowData);
            	
        }
    
        table.setModel(tableModel); 
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
    	
    	add(sp, BorderLayout.CENTER);
    	//sp.setOpaque(true);
    	add(label);
    	setVisible(true);
        rs.close();
        getContentPane().setBackground(Color.white);
    }
    catch(Exception e1)
    {
    }
    return table;
	   
	    }
public void refreshTable()
{


	sp.invalidate();
sp.validate();
sp.repaint();

table.invalidate();
table.validate();
table.setRowSelectionAllowed(true);
table.repaint();
}
	

}   


