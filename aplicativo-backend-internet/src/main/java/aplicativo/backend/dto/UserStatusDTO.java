package aplicativo.backend.dto;

import jakarta.persistence.Column;

public class UserStatusDTO {

	private String statusid;
	
	
    private String description;


	public String getStatusid() {
		return statusid;
	}


	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
    
    
	
}
