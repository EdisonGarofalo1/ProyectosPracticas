package aplicativo.backend.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "attentionType")
public class AttentionType  implements Serializable{
	
	

	private static final long serialVersionUID = 4320366838725502514L;
	
	@Id
	@Column(name = "attentiontypeid", length = 3)
	private String attentiontypeid;
	
	@Column(name = "description", length = 100)
	  private String description ;

	
	  @OneToMany(mappedBy = "attentionType")
	  private List<Attention> attentions;
	  
	  
	  
	
	public AttentionType() {
		super();
	}

	public List<Attention> getAttentions() {
		return attentions;
	}

	public void setAttentions(List<Attention> attentions) {
		this.attentions = attentions;
	}

	public AttentionType(String attentiontypeid, String description) {
		super();
		this.attentiontypeid = attentiontypeid;
		this.description = description;
	}

	public String getAttentiontypeid() {
		return attentiontypeid;
	}

	public void setAttentiontypeid(String attentiontypeid) {
		this.attentiontypeid = attentiontypeid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AttentionType [attentiontypeid=" + attentiontypeid + ", description=" + description + "]";
	}

	
	
	
}
