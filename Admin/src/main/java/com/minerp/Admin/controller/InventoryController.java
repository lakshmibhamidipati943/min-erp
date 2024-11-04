package com.minerp.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minerp.Admin.DTO.ItemRequest;
import com.minerp.Admin.entity.Category;
import com.minerp.Admin.entity.Item;
import com.minerp.Admin.entity.Stock;
import com.minerp.Admin.entity.StockAdjustment;
import com.minerp.Admin.entity.StockTransfer;
import com.minerp.Admin.entity.UOM;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	Pageable pageable= PageRequest.of(0, 10);

	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/savecategory")
	public ResponseEntity<ServiceResponse<Category>> saveCategory(@RequestBody Category category, @RequestHeader("Authorization") String token){
		ServiceResponse<Category> response=inventoryService.saveCategory(category);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcategories")
	public ResponseEntity<ServiceResponse<List<Category>>> getAllCategories(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Category>> response=inventoryService.getAllCategories(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcategorybyid/{id}")
	public ResponseEntity<ServiceResponse<Category>> getCategoryById(@PathVariable("id") Long idCategory, @RequestHeader("Authorization") String token){
		ServiceResponse<Category> response=inventoryService.getCategoryById(idCategory);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getuoms")
	public ResponseEntity<ServiceResponse<List<UOM>>> getAllUOMs(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<UOM>> response=inventoryService.getAllUOMs(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getuombyid/{id}")
	public ResponseEntity<ServiceResponse<UOM>> getUOMById(@PathVariable("id") Long idUom, @RequestHeader("Authorization") String token){
		ServiceResponse<UOM> response=inventoryService.getUomById(idUom);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	
	@PostMapping("/saveitem")
	public ResponseEntity<ServiceResponse<Item>> saveItem(@RequestBody ItemRequest itemRequest, @RequestHeader("Authorization") String token){
		ServiceResponse<Item> response=inventoryService.saveItem(itemRequest);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getitems/{id}")
	public ResponseEntity<ServiceResponse<Item>> getItemById(@PathVariable("id") Long idItem, @RequestHeader("Authorization") String token){
		ServiceResponse<Item> response=inventoryService.getItemById(idItem);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getitemsbyvendorid/{vendorid}")
	public ResponseEntity<ServiceResponse<List<Item>>> getItemsByVendorId(@PathVariable("vendorid") Long vendorId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Item>> response=inventoryService.getItemsByVendorId(vendorId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	@GetMapping("/getitems")
	public ResponseEntity<ServiceResponse<List<Item>>> getAllItems(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Item>> response= inventoryService.getAllItems(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savestock")
	public ResponseEntity<ServiceResponse<Stock>> saveStock(@RequestBody Stock stock, @RequestHeader("Authorization") String token){
		ServiceResponse<Stock> response=inventoryService.saveStock(stock);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstockbyitem/{itemid}")
	public ResponseEntity<ServiceResponse<List<Stock>>> getStockByItemId(@PathVariable("itemid") Long itemId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Stock>> response=inventoryService.getStockByItemId(itemId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstock/{itemid}/{storeid}")
	public ResponseEntity<ServiceResponse<List<Stock>>> getStockByItemIdAndStoreId(@PathVariable("itemid") Long itemId, @PathVariable("storeid") Long storeId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Stock>> response=inventoryService.getStockByItemIdAndStoreId(itemId, storeId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstock")
	public ResponseEntity<ServiceResponse<List<Stock>>> getAllStock(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Stock>> response=inventoryService.getAllStock(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstockbystore/{storeid}")
	public ResponseEntity<ServiceResponse<List<Stock>>> getStockByStoreId(@PathVariable("storeid") Long storeId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Stock>> response=inventoryService.getStockByStoreId(storeId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savestockadjustment")
	public ResponseEntity<ServiceResponse<StockAdjustment>> saveStockAdjustement(@RequestBody StockAdjustment stockAdjustment, @RequestHeader("Authorization") String token){
		ServiceResponse<StockAdjustment> response=inventoryService.saveStockAdjustment(stockAdjustment, token);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savestocktransfer")
	public ResponseEntity<ServiceResponse<StockTransfer>> saveStockTransfer(@RequestBody StockTransfer stockTransfer, @RequestHeader("Authorization") String token){
		ServiceResponse<StockTransfer> response=inventoryService.saveStockTransfer(stockTransfer, token);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
}
