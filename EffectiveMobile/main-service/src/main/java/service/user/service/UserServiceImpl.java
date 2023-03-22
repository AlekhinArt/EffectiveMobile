package service.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.exception.DataConflictException;
import service.exception.NotFoundException;
import service.feedback.dto.FeedBackDto;
import service.feedback.model.FeedBack;
import service.notice.model.Notice;
import service.product.dto.ProductShowDto;
import service.product.mapper.ProductMapper;
import service.product.model.Product;
import service.product.repository.ProductRepository;
import service.purchaseHistory.model.PurchaseHistory;
import service.rate.dto.RateDto;
import service.rate.model.Rate;
import service.seller.dto.SellerDto;
import service.seller.model.Seller;
import service.seller.service.SellerService;
import service.user.dto.UserDto;
import service.user.mapper.UserMapper;
import service.user.model.User;
import service.user.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SellerService sellerService;
    private final ProductRepository productRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, SellerService sellerService, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.sellerService = sellerService;
        this.productRepository = productRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User newUser;
        try {
            newUser = userRepository.save(UserMapper.toUser(userDto));
        } catch (Exception e) {
            throw new DataConflictException(" Name or email are used");
        }
        log.info("createUser user: {}", newUser);
        return UserMapper.toUserDto(newUser);

    }

    @Override
    public UserDto deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
        try {
            log.info("deleteUser id: {}", id);
            userRepository.deleteById(id);
            return UserMapper.toUserDto(user);
        } catch (Exception e) {
            log.debug("deleteUser.NotFoundException(Пользователь не найден)");
            throw new NotFoundException("Пользователь не найден");
        }
    }

    @Override
    public UserDto getById(long userId) {
        return UserMapper.toUserDto(userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found")));

    }

    @Override
    public Collection<PurchaseHistory> getPurchaseHistory(long userId) {
        return getUser(userId).getPurchaseHistory();
    }

    @Override
    public Collection<Notice> getNotice(long userId) {
        return getUser(userId).getNotices();
    }

    @Override
    public Seller createSeller(SellerDto seller, long UserId) {
        sellerService.createSeller(seller);
        return null;
    }

    @Override
    public ProductShowDto createProduct(ProductShowDto product, long userId, long sellerId) {


        return null;
    }

    @Override
    public ProductShowDto buyProduct(long productId, long userId, Integer quantity) {
        User user = getUser(userId);
        Product product = getProduct(productId);
        if (product.getQuantity() < quantity) {
            throw new NotFoundException("Too small quantity in stock");
        }
        if (product.getPrice() > user.getMoney()) {
            throw new NotFoundException("Not enough money");
        }
        user.setMoney(user.getMoney() - product.getPrice());
        product.setQuantity(product.getQuantity() - quantity);
        ArrayList<PurchaseHistory> purchaseHistory = new ArrayList<>(user.getPurchaseHistory());
        purchaseHistory.add(PurchaseHistory.builder()
                .buyer(user)
                .product(product)
                .time(LocalDateTime.now())
                .seller(product.getSeller())
                .build());
        user.setPurchaseHistory(purchaseHistory);
        User userSeller = product.getSeller().getCreator();
        userSeller.setMoney((int) (product.getPrice() * 0.95));
        userRepository.save(userSeller);
        userRepository.save(user);
        return ProductMapper.toProductShowDto(productRepository.save(product));
    }

    @Override
    public RateDto setRate(long productId, long userId, int score) {
        Product product = getProduct(productId);
        User user = getUser(userId);
        checkPurchase(user, product);
        Rate rate = new Rate();
        rate.setUser(user);
        rate.setScore(score);
        Collection<Rate> rates = product.getRate();
        rates.add(rate);
        product.setRate(rates);
        productRepository.save(product);
        return RateDto.builder().rate(score)
                .name(rate.getUser().getName()).build();
    }

    @Override
    public FeedBackDto createFeedBack(long productId, long userId, String text) {
        Product product = getProduct(productId);
        User user = getUser(userId);
        checkPurchase(user, product);
        FeedBack feedBack = new FeedBack();
        feedBack.setAuthor(user);
        feedBack.setText(text);
        feedBack.setProduct(product);
        Collection<FeedBack> feedBacks = product.getFeedback();
        feedBacks.add(feedBack);
        product.setFeedback(feedBacks);
        productRepository.save(product);
        return FeedBackDto.builder().authorName(feedBack.getAuthor().getName())
                .productName(feedBack.getProduct().getName())
                .text(feedBack.getText()).build();
    }

    public User getUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));

    }

    public Product getProduct(long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product with id " + productId + " not found"));

    }

    public void checkPurchase(User user, Product product) {
        if (!user.getPurchaseHistory().contains(product)) {
            throw new NotFoundException("It is necessary to purchase the product");
        }
    }
}
