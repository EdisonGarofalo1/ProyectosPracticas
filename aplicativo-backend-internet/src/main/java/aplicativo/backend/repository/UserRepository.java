package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aplicativo.backend.entities.User;



public interface UserRepository extends  JpaRepository<User,Integer>{
	
	@Query("from User  u  where u.username=?1 ")
	User buscarusername(String userName);
	
	
	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u " +
	           "INNER JOIN u.userStatus st WHERE u.userid = :userId AND st.statusid = 'A'")
	    boolean existsByUserIdAndStatusActive(@Param("userId") Integer userId);
	 
	 
	 
	  
//
//	@Query("from User  u  where u.username=?1 ")
//	User buscarexiste(String userName);
	
	
	
//	@Query("from User  u  where u.userName=?1 or u.mail=?2  ")
//	
//	User indByUsername(String userName);
	
}
