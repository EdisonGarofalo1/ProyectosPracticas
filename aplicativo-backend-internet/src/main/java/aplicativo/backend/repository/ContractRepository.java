package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicativo.backend.entities.Contract;

public interface ContractRepository  extends  JpaRepository<Contract,Integer> {

}
