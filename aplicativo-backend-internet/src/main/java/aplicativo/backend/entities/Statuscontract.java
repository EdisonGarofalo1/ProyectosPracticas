package aplicativo.backend.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "statuscontract")
public class Statuscontract implements Serializable{


	private static final long serialVersionUID = 4320366838725502514L;
	@Id
	@Column(name = "statusid", length = 3)
	private String statusid;
	
	@Column(name = "description", length = 50)
    private String description;
	
	
	  @OneToMany(mappedBy = "statuscontract")
	  private List<Contract> Contract;


	  
	  
	public Statuscontract() {
		super();
	}


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


	public List<Contract> getContract() {
		return Contract;
	}


	public void setContract(List<Contract> contract) {
		Contract = contract;
	}


	@Override
	public String toString() {
		return "Statuscontract [statusid=" + statusid + ", description=" + description + ", Contract=" + Contract + "]";
	}
	  
	  
	  
	  
}

