package service.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.seller.model.Seller;

public interface SellerRepository extends JpaRepository <Seller, Long> {
}
