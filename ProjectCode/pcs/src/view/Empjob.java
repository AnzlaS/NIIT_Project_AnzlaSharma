package view;



	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.util.Vector;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.table.TableCellRenderer;
	import javax.swing.table.TableColumn;
	import javax.swing.table.TableModel;


import controller.CommonClass;
	import controller.EmployeeController;
	public class Empjob extends JFrame implements ActionListener{
	
		JButton button;
		JButton btnApply;
		JLabel label;
		//JPanel panel;
		static JTable table;
		static DefaultTableModel tableModel;
		ResultSet rs;
		JScrollPane sp;
	public void Emjob() {
		setTitle ("View/Apply or Job");
		setLayout(new BorderLayout());
		
		btnApply=new JButton("Apply");
		
		//button.addActionListener(this);
		btnApply.addActionListener(this);	
		
		//add(button, BorderLayout.NORTH);
		add(btnApply, BorderLayout.SOUTH);
		button=new JButton("Back");
		button.addActionListener(this);

		add(button, BorderLayout.NORTH);

		
		table=new JTable();
		tableModel = new DefaultTableModel();
		
		
	    setVisible(true);
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 rs=new EmployeeController().job();
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
			EmployeeWindow obj=new EmployeeWindow();
			obj.setVisible(true);
			this.hide();
			obj.mainEmp(); 
		}
		
	 if(e.getSource()==btnApply) 
		{
											
					//String msg=new EmployeeController().jobshr("hello");
				
		String Job_id=(String) table.getValueAt(table.getSelectedRow(),0);
			 System.out.println("seected col=" +Job_id);
					 
						
			 String msgg=new EmployeeController().jobshr(Job_id);
			 if(msgg!=null)
				 JOptionPane.showMessageDialog(btnApply,"Applied Sucessfully");
			 tableModel.removeRow(table.getSelectedRow());
		}
	 }
	 

	public JTable FillTable(ResultSet rs,DefaultTableModel tableModel, JTable table)
	{
		
	    try
	    {
	    	
	        sp=new JScrollPane(table);
	      
	    
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
	    	//sp.add(table);
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
	//vectordata=getData_polleddetailspanel();

		sp.invalidate();
	sp.validate();
	sp.repaint();

	table.invalidate();
	table.validate();
	table.setRowSelectionAllowed(true);
	table.repaint();
	}
		

	   

}

