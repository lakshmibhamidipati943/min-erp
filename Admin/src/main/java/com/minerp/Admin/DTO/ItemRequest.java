package com.minerp.Admin.DTO;

import java.util.List;

import com.minerp.Admin.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

	private Item item;
	private List<Long> vendorIds;
}
