package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicativo.backend.entities.Attention;


public interface AttentionRepository  extends  JpaRepository<Attention,Integer> {

}
