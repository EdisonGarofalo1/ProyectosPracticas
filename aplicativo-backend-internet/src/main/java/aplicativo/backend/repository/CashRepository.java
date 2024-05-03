package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicativo.backend.entities.Cash;



public interface CashRepository  extends  JpaRepository<Cash,Integer>{

}
