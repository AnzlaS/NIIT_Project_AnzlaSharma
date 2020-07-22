package controller;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.connection;
import model.Employee;
import model.Pmjob;
import modelskill.skill;
import view.Empskill;
import view.registration_form;

public class EmployeeController {

static String uId=null;

	public String Login(String id,String pass,String role)
	{
		int i=0;
	String message=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement("select USER_ID,Password,Current_Role from Empdata where Active='true' and User_ID=? and Password=? and Current_Role=?" );
		  
		   st.setString(1,id);
		   uId=id;
		   st.setString(2,pass);
		   st.setString(3,role);
		 
		  
		   ResultSet rs=st.executeQuery();
		    if(rs.next())
		   {
		    	message="welcome";	
		   }
		    System.out.println(message);
		    }
		 
		   catch(ClassNotFoundException e)
		  {
			   System.out.println(e);
		  }
		  catch(SQLException e)
		  {
	System.out.println(e);
}
		  return message;
	}
	
	public String save(String fN1,String LN1,String user1,String pas1,String gender1,String Mo1,String DOB1,String ver1,String crntR11,String skil1,String joiningdate1,String active) {
		String msg=null;
		int retVal=0;
		
		//registration_form reg=new registration_form();
		Employee emp=new Employee(fN1,LN1,user1,pas1,gender1,Mo1,DOB1,ver1,crntR11,skil1,joiningdate1);
		 try
		    {
			  Connection con=connection.getDBConnection();
		  PreparedStatement st=con.prepareStatement("insert into Empdata(First_Name,Last_Name,User_Id,Password,Gender,Mobile,DOB,vertical,Current_Role, Skills, JoiningDate,active) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		   
		//   st.setString(12,Active);
		  st.setString(1,emp.getFirstName());
		  st.setString(2,emp.getLastName());
		  st.setString(3,emp.getUserId());
		  st.setString(4,emp.getPassword());
		  st.setString(5,emp.getGender());
		  st.setString(6,emp.getMobile());
		  st.setString(7,emp.getDOB());
		  st.setString(8,emp.getUserId());
		  st.setString(9,emp.getCurrentRole());
		  st.setString(10,emp.getSkills());
		  st.setString(11,emp.getDOJ());
		  
		   st.setString(12,active);
		 
		   retVal=st.executeUpdate();
				  
			if(retVal==1)
			{
				msg="record updated";
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
		
	}


	public String Empupdate(String pass)
	{
		
	String message=null;
	

		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement("Update Empdata set Password=? where user_id=?" );
		   st.setString(1, pass);
		   st.setString(2, uId);
		  
		   int retVal = st.executeUpdate();
		   if(retVal==1)
			{
				message="record updated";
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
		
	}
	public String Empmob(String num)
	{
		
	String message=null;

		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement("Update Empdata set Mobile=?" );
		   st.setString(1, num);
		 //  st.setString(2, User ID);
		   int retVal = st.executeUpdate();
		   if(retVal==1)
			{
				message="record updated";
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
		
	}

	public String Empskil(String skil) {
		
		String message=null;
		Employee emp=new Employee();
		String id=null;

		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement("Update Empdata set Skills=?" );
		   st.setString(1, skil);
		  // st.setString(2, emp.getUserId());
		  
		  
		   int retVal = st.executeUpdate();
		   if(retVal==1)
			{
				message="record updated";
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
	}
	
	public ResultSet view()
	{
		
	//String message=null;
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select * from Empdata where User_Id='" + uId+"'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	
	public ResultSet tab()
	{
		
		ResultSet rs=null;
	Employee emp=new Employee();

		  try
		    {
		  Connection con=connection.getDBConnection();
		   String query=("select * from Empdata");
		   PreparedStatement st=con.prepareStatement(query);
		    rs=st.executeQuery();
		   return rs;
}
		  catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return rs;
		  
	}
	public String message(String skil) {
		String msg=null;
		int retVal=0;
		
				 try
		    {
			  Connection con=connection.getDBConnection();
		  PreparedStatement st=con.prepareStatement("insert into Empskill(User_ID,skills) values(?,?) ");
		   
		  st.setString(1,uId);
		  st.setString(2,skil);
		 
		   retVal=st.executeUpdate();
			System.out.println("uid"+uId +"skill" + skil);	  
			if(retVal==1)
			{
				msg="record updated";
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
		
	}
	public ResultSet tab1()
	{
		
	//String message=null;
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select skill_id,es.user_id, first_name+' '+last_name name,es.skills from Empskill es,empdata e where es.user_id = E.user_id and approve='false'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	

	public String SetSkillActive(String skill_Id)
	{
		
	String message=null;
	

		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement("Update Empskill set approve='true' where skill_Id='" + skill_Id +"'" );
		  		  
		   int retVal = st.executeUpdate();
		   if(retVal==1)
			{
				message="record updated";
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
		
	}

	public String frm(String title, String des, String name,String  lock,String skl,String sall) {
		String msg=null;
		int retVal=0;
		
		//registration_form reg=new registration_form();
		Pmjob emp=new Pmjob(title,des,name,lock,skl,sall);
		System.out.print(emp.getJobId());
		 try
		    {
			  Connection con=connection.getDBConnection();
		  PreparedStatement st=con.prepareStatement("insert into Empjob( Job_Id,Jobtitle,jobDescription,companyName,keySkill,salary,loc) values(?,?,?,?,?,?)");
		   
		//   st.setString(12,Active);
		  st.setString(1,emp.getJobId());
		  st.setString(2,emp.getTitle());
		  st.setString(3,emp.getDiscription());
		  st.setString(4,emp.getCmpnyName());
		  st.setString(5,emp.getSkills());
		  st.setString(6,emp.getSall());
		  st.setString(7,emp.getLocation());
		
		   retVal=st.executeUpdate();
				  
			if(retVal==1)
			{
				msg="record updated";
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
		
	}
	public ResultSet tabskill()
	{
		//String message=null;
		ResultSet rs=null;
		
			  try
			    {
			  Connection con=connection.getDBConnection();
			   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select Employee_Id,First_Name ,Last_Name,Skills from Empdata where Active='True'");
			  		  
			    rs = st.executeQuery();
			   return rs;
			}
			catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return rs;
			
		}	
	
	
	public ResultSet job()
	{
		
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select Job_id, Jobtitle, jobDescription ,companyName,keySkill,salary,loc from Empjob where Active='True'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	
	public ResultSet fill()
	{
		
	//String message=null;
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("insert into jobId,empId from job where empid=uId values(?,?)");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	
	public String jobshr(String jobId)
	{
		
	String message=null;
	int retVal=0;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("insert into job(empid,job_id)values(?,?)");
		   st.setString(1, uId);
		   st.setString(2, jobId);
		   
		  		  
		   retVal = st.executeUpdate();
		   if(retVal==1)
			   message="sucess";
		   return message;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
		
	}	
	public ResultSet allskil()
	{
		
	//String message=null;
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select jobId,empId from job where recruited='false'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	
	public String jobRecruited(String id) 
	{
		String message=null;  
		try
	    {
	  Connection con=connection.getDBConnection();
	   PreparedStatement st=(PreparedStatement)con.prepareStatement("Update job set recruited='Recruited' where id=?" );
	   st.setString(1, id);
	    
	   int retVal = st.executeUpdate();
	   if(retVal==1)
		{
			message="record updated";
		}
		
	}
	catch(ClassNotFoundException e) {
		System.out.println(e.getMessage());
		
	}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	return message;
	}
	
	public ResultSet JobsToActivate()
	{
		
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select id,empid,job_id from job where recruited=''");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	
	public ResultSet deactive()
	{
		
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select * from Empdata where Active='true'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	
	public ResultSet activate()
	{
		
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select * from Empdata where Active='false'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}	
	public ResultSet seeskill()
	{
		
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select Job_id, Jobtitle, jobDescription ,companyName,keySkill,salary,loc from Empjob where Active='True'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}
	public ResultSet AppliedJob()
	{
		
	
		ResultSet rs=null;
		
			  try
			    {
			  Connection con=connection.getDBConnection();
			   PreparedStatement st=(PreparedStatement)con.prepareStatement	("\r\n" + 
			   		"select first_name +' ' + last_name Name, j.empid,j.job_id,jobDescription from job j, empdata e, empjob ej where e.user_id=j.empid and j.job_id=ej.job_id ");
			  		  
			    rs = st.executeQuery();
			   return rs;
			}
			catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return rs;
			
	}
	
	public String deactivateJob(String id) 
	{
		String message=null;  
		try
	    {
	  Connection con=connection.getDBConnection();
	   PreparedStatement st=(PreparedStatement)con.prepareStatement("Update Empjob set active='False' where Job_id=?" );
	   st.setString(1, id);
	    
	   int retVal = st.executeUpdate();
	   if(retVal==1)
		{
			message="record updated";
		}
		
	}
	catch(ClassNotFoundException e) {
		System.out.println(e.getMessage());
		
	}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	return message;
	}
	
	public ResultSet EmpJobsGenerated()
	{
		
	ResultSet rs=null;
	
		  try
		    {
		  Connection con=connection.getDBConnection();
		   PreparedStatement st=(PreparedStatement)con.prepareStatement	("select * from empJob where active='true'");
		  		  
		    rs = st.executeQuery();
		   return rs;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
		
	}
	
	public ResultSet EmpSkills()
	{
		
	
		ResultSet rs=null;
		
			  try
			    {
			  Connection con=connection.getDBConnection();
			   PreparedStatement st=(PreparedStatement)con.prepareStatement	("\r\n" + 
			   		"select first_name +' '+last_name name, es.user_id,es.Skills from Empskill es,empdata e where es.user_ID=es.user_id and e.user_ID=?");
			   st.setString(1, uId);
			  		  
			    rs = st.executeQuery();
			   return rs;
			}
			catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return rs;
			
	}
	
	}



