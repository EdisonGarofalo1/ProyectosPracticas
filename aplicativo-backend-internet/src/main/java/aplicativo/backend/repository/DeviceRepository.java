package aplicativo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import aplicativo.backend.entities.Device;

public interface DeviceRepository extends  JpaRepository<Device,Integer>  {

}
