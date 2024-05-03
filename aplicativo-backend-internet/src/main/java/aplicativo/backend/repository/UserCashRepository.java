package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aplicativo.backend.entities.UserCash;

public interface UserCashRepository  extends  JpaRepository<UserCash,Integer>{
	
	  @Query("SELECT c.cashid FROM Cash c INNER JOIN UserCash us ON c.cashid = us.cash.cashid " +
	            "WHERE us.user.userid = :userId ORDER BY c.cashid")
	     Integer encontraidcaja(@Param("userId") Integer userId);
	

	
	

}
