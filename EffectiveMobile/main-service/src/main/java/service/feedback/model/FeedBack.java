package service.feedback.model;

import jakarta.persistence.*;
import lombok.*;
import service.product.model.Product;
import service.user.model.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "feedback")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long id;
    private String text;
    @OneToOne
    private User author;
    @OneToOne
    private Product product;

}
