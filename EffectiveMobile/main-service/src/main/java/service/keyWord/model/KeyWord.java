package service.keyWord.model;

import jakarta.persistence.*;
import lombok.*;
import service.product.model.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "feedback")
public class KeyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String word;
    @ManyToOne
    private Product product;

}
