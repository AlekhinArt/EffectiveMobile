package service.notice.service;

import service.notice.model.Notice;

public interface NoticeService {
    void createNotice (Notice notice);
    void changeNotice (Notice notice);
    void deleteNotice( Notice notice);
}
