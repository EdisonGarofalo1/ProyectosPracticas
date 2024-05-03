package aplicativo.backend.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "attentionStatus")
public class AttentionStatus implements Serializable{


	private static final long serialVersionUID = 4320366838725502514L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer statusid;
	
	@Column(name = "description", length = 30)
    private String description;
	
	
	  @OneToMany(mappedBy = "attentionStatus")
	  private List<Attention> attentions;


	public AttentionStatus() {
		super();
	}


	public Integer getStatusid() {
		return statusid;
	}


	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Attention> getAttentions() {
		return attentions;
	}


	public void setAttentions(List<Attention> attentions) {
		this.attentions = attentions;
	}


	@Override
	public String toString() {
		return "AttentionStatus [statusid=" + statusid + ", description=" + description + ", attentions=" + attentions
				+ "]";
	}
	  
	  
	  
}
