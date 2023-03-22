package service.rate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.rate.model.Rate;

public interface RateRepository extends JpaRepository<Rate, Long> {

}
