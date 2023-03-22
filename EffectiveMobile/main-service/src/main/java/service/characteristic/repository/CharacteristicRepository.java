package service.characteristic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.characteristic.model.Characteristic;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {

}
