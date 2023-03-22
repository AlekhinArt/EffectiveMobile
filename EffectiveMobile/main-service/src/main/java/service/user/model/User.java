package service.user.model;

import jakarta.persistence.*;
import lombok.*;
import service.notice.model.Notice;
import service.product.model.Product;
import service.purchaseHistory.model.PurchaseHistory;
import service.seller.model.Seller;

import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name", unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private Integer money;
    private Boolean active;
    @OneToMany
    private Collection <PurchaseHistory> purchaseHistory;
    @OneToMany
    private Collection <Notice> notices;
    @OneToMany
    private Collection <Seller> organizations;

}
