package service.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.discount.model.Discount;

public interface DiscountRepository extends JpaRepository <Discount, Long> {
}
