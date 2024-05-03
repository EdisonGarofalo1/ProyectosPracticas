package aplicativo.backend.dto;

public class AttentionResponseTurnoDTO {
	
	private Integer attentionid;

	
	

   
	private ClientDTO client;

	
	private AttentionTypeDTO attentionType;

	
	private AttentionStatusDTO attentionStatus;


	public Integer getAttentionid() {
		return attentionid;
	}


	public void setAttentionid(Integer attentionid) {
		this.attentionid = attentionid;
	}


	public ClientDTO getClient() {
		return client;
	}


	public void setClient(ClientDTO client) {
		this.client = client;
	}


	public AttentionTypeDTO getAttentionType() {
		return attentionType;
	}


	public void setAttentionType(AttentionTypeDTO attentionType) {
		this.attentionType = attentionType;
	}


	public AttentionStatusDTO getAttentionStatus() {
		return attentionStatus;
	}


	public void setAttentionStatus(AttentionStatusDTO attentionStatus) {
		this.attentionStatus = attentionStatus;
	}
	
	

}
