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
	public class alljob  extends JFrame implements ActionListener{
	
		JButton button;
		JButton button1;
		JLabel label;
		//JPanel panel;
		static JTable table;
		static DefaultTableModel tableModel;
		ResultSet rs;
		JScrollPane sp;
	public void jobs() {
		setLayout(new BorderLayout());
		
		button1=new JButton("Assign Job");
		
		
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
		
		 rs=new EmployeeController().JobsToActivate();
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
		
	 if(e.getSource()==button1) {
		{
				
				System.out.println("Line1");
				 int row = table.getSelectedRow();
				 
				 System.out.println("Line3"+row);
					int column = table.getSelectedColumn();
					 System.out.println("Line4"+column);
					Object o = (Object)table.getValueAt(row, column);
					System.out.println(o.toString());
					String id=(String) table.getValueAt(table.getSelectedRow(),0);
					 System.out.println("seected col=" +id);
					
					String msg=new EmployeeController().jobRecruited(id);
				//	 JOptionPane.showMessageDialog(button1, "");
					 tableModel.removeRow(row);
					 
						
			 JOptionPane.showMessageDialog(button1, "Assigned Successfully");
			 String msgg=new EmployeeController().SetSkillActive(o.toString());
		}
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



