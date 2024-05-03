package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import aplicativo.backend.entities.Methodpayment;

public interface MethodpaymentRepository extends  JpaRepository<Methodpayment,Integer> {

}
