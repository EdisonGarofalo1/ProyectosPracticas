package aplicativo.backend.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments  implements Serializable{


	private static final long serialVersionUID = 8745345310813350839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer paymentid;
	
	@Column(name = "paymentdate")
    private Date paymentdate;
	
	
	 @ManyToOne
	@JoinColumn(name = "client_clientid")
	 
	  private Client client;


	public Payments() {
		super();
	}


	public Integer getPaymentid() {
		return paymentid;
	}


	public void setPaymentid(Integer paymentid) {
		this.paymentid = paymentid;
	}


	public Date getPaymentdate() {
		return paymentdate;
	}


	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Payments [paymentid=" + paymentid + ", paymentdate=" + paymentdate + ", client=" + client + "]";
	}
	 
	 
	 
	 
	
}
