package aplicativo.backend.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Services implements Serializable{


	private static final long serialVersionUID = 8745345310813350839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer serviceid;
	
	@Column(name = "servicename", length = 100)
    private String servicename;
	
	@Column(name = "servicedescription", length = 150)
    private String servicedescription;
	
	@Column(name = "price", length = 10)
    private String price;
	
	  @OneToMany(mappedBy = "service")
	  private List<Device> device;
	    
	  @OneToMany(mappedBy = "service")
	  private List<Contract> contract;

	public Services() {
		super();
	}

	public Integer getServiceid() {
		return serviceid;
	}

	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getServicedescription() {
		return servicedescription;
	}

	public void setServicedescription(String servicedescription) {
		this.servicedescription = servicedescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}

	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return "Service [serviceid=" + serviceid + ", servicename=" + servicename + ", servicedescription="
				+ servicedescription + ", price=" + price + ", device=" + device + ", contract=" + contract + "]";
	}
	  
	  
	  
	  
	  
}
