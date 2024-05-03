package aplicativo.backend.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "client")
public class Client  implements Serializable{
	
	
	 
	private static final long serialVersionUID = 8639186979083415986L;
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer clientid;
	
	@Column(name = "name",length = 50)
	  private String name;
	
	  @Column(name = "lastName",length = 50)
	  private String lastName;
	  
	  @Column(name = "identification",length = 13)
	  private String identification;
	  
	  @Column(name = "email",length = 120)
	  private String email;
	  
	  @Column(name = "phonenumber",length = 13)
	  private String phonenumber;
	  
	  @Column(name = "address",length = 100)
	  private String address;
	  
	  @Column(name = "referencceaddress",length = 100)
	  private String referencceaddress;
	
	  @OneToMany(mappedBy = "client")
	  private List<Attention> attentions;
	  
	  
	  @OneToMany(mappedBy = "client")
	  private List<Contract> Contract;
	  
	  
	  @OneToMany(mappedBy = "client")
	  private List<Payments> payments;
	  

//	  @Column(name = "estadocliente",length = 10)
//	  private String estadocliente;
	  
	  
	public Client() {
		super();
	}

	public Integer getClientid() {
		return clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferencceaddress() {
		return referencceaddress;
	}

	public void setReferencceaddress(String referencceaddress) {
		this.referencceaddress = referencceaddress;
	}

	public List<Attention> getAttentions() {
		return attentions;
	}

	public void setAttentions(List<Attention> attentions) {
		this.attentions = attentions;
	}

	public List<Contract> getContract() {
		return Contract;
	}

	public void setContract(List<Contract> contract) {
		Contract = contract;
	}
	
	

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", name=" + name + ", lastName=" + lastName + ", identification="
				+ identification + ", email=" + email + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", referencceaddress=" + referencceaddress + ", attentions=" + attentions + ", Contract=" + Contract
				+ ", payments=" + payments + "]";
	}


	

	  
	  
	  
}
