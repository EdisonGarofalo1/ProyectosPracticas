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
@Table(name = "methodpayment")
public class Methodpayment  implements Serializable{


	private static final long serialVersionUID = 8745345310813350839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer methodpaymentid;
	
	@Column(name = "description", length = 50)
    private String description;

	
	  @OneToMany(mappedBy = "methodpayment")
	  private List<Contract> Contract;

	
	public Methodpayment() {
		super();
	}

	public Integer getMethodpaymentid() {
		return methodpaymentid;
	}

	public void setMethodpaymentid(Integer methodpaymentid) {
		this.methodpaymentid = methodpaymentid;
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
		return "Methodpayment [methodpaymentid=" + methodpaymentid + ", description=" + description + "]";
	}
	
	
	
	
	

	
}



