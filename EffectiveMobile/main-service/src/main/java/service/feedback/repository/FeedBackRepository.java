package service.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.feedback.model.FeedBack;

public interface FeedBackRepository extends JpaRepository <FeedBack, Long> {
}
