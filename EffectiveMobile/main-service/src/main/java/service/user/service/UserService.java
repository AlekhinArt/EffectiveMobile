package service.user.service;

import service.feedback.dto.FeedBackDto;
import service.feedback.model.FeedBack;
import service.notice.model.Notice;
import service.product.dto.ProductShowDto;
import service.product.model.Product;
import service.purchaseHistory.model.PurchaseHistory;
import service.rate.dto.RateDto;
import service.rate.model.Rate;
import service.seller.dto.SellerDto;
import service.seller.model.Seller;
import service.user.dto.UserDto;

import java.util.Collection;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto deleteUser(long id);

    UserDto getById(long userId);

    Collection<PurchaseHistory> getPurchaseHistory(long userId);

    Collection<Notice> getNotice(long userId);

    Seller createSeller(SellerDto seller, long UserId);

    ProductShowDto createProduct(ProductShowDto product, long userId, long sellerId);

    ProductShowDto buyProduct(long productId, long userId, Integer quantity);

    RateDto setRate(long productId, long userId, int rate);

    FeedBackDto createFeedBack(long productId, long userId, String text);

}
