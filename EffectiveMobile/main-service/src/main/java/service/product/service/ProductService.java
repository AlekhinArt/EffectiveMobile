package service.product.service;

import service.product.model.Product;

public interface ProductService {

    void createProduct (Product product);
    void changeProduct (Product product);
    void deleteProduct( Long productId);

}
