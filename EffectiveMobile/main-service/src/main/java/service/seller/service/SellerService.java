package service.seller.service;

import service.seller.dto.SellerDto;
import service.seller.model.Seller;

public interface SellerService {
    void createSeller (SellerDto seller);
    void deleteSeller (Long sellerId);
    void approvedSeller (Boolean approved); //for admin

}
