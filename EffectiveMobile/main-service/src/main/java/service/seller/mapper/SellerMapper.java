package service.seller.mapper;

import service.seller.dto.SellerDto;
import service.seller.model.Seller;

public class SellerMapper {

    public static SellerDto toSellerDto (Seller seller){
        return SellerDto.builder()
                .name(seller.getName())
                .creatorId(seller.getCreator().getId())
                .description(seller.getDescription())
                .logo(seller.getLogo())
                .build();

    }
}
