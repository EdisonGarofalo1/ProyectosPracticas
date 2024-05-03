package aplicativo.backend.dto;

import java.sql.Date;

public class UserDTO {
	
	
private Integer userid;

	

	private String username;

	private String email;
	
	
	private String password;


	private RolDTO rol;


	private Date creationdate;
	

	private Integer usercreate;
	

	private Integer userapproval; 

	private Date dateapproval; 
	
	private UserStatusDTO userStatus;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Integer getUsercreate() {
		return usercreate;
	}

	public void setUsercreate(Integer usercreate) {
		this.usercreate = usercreate;
	}

	public Integer getUserapproval() {
		return userapproval;
	}

	public void setUserapproval(Integer userapproval) {
		this.userapproval = userapproval;
	}

	public Date getDateapproval() {
		return dateapproval;
	}

	public void setDateapproval(Date dateapproval) {
		this.dateapproval = dateapproval;
	}

	public UserStatusDTO getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatusDTO userStatus) {
		this.userStatus = userStatus;
	}



	
	


}
