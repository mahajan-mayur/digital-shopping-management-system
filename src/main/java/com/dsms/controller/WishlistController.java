package com.dsms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsms.db.dao.WishlistItemRepository;
import com.dsms.db.entity.CartItem;
import com.dsms.db.entity.ItemEntity;
import com.dsms.db.entity.UserEntity;
import com.dsms.db.entity.WishlistItem;
import com.dsms.dto.ControllerResponse;
import com.dsms.dto.ControllerResponse.StatusCode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WishlistController {

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    public List<ItemEntity> findAllWishlisted(UserEntity userEntity) {
        log.info("finding wishlist Items for userId : {} ", userEntity.getId());
        List<WishlistItem> wishList = wishlistItemRepository.findAllByUserEntity(userEntity);
        return wishList.stream().map(wishListItem -> wishListItem.getItemEntity()).collect(Collectors.toList());
    }

    public ControllerResponse addToWishlist(UserEntity userEntity, ItemEntity itemEntity) {
        log.info("adding {} to wishlist", itemEntity.getId());
        WishlistItem wishlistItem = getByUserAndItem(userEntity, itemEntity);
        if (wishlistItem == null) {
            wishlistItem = WishlistItem.builder().itemEntity(itemEntity).userEntity(userEntity).build();
        }
        WishlistItem savedEntity = wishlistItemRepository.save(wishlistItem);
        log.info("itemId : {} is added in wishlist for userId : {} savedEntuty id : {} ", itemEntity.getId(),
                userEntity.getId(), savedEntity.getId());
        return ControllerResponse.builder().message("added to wishlist").statusCode(StatusCode.SUCCESS).build();

    }

    public Boolean isWishlisted(UserEntity userEntity, ItemEntity itemEntity) {
        WishlistItem wishlistItem = getByUserAndItem(userEntity, itemEntity);
        return wishlistItem != null;

    }
    
    private WishlistItem getByUserAndItem(UserEntity userEntity, ItemEntity itemEntity){
        log.info("checking if Item: {} is wishlisted for user: {}", itemEntity.getId(), userEntity.getId());
        return  wishlistItemRepository.findByUserEntityAndItemEntity(userEntity, itemEntity);
    }

}
