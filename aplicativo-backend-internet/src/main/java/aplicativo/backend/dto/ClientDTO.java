package aplicativo.backend.dto;

public class ClientDTO {
	
	 private Integer clientid;
	    private String name;
	    private String lastName;
	    private String identification;
	    private String email;
	    private String phonenumber;
	    private String address;
	    private String referencceaddress;
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
	    
	    

}
