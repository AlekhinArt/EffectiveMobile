package service.rate.model;

import jakarta.persistence.*;
import lombok.*;
import service.user.model.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;
    private Integer score;
}
