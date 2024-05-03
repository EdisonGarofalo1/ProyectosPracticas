package aplicativo.backend.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turn")
public class Turn  implements Serializable{


	private static final long serialVersionUID = -8622065006690745872L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer turnid;
	
	@Column(name = "description", length = 7)
    private String description;
	
	
	@Column(name = "date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "cash_cashid")
	@JsonIgnoreProperties({"turn"})
	private Cash cash;
	
	@Column(name = "usergestorid")
    private Integer usergestorid;
	
	
	
	  @OneToMany(mappedBy = "turn")
	  private List<Attention> attentions;

	public Turn() {
		super();
	}

	public List<Attention> getAttentions() {
		return attentions;
	}

	public void setAttentions(List<Attention> attentions) {
		this.attentions = attentions;
	}

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

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

	public Integer getUsergestorid() {
		return usergestorid;
	}

	public void setUsergestorid(Integer usergestorid) {
		this.usergestorid = usergestorid;
	}

	@Override
	public String toString() {
		return "Turn [turnid=" + turnid + ", description=" + description + ", date=" + date + ", cash=" + cash
				+ ", usergestorid=" + usergestorid + "]";
	}
	
	
	
	
}
