package aplicativo.backend.dto;

public class CashDTO {
	private Integer cashid;
	
	
    private String cashdescription;
	

    private String active;


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
	

}
