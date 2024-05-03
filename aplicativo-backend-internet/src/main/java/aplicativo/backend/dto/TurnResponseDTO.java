package aplicativo.backend.dto;

import java.sql.Date;
import java.util.List;



public class TurnResponseDTO {

	private Integer turnid;

    private String description;
	
	
	private Date date;
	

	private CashDTO cash;
	
	
    private Integer usergestorid;
    
  
    private List<AttentionResponseTurnoDTO> attentions;


	public Integer getTurnid() {
		return turnid;
	}


	public void setTurnid(Integer turnid) {
		this.turnid = turnid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public CashDTO getCash() {
		return cash;
	}


	public void setCash(CashDTO cash) {
		this.cash = cash;
	}


	public Integer getUsergestorid() {
		return usergestorid;
	}


	public void setUsergestorid(Integer usergestorid) {
		this.usergestorid = usergestorid;
	}


	public List<AttentionResponseTurnoDTO> getAttentions() {
		return attentions;
	}


	public void setAttentions(List<AttentionResponseTurnoDTO> attentions) {
		this.attentions = attentions;
	}
    
    
    
    
	
}
