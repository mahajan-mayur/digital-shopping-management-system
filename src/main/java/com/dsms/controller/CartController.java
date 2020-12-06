package com.dsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsms.db.dao.CartItemRepository;
import com.dsms.db.entity.CartItem;
import com.dsms.db.entity.ItemEntity;
import com.dsms.db.entity.UserEntity;
import com.dsms.db.entity.WishlistItem;
import com.dsms.dto.ControllerResponse;
import com.dsms.dto.ControllerResponse.StatusCode;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
@Slf4j
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> findAllCartItems(UserEntity userEntity) {
        log.info("finding cart Items for userId : {} ", userEntity.getId());
        List<CartItem> cartItemList = cartItemRepository.findAllByUserEntity(userEntity);
        return cartItemList;
    }

    public ControllerResponse addToCart(UserEntity userEntity, ItemEntity itemEntity) {
        return this.addToCart(userEntity, itemEntity, 1);
    }

    public ControllerResponse addToCart(UserEntity userEntity, ItemEntity itemEntity, int itemCount) {
        log.info("adding {} to wishlist", itemEntity.getId());
        CartItem cartItem = getByUserAndItem(userEntity, itemEntity);
        if (cartItem == null) {
            cartItem = CartItem.builder().itemCount(itemCount).itemEntity(itemEntity).userEntity(userEntity).build();
        }
        cartItem.setItemCount(itemCount);
        CartItem savedEntity = cartItemRepository.save(cartItem);
        log.info("itemId : {} is added in cartItem for userId : {} savedEntuty id : {} ", itemEntity.getId(),
                userEntity.getId(), savedEntity.getId());
        return ControllerResponse.builder().message("added to cart").statusCode(StatusCode.SUCCESS).build();

    }
    
    public Boolean isAddedToCart(UserEntity userEntity, ItemEntity itemEntity) {
        CartItem cartItem = getByUserAndItem(userEntity, itemEntity);
        return cartItem != null;
    }

    private CartItem getByUserAndItem(UserEntity userEntity, ItemEntity itemEntity) {
        log.info("checking if Item: {} is added to cart for user: {}", itemEntity.getId(), userEntity.getId());
        return cartItemRepository.findByUserEntityAndItemEntity(userEntity, itemEntity);
    }
    
        public Page<ItemEntity> getCartItems(UserEntity userEntity, Integer pageNumber, Integer size) {
        log.info("getting cart items for user : {} ", userEntity.getId());
        PageRequest pageRequest = PageRequest.of(pageNumber, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<CartItem> cartItemPage = cartItemRepository.findAllByUserEntity(userEntity, pageRequest);
        log.info("Got cart items for user : {} ", userEntity.getId());
        List<CartItem> cartItemList = cartItemPage.getContent();
        List<ItemEntity> items = cartItemList.stream().map(wishlistItem -> wishlistItem.getItemEntity()).collect(Collectors.toList());
        
        Page<ItemEntity> p = new PageImpl<>(items, PageRequest.of(pageNumber, size),cartItemPage.getTotalElements());
        return p;

    }

}
