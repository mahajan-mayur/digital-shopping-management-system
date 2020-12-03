package com.dsms.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.dsms.db.dao.ItemRepository;
import com.dsms.db.entity.ItemEntity;
import com.dsms.dto.ControllerResponse;
import com.dsms.dto.ControllerResponse.StatusCode;
import com.dsms.enums.ItemCategory;
import com.dsms.ui.event.model.AddItemEvent;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Mahaj
 */
@Slf4j
@Service
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    public ItemController() {

    }

    public Page<ItemEntity> getCategoryItems(ItemCategory itemCategory, Integer pageNumber, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size, Sort.by("name"));
        return itemRepository.findAllByItemCategory(itemCategory, pageRequest);
    }

    public ControllerResponse addItem(AddItemEvent addItemEvent) {
        File storageDir = new File(System.getProperty("user.home") + File.separator + "dsms"  );
        storageDir.mkdirs();
        File imgeFile = new File(storageDir.getAbsolutePath()+ File.separator + addItemEvent.getImageFile().getName());
        try {
            FileCopyUtils.copy(addItemEvent.getImageFile(),imgeFile );
        } catch (IOException ex) {
            log.error("Error in saving file");
            return ControllerResponse.builder().message("Error in item creation").statusCode(StatusCode.ERROR).build();
        }

        ItemEntity itemEntity = ItemEntity.builder().desciption(addItemEvent.getDescription())
                .imageUrl(imgeFile.getAbsolutePath())
                .itemCategory(addItemEvent.getItemCategory())
                .name(addItemEvent.getItemName())
                .price(addItemEvent.getItemPrice())
                .build();
        ItemEntity savedItem = itemRepository.save(itemEntity);
        if (savedItem != null) {
            return ControllerResponse.builder().message("item creation success").statusCode(StatusCode.SUCCESS).build();
        }
        return ControllerResponse.builder().message("Error in item creation").statusCode(StatusCode.ERROR).build();
    }
}
