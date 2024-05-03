package aplicativo.backend.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "attention")
public class Attention implements Serializable {

	private static final long serialVersionUID = -7514199324800810228L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attentionid;

	@ManyToOne
	@JoinColumn(name = "turn_turnid")
	private Turn turn;

	@ManyToOne
	@JoinColumn(name = "client_clientid")
   
	private Client client;

	@ManyToOne

	@JoinColumn(name = "attentionType_attentionTypeid")
	private AttentionType attentionType;

	@ManyToOne

	@JoinColumn(name = "attentionStatus_statusid")
	private AttentionStatus attentionStatus;

	public Attention() {
		super();
	}

	public Integer getAttentionid() {
		return attentionid;
	}

	public void setAttentionid(Integer attentionid) {
		this.attentionid = attentionid;
	}

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AttentionType getAttentionType() {
		return attentionType;
	}

	public void setAttentionType(AttentionType attentionType) {
		this.attentionType = attentionType;
	}

	public AttentionStatus getAttentionStatus() {
		return attentionStatus;
	}

	public void setAttentionStatus(AttentionStatus attentionStatus) {
		this.attentionStatus = attentionStatus;
	}

	@Override
	public String toString() {
		return "Attention [attentionid=" + attentionid + ", turn=" + turn + ", client=" + client + ", attentionType="
				+ attentionType + ", attentionStatus=" + attentionStatus + "]";
	}

}
