package service.keyWord.service;

import service.keyWord.model.KeyWord;

public interface KeyWordService {

    void createKeyWord(KeyWord keyWord);

    void changeKeyWord(KeyWord keyWord);

    void deleteKeyWord(KeyWord keyWord);
}
