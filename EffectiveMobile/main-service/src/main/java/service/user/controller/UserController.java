package service.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import service.notice.model.Notice;
import service.product.dto.ProductShowDto;
import service.purchaseHistory.model.PurchaseHistory;
import service.seller.dto.SellerDto;
import service.seller.model.Seller;
import service.user.dto.UserDto;
import service.user.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("user")
    public UserDto createUser(@RequestBody UserDto user) {
        log.info("createUser user : {}", user);
        return userService.createUser(user);
    }

    @DeleteMapping("user/{id}")
    public UserDto deleteUser(@PathVariable long id) {
        log.info("deleteUser userId: {}", id);
        return userService.deleteUser(id);
    }

    @GetMapping("user/{id}")
    public UserDto getUser(@PathVariable long id) {
        log.info("getUser userId: {}", id);
        return userService.getById(id);
    }

    @GetMapping("user/purchases/{id}")
    public Collection<PurchaseHistory> getPurchaseHistory(@PathVariable long id) {
        log.info("getPurchaseHistory userId: {}", id);
        return userService.getPurchaseHistory(id);
    }

    @GetMapping("user/notice/{id}")
    public Collection<Notice> getNotice(@PathVariable long id) {
        log.info("getNotice userId: {}", id);
        return userService.getNotice(id);
    }

    @PostMapping("user/seller/{id}")
    public Seller createSeller(@RequestBody SellerDto seller,
                               @PathVariable long id) {
        log.info("createSeller seller : {}, userId: {} ", seller, id);
        return userService.createSeller(seller, id);
    }

    @GetMapping("product/{productId}/user/{id}")
    public ProductShowDto buyProduct(@PathVariable long productId,
                                     @PathVariable long id,
                                     @RequestParam(required = false, defaultValue = "1") int quantity) {
        log.info("buyProduct productId : {}, userId: {}, quantity: {} ", productId, id, quantity);
        return userService.buyProduct(productId, id, quantity);
    }

    @PostMapping("user/product/{userId}/{sellerId}")
    public ProductShowDto createProduct(@RequestBody ProductShowDto product,
                               @PathVariable long userId,
                                        @PathVariable long sellerId) {
        log.info("createSeller product : {}, userId: {}, sellerId: {} ", product, userId, sellerId);
        return userService.createProduct(product, userId, sellerId);
    }



}
