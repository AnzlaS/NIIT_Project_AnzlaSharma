package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import controller.EmployeeController;

public class ChangePassword extends JFrame implements ActionListener{
	 JTextField textField;
     JLabel NewPassword;
    JButton btnSearch;

public void mainpass() {

	 setTitle("Update Window");
   NewPassword = new JLabel("New Password");
   NewPassword.setBounds(50, 30, 180, 20);
   
   textField = new JTextField();
   textField.setBounds(150, 30, 180, 20);
   textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
   
    btnSearch = new JButton("Update");
    btnSearch.setBounds(320, 30, 180, 20);
    btnSearch.addActionListener(this);
   
     add(textField);
     add(NewPassword);
     add(btnSearch);
     getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
     
     setSize(600,500);
     setLayout(null);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e) {
	
	
	String pass=textField.getText();
	String message= new EmployeeController().Empupdate(pass);


	
	if(e.getSource()==btnSearch)
	   {
		 JOptionPane.showMessageDialog(btnSearch, "Data successfully updated");
		    EmployeeWindow log=new EmployeeWindow();
			 log.setVisible(true);
			 this.hide();
				log.mainEmp();
	        // log.setVisible(true);
	        }
}
}
