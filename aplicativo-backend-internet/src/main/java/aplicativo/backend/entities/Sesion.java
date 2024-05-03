package aplicativo.backend.entities;

import java.io.Serializable;
import java.sql.Date;



import jakarta.persistence.*;


@Entity
@Table(name = "Sesion")
public class Sesion implements Serializable {
	
	 
	private static final long serialVersionUID = 1245602698118385910L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idSesion")
	    private Integer idSesion;

	    @ManyToOne
	    @JoinColumn(name = "usuarios_idUsuario")
	    private User usuario;
	    
	    @Column(name = "cashid")
	    private Integer cashid;

	    @Column(name = "FechaIngreso")
	    private Date fechaIngreso;

	    @Column(name = "FechaCierre")
	    private Date fechaCierre;

		public Integer getIdSesion() {
			return idSesion;
		}

		public void setIdSesion(Integer idSesion) {
			this.idSesion = idSesion;
		}

		public User getUsuario() {
			return usuario;
		}

		public void setUsuario(User usuario) {
			this.usuario = usuario;
		}

		public Integer getCashid() {
			return cashid;
		}

		public void setCashid(Integer cashid) {
			this.cashid = cashid;
		}

		public Date getFechaIngreso() {
			return fechaIngreso;
		}

		public void setFechaIngreso(Date fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}

		public Date getFechaCierre() {
			return fechaCierre;
		}

		public void setFechaCierre(Date fechaCierre) {
			this.fechaCierre = fechaCierre;
		}
	
	

}
