package model;

public class Pmjob {
private String JobId;
private String title;
private String discription;
private String sall;
private String Location;
private String skills;
private String cmpnyName;
public Pmjob() {
}
public Pmjob(String title, String discription, String sall, String location, String skills, String cmpnyName) {
	super();
	//this.JobId=JobId;
	this.title = title;
	this.discription = discription;
	this.sall = sall;
	Location = location;
	this.skills = skills;
	this.cmpnyName = cmpnyName;
}
public String getJobId() {
	return JobId;
}
public void setJobId(String jobId) {
	JobId = jobId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDiscription() {
	return discription;
}
public void setDiscription(String discription) {
	this.discription = discription;
}
public String getSall() {
	return sall;
}
public void setSall(String sall) {
	this.sall = sall;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
public String getCmpnyName() {
	return cmpnyName;
}
public void setCmpnyName(String cmpnyName) {
	this.cmpnyName = cmpnyName;
}
@Override
public String toString() {
	return "Pmjob [JobId=" + JobId + ", title=" + title + ", discription=" + discription + ", sall=" + sall
			+ ", Location=" + Location + ", skills=" + skills + ", cmpnyName=" + cmpnyName + "]";
}


}
