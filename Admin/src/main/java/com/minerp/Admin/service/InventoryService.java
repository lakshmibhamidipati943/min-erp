package com.minerp.Admin.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.minerp.Admin.DTO.ItemRequest;
import com.minerp.Admin.entity.Category;
import com.minerp.Admin.entity.Item;
import com.minerp.Admin.entity.Stock;
import com.minerp.Admin.entity.StockAdjustment;
import com.minerp.Admin.entity.StockTransfer;
import com.minerp.Admin.entity.UOM;
import com.minerp.Admin.response.ServiceResponse;

public interface InventoryService {

	ServiceResponse<Category> saveCategory(Category category);

	ServiceResponse<List<Category>> getAllCategories(Pageable pageable);

	ServiceResponse<Category> getCategoryById(Long idCategory);

	ServiceResponse<List<UOM>> getAllUOMs(Pageable pageable);

	ServiceResponse<UOM> getUomById(Long idUom);

	ServiceResponse<Item> saveItem(ItemRequest itemRequest);

	ServiceResponse<Item> getItemById(Long idItem);

	ServiceResponse<List<Item>> getItemsByVendorId(Long vendorId, Pageable pageable);

	ServiceResponse<List<Item>> getAllItems(Pageable pageable);

	ServiceResponse<Stock> saveStock(Stock stock);

	ServiceResponse<List<Stock>> getStockByItemId(Long itemId, Pageable pageable);

	ServiceResponse<List<Stock>> getStockByItemIdAndStoreId(Long itemId, Long storeId, Pageable pageable);

	ServiceResponse<List<Stock>> getAllStock(Pageable pageable);

	ServiceResponse<List<Stock>> getStockByStoreId(Long storeId, Pageable pageable);

	ServiceResponse<StockAdjustment> saveStockAdjustment(StockAdjustment stockAdjustment, String token);

	ServiceResponse<StockTransfer> saveStockTransfer(StockTransfer stockTransfer, String token);

	

}
