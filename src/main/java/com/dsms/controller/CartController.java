package com.dsms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsms.db.dao.CartItemRepository;
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
		CartItem cartItem;
		cartItem = cartItemRepository.findByUserEntityAndItemEntity(userEntity, itemEntity);
		if (cartItem == null) {
			cartItem = CartItem.builder().itemCount(itemCount).itemEntity(itemEntity).userEntity(userEntity).build();
		}
		cartItem.setItemCount(itemCount);
		CartItem savedEntity = cartItemRepository.save(cartItem);
		log.info("itemId : {} is added in cartItem for userId : {} savedEntuty id : {} ", itemEntity.getId(),
				userEntity.getId(), savedEntity.getId());
		return ControllerResponse.builder().message("added to cart").statusCode(StatusCode.SUCCESS).build();

	}

}
