package service.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.keyWord.model.KeyWord;


public interface NoticeRepository extends JpaRepository <KeyWord, Long> {
}
