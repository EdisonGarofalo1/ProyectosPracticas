package aplicativo.backend.entities;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "userStatus")
public class UserStatus  implements Serializable{


	private static final long serialVersionUID = 4320366838725502514L;

	@Id
	@Column(name = "statusid", length = 3)
	private String statusid;
	
	@Column(name = "description", length = 50)
    private String description;
	
	
	  @OneToMany(mappedBy = "userStatus")
	    private List<User> users;


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



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}


	  
	  
	
}
