package aplicativo.backend.dto;

public class ServiceResposeContratoDTO {
	
private Integer serviceid;
	

    private String servicename;
	

    private String servicedescription;
	

    private String price;


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
    
    
    

}
