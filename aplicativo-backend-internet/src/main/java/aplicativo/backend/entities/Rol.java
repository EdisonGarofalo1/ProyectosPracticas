package aplicativo.backend.entities;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol  implements Serializable{


	private static final long serialVersionUID = 8745345310813350839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer rolId;
	
	@Column(name = "rolName", length = 50)
    private String rolName;
	
	  @OneToMany(mappedBy = "rol")
	    private List<User> user;
	  
	  
	  
	  
	  
	  

	public Rol() {
		super();
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Rol [rolId=" + rolId + ", rolName=" + rolName + ", user=" + user + "]";
	}
	  
	  
	  
	  
	  
	  
	  
	  
	
}
