package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicativo.backend.entities.Payments;


public interface PaymentsRepository extends  JpaRepository<Payments,Integer> {

}
