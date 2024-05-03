package aplicativo.backend.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "userr")
public class User  implements Serializable{

	private static final long serialVersionUID = -3887670396668948915L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;

	
	@Column(name = "username", length = 50)
	private String username;

	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "password", length = 100)
	private String password;

	@ManyToOne
	@JoinColumn(name = "rol_rolid")
    @JsonIgnoreProperties({"user"})
	private Rol rol;

	@Column(name = "creationdate") //fecha de creación
	private Date creationdate;
	
	@Column(name = "usercreate")  //crearusuario
	private Integer usercreate;
	
	@Column(name = "userapproval")
	private Integer userapproval; // aprobación de usuario
	
	@Column(name = "dateapproval")
	private Date dateapproval; // fecha de aprobación

	 @OneToMany(mappedBy = "usuario")
	    private List<Sesion> sesiones;

	
	public List<Sesion> getSesiones() {
		return sesiones;
	}







	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}







	@ManyToOne
	@JoinColumn(name = "userStatus_statusid")
	  @JsonIgnoreProperties({"users"})
	private UserStatus userStatus;


	

    @OneToMany(mappedBy = "user")
    
    private Set<UserCash> userCashes = new HashSet<>();

	
	
	
	public User() {
		super();
	}







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







	public Rol getRol() {
		return rol;
	}







	public void setRol(Rol rol) {
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







	public Set<UserCash> getUserCashes() {
		return userCashes;
	}







	public void setUserCashes(Set<UserCash> userCashes) {
		this.userCashes = userCashes;
	}







	public UserStatus getUserStatus() {
		return userStatus;
	}







	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}



















	

}
