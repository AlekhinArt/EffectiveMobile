package service.seller.model;

import jakarta.persistence.*;
import lombok.*;
import service.product.model.Product;
import service.user.model.User;

import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;
    private String name;
    private String description;
    private String logo;
    @OneToOne
    private User creator;
    @OneToMany
    private Collection <Product> products;
    private Boolean confirmed;

}
