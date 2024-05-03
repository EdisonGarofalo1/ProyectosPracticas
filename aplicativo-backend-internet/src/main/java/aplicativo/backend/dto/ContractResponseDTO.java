package aplicativo.backend.dto;

import java.sql.Date;

public class ContractResponseDTO {
	
	private Integer contractid;

	
	private Date startdate;


	private Date enddate;


	
	private ServiceResposeContratoDTO service;

	
	private StatuscontractResponseContractDTO statuscontract;

	
	private ClientDTO client;

	
	private MethodpaymentResponseContractDTO methodpayment;


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


	public ServiceResposeContratoDTO getService() {
		return service;
	}


	public void setService(ServiceResposeContratoDTO service) {
		this.service = service;
	}


	public StatuscontractResponseContractDTO getStatuscontract() {
		return statuscontract;
	}


	public void setStatuscontract(StatuscontractResponseContractDTO statuscontract) {
		this.statuscontract = statuscontract;
	}


	public ClientDTO getClient() {
		return client;
	}


	public void setClient(ClientDTO client) {
		this.client = client;
	}


	public MethodpaymentResponseContractDTO getMethodpayment() {
		return methodpayment;
	}


	public void setMethodpayment(MethodpaymentResponseContractDTO methodpayment) {
		this.methodpayment = methodpayment;
	}
	
	
	

}
