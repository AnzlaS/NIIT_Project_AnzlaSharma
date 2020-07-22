package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.EmployeeController;

public class HRview extends JFrame implements ActionListener {

	
	JButton button;
	JPanel panel;
	JTable table;
	JScrollPane pane;
public void view()
{

	setLayout(new BorderLayout());
button=new JButton("Back");
button.addActionListener(this);

add(button, BorderLayout.NORTH);

setSize(1000,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ResultSet rs=new EmployeeController().tab();
System.out.println(rs);
FillTable(rs);

}
@Override
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource()==button) {
		//Toolkit tab=table.getToolkit();
		HRHome obj=new HRHome();
		obj.setVisible(true);
		this.hide();
		obj.mainHr(); 
	}
	
	/*ResultSet rs=new EmployeeController().tab();
	System.out.println(rs);
	FillTable(rs);*/
	getContentPane().setBackground(Color.white);
}
public void FillTable(ResultSet rs)
{
	
    try
    {
    	 JTable table=new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        JScrollPane sp=new JScrollPane(table);
        table.getTableHeader().setBackground(Color.orange);
    	table.getTableHeader().setForeground(Color.black);
    	table.setForeground(Color.black);
        table.setBackground(Color.WHITE);
    
       ResultSetMetaData mdata = rs.getMetaData();
        int columns = rs.getMetaData().getColumnCount();
        System.out.println(columns);
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
            //((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
        	
        	tableModel.addRow(rowData);
        	
        	//sp.setBounds(60, 50,169,20);
        	
        	//add(table);
        }
       // table.setModel( ((Object) rs).ResultSetToTableModel());
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
    	//sp.add(table);
    	add(sp, BorderLayout.CENTER);
    	setVisible(true);
        rs.close();
       
    }
    catch(Exception e1)
    {
    }
}



}
