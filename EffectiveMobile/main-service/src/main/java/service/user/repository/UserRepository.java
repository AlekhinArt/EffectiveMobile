package service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.user.model.User;

public interface UserRepository extends JpaRepository <User, Long> {
}
