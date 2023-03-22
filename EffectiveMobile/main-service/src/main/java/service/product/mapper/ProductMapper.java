package service.product.mapper;

import service.product.dto.ProductShowDto;
import service.product.model.Product;

public class ProductMapper {

    public static ProductShowDto toProductShowDto(Product product) {
        return ProductShowDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .sellerName(product.getSeller().getName())
                .build();
    }
}
