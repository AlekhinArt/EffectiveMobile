package service.seller.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.exception.NotFoundException;
import service.seller.dto.SellerDto;
import service.seller.model.Seller;
import service.seller.repository.SellerRepository;
import service.user.repository.UserRepository;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, UserRepository userRepository) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createSeller(SellerDto seller) {
        sellerRepository.save(Seller.builder().name(seller.getName())
                .confirmed(false)
                .logo(seller.getLogo())
                .description(seller.getDescription())
                .creator(userRepository.findById(seller.getCreatorId())
                        .orElseThrow(() ->
                                new NotFoundException("User with id " + seller.getCreatorId() + " not found")))
                .build());

    }

    @Override
    public void deleteSeller(Long sellerId) {

    }

    @Override
    public void approvedSeller(Boolean approved) {

    }
}
