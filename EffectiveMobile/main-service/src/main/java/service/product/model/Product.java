package service.product.model;

import jakarta.persistence.*;
import lombok.*;
import service.characteristic.model.Characteristic;
import service.discount.model.Discount;
import service.feedback.model.FeedBack;
import service.keyWord.model.KeyWord;
import service.rate.model.Rate;
import service.seller.model.Seller;

import java.util.Collection;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String name;
    private String description;
    @OneToOne
    private Seller seller;
    private Integer price;
    private Integer quantity;
    @ManyToOne
    private Discount discount;
    @OneToMany
    private Collection<FeedBack> feedback;
    @OneToMany
    private Collection<KeyWord> keyWord;
    @OneToMany
    private Collection<Characteristic> characteristic;
    @OneToMany
    private Collection<Rate> rate;
    private Boolean available;


}
