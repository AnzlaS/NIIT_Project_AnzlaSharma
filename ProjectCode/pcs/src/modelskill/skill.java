package modelskill;

public class skill {
	private int skillId;
	private int empId;
	private String skills;
	public skill() {
		
	}
	public skill(int empId, String skills) {
		super();
		this.empId = empId;
		this.skills = skills;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "skill [skillId=" + skillId + ", empId=" + empId + ", skills=" + skills + "]";
	}
	
}
