package model;

public class Employee {


	private int empId;
	public String firstName;
	private String lastName;
	private String userId;
	private String password;
	private String currentRole;
	private String Mobile;
	private String vertical;
	private String DOB;
	private String skills;
	private String gender;
	private String DOJ;
	private String active_role;
	
	public String getActive() {
		System.out.println("in getactive" + active_role);
		return active_role;
	}
	public void setActive(String active) {
		System.out.println("in setactive" + active_role);
		this.active_role = active;
	}
	public Employee() {
		
	}
	public Employee(String firstName, String lastName, String userId, String password, String currentRole,
			String mobile, String vertical, String dOB, String skills, String gender, String doj) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.password = password;
		this.currentRole = currentRole;
		this.Mobile = mobile;
		this.vertical = vertical;
		this.DOB = dOB;
		this.skills = skills;
		this.gender = gender;
		this.DOJ = doj;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getVertical() {
		return vertical;
	}
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOJ) {
		DOJ = dOJ;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId
				+ ", password=" + password + ", currentRole=" + currentRole + ", Mobile=" + Mobile + ", vertical="
				+ vertical + ", DOB=" + DOB + ", skills=" + skills + ", gender=" + gender + ", active_role=" + active_role + "]";
	}
	
		
	}
	

	
	