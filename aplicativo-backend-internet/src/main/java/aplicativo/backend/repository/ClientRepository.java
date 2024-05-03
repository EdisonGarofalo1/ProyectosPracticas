package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aplicativo.backend.entities.Client;




public interface ClientRepository extends  JpaRepository<Client,Integer> {
	
	@Query("from Client  c  where c.identification=?1  ")
	
	Client buscarClientidentification (String identification);

}
