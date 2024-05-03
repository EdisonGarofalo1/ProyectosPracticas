package aplicativo.backend.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "device")
public class Device implements Serializable{


	private static final long serialVersionUID = 8745345310813350839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer deviceid;
	
	@Column(name = "devicename", length = 50)
    private String devicename;
	
	
	@ManyToOne
	@JoinColumn(name = "service_serviceid")
	// @JsonIgnoreProperties({"usuarios"})
	private Services service;


	public Device() {
		super();
	}


	public Integer getDeviceid() {
		return deviceid;
	}


	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}


	public String getDevicename() {
		return devicename;
	}


	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}


	public Services getService() {
		return service;
	}


	public void setService(Services service) {
		this.service = service;
	}


	@Override
	public String toString() {
		return "Device [deviceid=" + deviceid + ", devicename=" + devicename + ", service=" + service + "]";
	}
	
	
	
	
}
