package service.discount.model;

import jakarta.persistence.*;
import lombok.*;
import service.product.model.Product;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long id;
    @OneToMany
    private Collection <Product> products;
    private Double discountAmount;
    private LocalDateTime startDiscount;
    private LocalDateTime finishDiscount;
}
