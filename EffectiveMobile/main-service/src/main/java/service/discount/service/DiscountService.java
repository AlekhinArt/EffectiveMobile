package service.discount.service;

import service.discount.model.Discount;

public interface DiscountService {

    void createDiscount(Discount discount);

    void changeDiscount(Discount discount);

    void deleteDiscount(Discount discount);
}
