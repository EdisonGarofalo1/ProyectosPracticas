package aplicativo.backend.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "cash")
public class Cash  implements Serializable{
	

	private static final long serialVersionUID = -4834678016000070266L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer cashid;
	
	@Column(name = "cashdescription", length = 50)
    private String cashdescription;
	
	@Column(name = "active", length = 1)
    private String active;
	
	
	 @OneToMany(mappedBy = "cash")
	    private Set<UserCash> userCashes = new HashSet<>();

	
	
	  @OneToMany(mappedBy = "cash")
	    private List<Turn> turn;


	  
	  
	  

	public Cash() {
		super();
	}



	public Integer getCashid() {
		return cashid;
	}



	public void setCashid(Integer cashid) {
		this.cashid = cashid;
	}



	public String getCashdescription() {
		return cashdescription;
	}



	public void setCashdescription(String cashdescription) {
		this.cashdescription = cashdescription;
	}



	public String getActive() {
		return active;
	}



	public void setActive(String active) {
		this.active = active;
	}



	public Set<UserCash> getUserCashes() {
		return userCashes;
	}



	public void setUserCashes(Set<UserCash> userCashes) {
		this.userCashes = userCashes;
	}



	public List<Turn> getTurn() {
		return turn;
	}



	public void setTurn(List<Turn> turn) {
		this.turn = turn;
	}



	@Override
	public String toString() {
		return "Cash [cashid=" + cashid + ", cashdescription=" + cashdescription + ", active=" + active
				+ ", userCashes=" + userCashes + ", turn=" + turn + "]";
	}
	  
	  

}
