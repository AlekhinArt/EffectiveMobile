package service.rate.service;

import service.rate.model.Rate;

public interface RateService {
    void createRate(Rate rate);

    void changeRate(Rate rate);

    void deleteRate(Rate rate);
}
