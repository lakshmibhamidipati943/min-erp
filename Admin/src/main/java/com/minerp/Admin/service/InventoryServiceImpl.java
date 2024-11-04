package com.minerp.Admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.minerp.Admin.DTO.ItemRequest;
import com.minerp.Admin.entity.Category;
import com.minerp.Admin.entity.Item;
import com.minerp.Admin.entity.Stock;
import com.minerp.Admin.entity.StockAdjustment;
import com.minerp.Admin.entity.StockTransfer;
import com.minerp.Admin.entity.UOM;
import com.minerp.Admin.entity.User;
import com.minerp.Admin.entity.VendorItem;
import com.minerp.Admin.exception.InternalServerErrorException;
import com.minerp.Admin.exception.UnauthorizedException;
import com.minerp.Admin.repository.CategoryRepository;
import com.minerp.Admin.repository.ItemRepository;
import com.minerp.Admin.repository.StockAdjustmentRepository;
import com.minerp.Admin.repository.StockRepository;
import com.minerp.Admin.repository.StockTransferRepository;
import com.minerp.Admin.repository.UOMRepository;
import com.minerp.Admin.repository.UserRepository;
import com.minerp.Admin.repository.VendorItemRepository;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.security.JwtUtil;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UOMRepository uomRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private VendorItemRepository vendorItemRepository;
	
	@Autowired
	private StockAdjustmentRepository stockAdjustmentRepository;
	
	@Autowired
	private StockTransferRepository stockTransferRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ServiceResponse<Category> saveCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			Category savedCategory=categoryRepository.save(category);
			return new ServiceResponse<Category>(
				HttpStatus.CREATED,
				"Category saved successfully",
				List.of(savedCategory),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save category.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the category.");
		}
	}

	@Override
	public ServiceResponse<List<Category>> getAllCategories(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Category> categories=categoryRepository.getAllCategories(pageable);
			ServiceResponse<List<Category>> response= new ServiceResponse(
				HttpStatus.OK,
				"Category returned successfully",
				categories,
				(long) categories.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve category.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the category.");
		}	
	}

	@Override
	public ServiceResponse<Category> getCategoryById(Long idCategory) {
		// TODO Auto-generated method stub
		try {
			Category savedCategory=categoryRepository.getCategoryById(idCategory);
			return new ServiceResponse<Category>(
				HttpStatus.CREATED,
				"Category retrieved successfully",
				List.of(savedCategory),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve category.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieve the category.");
		}	
	}

	@Override
	public ServiceResponse<List<UOM>> getAllUOMs(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<UOM> uoms=uomRepository.getAllUOMs(pageable);
			ServiceResponse<List<UOM>> response= new ServiceResponse(
				HttpStatus.OK,
				"UOMs returned successfully",
				uoms,
				(long) uoms.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve UOM.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the UOM.");
		}
	}

	@Override
	public ServiceResponse<UOM> getUomById(Long idUom) {
		try {
			UOM uom=uomRepository.getUOMById(idUom);
			return new ServiceResponse<>(
				HttpStatus.CREATED,
				"UOM retrieved successfully",
				List.of(uom),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve category.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieve the category.");
		}	
	}

	@Override
	public ServiceResponse<Item> saveItem(ItemRequest itemRequest) {
		// TODO Auto-generated method stub
		try {
			Item savedItem=itemRepository.save(itemRequest.getItem());
			for(Long vendorId: itemRequest.getVendorIds()) {
				VendorItem vendorItem=new VendorItem();
				vendorItem.setVendorId(vendorId);
				vendorItem.setItemId(savedItem.getIdItem());
				vendorItemRepository.save(vendorItem);
			}
			return new ServiceResponse<>(
					HttpStatus.CREATED,
					"Item saved successfully",
					List.of(savedItem),
					1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save item.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the item.");
		}
		
	}

	@Override
	public ServiceResponse<Item> getItemById(Long idItem) {
		// TODO Auto-generated method stub
		try {
			Item item=itemRepository.getItemById(idItem);
			return new ServiceResponse<>(
					HttpStatus.OK,
					"Item retrieved successfully",
					List.of(item),
					1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve item.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retirieving the item.");
		}
	}

	@Override
	public ServiceResponse<List<Item>> getItemsByVendorId(Long vendorId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Item> items=itemRepository.getItemsByVendorId(vendorId, pageable);
			ServiceResponse<List<Item>> response= new ServiceResponse(
				HttpStatus.OK,
				"Items returned successfully",
				items,
				(long) items.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve Items.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the Items.");
		}	
	}

	@Override
	public ServiceResponse<List<Item>> getAllItems(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Item> items=itemRepository.getAllItems(pageable);
			ServiceResponse<List<Item>> response= new ServiceResponse(
				HttpStatus.OK,
				"Items returned successfully",
				items,
				(long) items.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve Items.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the Items.");
		}	
	}

	@Override
	public ServiceResponse<Stock> saveStock(Stock stock) {
		// TODO Auto-generated method stub
		try {
			Stock savedStock=stockRepository.save(stock);
			return new ServiceResponse<Stock>(
					HttpStatus.OK, "Stock saved successfully",
					List.of(savedStock),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save Stock.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the stock.");
		}	
	}

	@Override
	public ServiceResponse<List<Stock>> getStockByItemId(Long itemId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Stock> stocks=stockRepository.getStockByItemId(itemId, pageable);
			ServiceResponse<List<Stock>> response= new ServiceResponse(
				HttpStatus.OK,
				"Stock returned successfully",
				stocks,
				(long) stocks.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve Stock.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the Stock.");
		}		
	}

	@Override
	public ServiceResponse<List<Stock>> getStockByItemIdAndStoreId(Long itemId, Long storeId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Stock> stocks=stockRepository.getStockByItemIdAndStoreId(itemId, storeId, pageable);
			ServiceResponse<List<Stock>> response= new ServiceResponse(
				HttpStatus.OK,
				"Stock returned successfully",
				stocks,
				(long) stocks.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve Stock.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the Stock.");
		}	
	}

	@Override
	public ServiceResponse<List<Stock>> getAllStock(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Stock> stocks=stockRepository.getAllStock(pageable);
			ServiceResponse<List<Stock>> response= new ServiceResponse(
				HttpStatus.OK,
				"Stock returned successfully",
				stocks,
				(long) stocks.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve Stock.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the Stock.");
		}
	}

	@Override
	public ServiceResponse<List<Stock>> getStockByStoreId(Long storeId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Stock> stocks=stockRepository.getStockByStoreId(storeId, pageable);
			ServiceResponse<List<Stock>> response= new ServiceResponse(
				HttpStatus.OK,
				"Stock returned successfully",
				stocks,
				(long) stocks.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve Stock.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the Stock.");
		}	
	}

	@Override
	public ServiceResponse<StockAdjustment> saveStockAdjustment(StockAdjustment stockAdjustment, String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user= userRepository.findByUsername(username);
			stockAdjustment.setCreatedBy(user);
			StockAdjustment savedStockAdjustment=stockAdjustmentRepository.save(stockAdjustment);
			return new ServiceResponse<StockAdjustment>(
					HttpStatus.CREATED,
					"StockAdjustment saved successfully",
					List.of(savedStockAdjustment),
					1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save stockAdjustment.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the stockAdjustment.");
		}
	}

	@Override
	public ServiceResponse<StockTransfer> saveStockTransfer(StockTransfer stockTransfer, String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user= userRepository.findByUsername(username);
			stockTransfer.setCreatedBy(user);
			StockTransfer savedStockTransfer=stockTransferRepository.save(stockTransfer);
			return new ServiceResponse<StockTransfer>(
					HttpStatus.CREATED,
					"StockAdjustment saved successfully",
					List.of(savedStockTransfer),
					1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save stockTransfer.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the stockTransfer.");
		}	
	}
}
