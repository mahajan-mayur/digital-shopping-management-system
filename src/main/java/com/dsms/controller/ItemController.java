package com.dsms.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.dsms.beans.ContextProvider;
import com.dsms.db.dao.ItemRepository;
import com.dsms.db.entity.ItemEntity;
import com.dsms.enums.ItemCategory;

/**
 *
 * @author Mahaj
 */
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController() {
    	itemRepository = ContextProvider.getBean(ItemRepository.class);
    }

  	public Page<ItemEntity> getCategoryItems(ItemCategory itemCategory, Integer pageNumber, Integer size) {
  		PageRequest pageRequest = PageRequest.of(pageNumber, size, Sort.by("name"));
  		return itemRepository.findAllByItemCategory(itemCategory, pageRequest);
  	}
}
