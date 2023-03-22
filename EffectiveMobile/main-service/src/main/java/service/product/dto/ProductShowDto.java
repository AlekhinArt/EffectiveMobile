package service.product.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ProductShowDto {
    private String name;
    private String description;
    private String sellerName;
    private Integer price;
    private Integer quantity;
}
