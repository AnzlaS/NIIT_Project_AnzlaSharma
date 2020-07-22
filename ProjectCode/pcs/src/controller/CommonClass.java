package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CommonClass {
	
	public String getImagePath()
			{
			String path="E:\\New Folder (2)\\desk1.jpg";
			return path;
			}
	 
	public JTable FillTable(ResultSet rs,DefaultTableModel tableModel, JTable table)
	{
		
	    try
	    {
	    	table.getTableHeader().setBackground(Color.orange);
	    	table.getTableHeader().setForeground(Color.black);
	    	table.setForeground(Color.black);
	        table.setBackground(Color.WHITE);
	        table.setRowSelectionAllowed(true);
	  
	        ResultSetMetaData mdata = rs.getMetaData();
	        int columns = rs.getMetaData().getColumnCount();
	        String[] colNames = new String[columns];
	        for (int i = 1; i <= columns; i++) {
	            colNames[i - 1] = mdata.getColumnName(i);
	          }
	        tableModel.setColumnIdentifiers(colNames);
	     
	        while(rs.next())
	        {  
	        	String[] rowData = new String[columns];
	                     
	        	for (int i = 1; i <= columns; i++)
	            {  
	        		 rowData[i - 1] = rs.getString(i);
	            }
	                  	
	        	tableModel.addRow(rowData);
	        	
	        	}
	      	        table.setModel(tableModel); 
	               rs.close();
	       
	    }
	    catch(Exception e1)
	    {
	    }
	    return table;
		   
		    }
}
