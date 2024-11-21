package com.spring.Student.dto;





import lombok.Data;

import java.util.List;

@Data
public class RequestDTO {
    private List<String> data;
    private String fileB64;
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public String getFileB64() {
		return fileB64;
	}
	public void setFileB64(String fileB64) {
		this.fileB64 = fileB64;
	}
}

