package aplicativo.backend.entities;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "usercash")
public class UserCash implements Serializable {

 
	private static final long serialVersionUID = 7987576886177035508L;

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_userid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cash_cashid")
    private Cash cash;
    
    
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

    
    
	

}
