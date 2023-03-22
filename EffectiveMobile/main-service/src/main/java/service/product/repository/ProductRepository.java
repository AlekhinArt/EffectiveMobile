package service.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.product.model.Product;

public interface ProductRepository  extends JpaRepository <Product, Long> {
}
