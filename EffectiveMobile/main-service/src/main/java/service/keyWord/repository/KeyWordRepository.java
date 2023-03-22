package service.keyWord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.notice.model.Notice;

public interface KeyWordRepository extends JpaRepository <Notice, Long> {
}
