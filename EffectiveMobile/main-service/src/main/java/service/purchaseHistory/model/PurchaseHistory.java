package service.purchaseHistory.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.parameters.P;
import service.product.model.Product;
import service.seller.model.Seller;
import service.user.model.User;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "purchase_history")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_product_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "buyer_user_id")
    private User buyer;
    @OneToOne
    @JoinColumn(name = "seller_user_id")
    private Seller seller;
    private LocalDateTime time;

}
