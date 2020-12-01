/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.event.model;

import java.util.EventObject;

import com.dsms.enums.ItemCategory;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mahaj
 */
@Getter
@Setter
public class CategoryEvent extends EventObject {

	private static final long serialVersionUID = -1155144208841928378L;

	private ItemCategory selectedItemCategory;

	public CategoryEvent(Object source) {
		super(source);

	}

	@Builder
	public CategoryEvent(Object source, ItemCategory selectedItemCategory) {
		super(source);
		this.selectedItemCategory = selectedItemCategory;
	}

}
