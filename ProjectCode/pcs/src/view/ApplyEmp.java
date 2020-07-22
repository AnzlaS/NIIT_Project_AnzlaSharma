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
	public class ApplyEmp extends JFrame implements ActionListener{
	
		JButton button;
		
		JLabel label;
		//JPanel panel;
		static JTable table;
		static DefaultTableModel tableModel;
		ResultSet rs;
		JScrollPane sp;
	public void Emp() {
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
		
		 rs=new EmployeeController().AppliedJob();
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

