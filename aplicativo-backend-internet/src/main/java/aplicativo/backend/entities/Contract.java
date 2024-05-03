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
@Table(name = "contract")
public class Contract implements Serializable {

	private static final long serialVersionUID = 8745345310813350839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer contractid;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "enddate")
	private Date enddate;

	@ManyToOne
	@JoinColumn(name = "service_serviceid")
	
	private Services service;

	@ManyToOne
	@JoinColumn(name = "Statuscontract_statusid")
	private Statuscontract statuscontract;

	@ManyToOne
	@JoinColumn(name = "client_clientid")
	
	
	private Client client;

	@ManyToOne

	@JoinColumn(name = "methodpayment_methodpaymentid")
	private Methodpayment methodpayment;

	public Integer getContractid() {
		return contractid;
	}

	public void setContractid(Integer contractid) {
		this.contractid = contractid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Statuscontract getStatuscontract() {
		return statuscontract;
	}

	public void setStatuscontract(Statuscontract statuscontract) {
		this.statuscontract = statuscontract;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Methodpayment getMethodpayment() {
		return methodpayment;
	}

	public void setMethodpayment(Methodpayment methodpayment) {
		this.methodpayment = methodpayment;
	}

	@Override
	public String toString() {
		return "Contract [contractid=" + contractid + ", startdate=" + startdate + ", enddate=" + enddate + ", service="
				+ service + ", statuscontract=" + statuscontract + ", client=" + client + ", methodpayment="
				+ methodpayment + "]";
	}

}
