package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicativo.backend.entities.Services;


public interface ServicesRepository  extends  JpaRepository<Services,Integer> {

}
