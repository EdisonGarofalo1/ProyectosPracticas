package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aplicativo.backend.entities.Turn;

public interface TurnRepository  extends  JpaRepository<Turn,Integer> {

	 @Query(value = "SELECT COUNT(t.turnid) FROM turn t INNER JOIN attention a ON t.turnid = a.turn_turnid " +
             "WHERE a.attention_type_attention_typeid = ?1", nativeQuery = true)
                     Long countByTipoAtencion(String attentionTypeId);
	 
}
	

