package com.dsms.ui.event.model;

import com.dsms.enums.ItemCategory;
import java.io.File;
import java.util.EventObject;
import lombok.Builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItemEvent extends EventObject {

    private static final long serialVersionUID = -7817011625150819218L;

    private String itemName;
    private ItemCategory itemCategory;
    private Double itemPrice;
    private File imageFile;
    private String description;

    @Builder
    public AddItemEvent(Object source,String itemName, ItemCategory itemCategory, Double itemPrice, File imageFile, String description ) {
        super(source);
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.imageFile = imageFile;
        this.description = description;
    }

}
