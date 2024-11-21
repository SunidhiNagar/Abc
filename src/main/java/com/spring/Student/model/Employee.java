package com.spring.Student.model;





import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSizeKb() {
		return fileSizeKb;
	}
	public void setFileSizeKb(int fileSizeKb) {
		this.fileSizeKb = fileSizeKb;
	}
	public String getFileMimeType() {
		return fileMimeType;
	}
	public void setFileMimeType(String fileMimeType) {
		this.fileMimeType = fileMimeType;
	}
	public boolean isFileValid() {
		return fileValid;
	}
	public void setFileValid(boolean fileValid) {
		this.fileValid = fileValid;
	}
	@Id
    private String userId;
    private String email;
    private String rollNumber;
    private String fileName;
    private int fileSizeKb;
    private String fileMimeType;
    private boolean fileValid;
}
