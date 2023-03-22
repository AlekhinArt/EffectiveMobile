package service.feedback.service;

import service.feedback.model.FeedBack;
import service.keyWord.model.KeyWord;

public interface FeedBackService {
    void createFeedBack(FeedBack feedBack);

    void changeFeedBack(FeedBack feedBack);

    void deleteFeedBack(FeedBack feedBack);
}
