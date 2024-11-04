package com.minerp.Admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.minerp.Admin.entity.GoodsReceivedNotes;
import com.minerp.Admin.entity.GoodsReceivedNotesItems;
import com.minerp.Admin.entity.PurchaseInvoice;
import com.minerp.Admin.entity.PurchaseOrder;
import com.minerp.Admin.entity.PurchaseOrderItems;
import com.minerp.Admin.entity.StockTransfer;
import com.minerp.Admin.entity.User;
import com.minerp.Admin.entity.Vendor;
import com.minerp.Admin.entity.VendorItem;
import com.minerp.Admin.entity.VendorPayment;
import com.minerp.Admin.exception.InternalServerErrorException;
import com.minerp.Admin.exception.UnauthorizedException;
import com.minerp.Admin.repository.GoodsReceivedNotesItemsRepository;
import com.minerp.Admin.repository.GoodsReceivedNotesRepository;
import com.minerp.Admin.repository.PaymentModeRepository;
import com.minerp.Admin.repository.PurchaseInvoiceRepository;
import com.minerp.Admin.repository.PurchaseOrderItemsRepository;
import com.minerp.Admin.repository.PurchaseOrderRepository;
import com.minerp.Admin.repository.UserRepository;
import com.minerp.Admin.repository.VendorItemRepository;
import com.minerp.Admin.repository.VendorPaymentRepository;
import com.minerp.Admin.repository.VendorRepository;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.security.JwtUtil;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private VendorItemRepository vendorItemRepository;

	@Autowired
	private VendorPaymentRepository vendorPaymentRepository;
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private PurchaseOrderItemsRepository purchaseOrderItemsRepository;
	
	@Autowired
	private PurchaseInvoiceRepository purchaseInvoiceRepository;
	
	@Autowired
	private PaymentModeRepository paymentModeRepository;
	
	@Autowired
	private GoodsReceivedNotesRepository goodsReceivedNotesRepository;
	
	@Autowired
	private GoodsReceivedNotesItemsRepository goodsReceivedNotesItemsRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
		
	@Override
	public ServiceResponse<Vendor> saveVendor(Vendor vendor,String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user= userRepository.findByUsername(username);
			vendor.setCreatedBy(user);
			vendor.setModifiedBy(user);
			Vendor savedVendor=vendorRepository.save(vendor);
			return new ServiceResponse<Vendor>(
				HttpStatus.CREATED,
				"Vendor saved successfully",
				List.of(savedVendor),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save vendor.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the vendor.");
		}	
	}
	
	@Override
	public ServiceResponse<List<Vendor>> getAllVendors(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Vendor> vendors=vendorRepository.getAllVendors(pageable);
			ServiceResponse<List<Vendor>> response= new ServiceResponse(
				HttpStatus.OK,
				"Vendors returned successfully",
				vendors,
				(long) vendors.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve vendors.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the vendors");
		}		
	}

	@Override
	public ServiceResponse<Vendor> getVendorById(Long idVendor) {
		// TODO Auto-generated method stub
		try {
			Vendor savedVendor=vendorRepository.getVendorById(idVendor);
			return new ServiceResponse<Vendor>(
				HttpStatus.CREATED,
				"Vendor retrieved successfully",
				List.of(savedVendor),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve vendor.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the vendor.");
		}	
	}

	@Override
	public ServiceResponse<VendorItem> saveVendorItems(VendorItem vendorItem) {
		// TODO Auto-generated method stub
		try {
			VendorItem savedVendorItem=vendorItemRepository.save(vendorItem);
			return new ServiceResponse<VendorItem>(
				HttpStatus.CREATED,
				"VendorItem saved successfully",
				List.of(savedVendorItem),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save vendorItem.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the vendorItem.");
		}	
	}

	@Override
	public ServiceResponse<List<VendorItem>> getVendorItemsByVendorId(Long idVendor, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<VendorItem> vendorItems=vendorItemRepository.getVendorItemsByVendorId(idVendor,pageable);
			ServiceResponse<List<VendorItem>> response= new ServiceResponse(
				HttpStatus.OK,
				"VendorItem returned successfully",
				vendorItems,
				(long) vendorItems.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve vendorItem.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the vendorItem.");
		}	
	}

	@Override
	public ServiceResponse<PurchaseOrder> savePurchaseOrder(PurchaseOrder purchaseOrder, String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user= userRepository.findByUsername(username);
			purchaseOrder.setCreatedBy(user);
			purchaseOrder.setModifiedBy(user);
			PurchaseOrder savedPurchaseOrder=purchaseOrderRepository.save(purchaseOrder);
			return new ServiceResponse<PurchaseOrder>(
				HttpStatus.CREATED,
				"PurchaseOrder saved successfully",
				List.of(savedPurchaseOrder),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save purchaseOrder.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the purchaseOrder.");
		}	
	}

	@Override
	public ServiceResponse<List<PurchaseOrder>> getAllPurchaseOrders(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseOrder> savedPurchaseOrder=purchaseOrderRepository.getAllPurchaseOrders(pageable);
			ServiceResponse<List<PurchaseOrder>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseOrder retrieved successfully",
				savedPurchaseOrder,
				(long) savedPurchaseOrder.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve purchaseOrder.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the purchaseOrder.");
		}	
	}	

	@Override
	public ServiceResponse<List<PurchaseOrder>> getBetweenPurchaseOrders(Date fromDate, Date toDate,
			Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseOrder> savedPurchaseOrder=purchaseOrderRepository.getBetweenPurchaseOrders(fromDate, toDate,pageable);
			ServiceResponse<List<PurchaseOrder>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseOrder retrieved successfully",
				savedPurchaseOrder,
				(long) savedPurchaseOrder.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve purchaseOrder.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the purchaseOrder.");
		}	
	}

	@Override
	public ServiceResponse<List<PurchaseOrder>> getPurchaseOrdersByStoreId(Long storeId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseOrder> savedPurchaseOrder=purchaseOrderRepository.getPurchaseOrdersByStoreId(storeId, pageable);
			ServiceResponse<List<PurchaseOrder>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseOrder retrieved successfully",
				savedPurchaseOrder,
				(long) savedPurchaseOrder.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve purchaseOrder.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the purchaseOrder.");
		}	
	}

	@Override
	public ServiceResponse<PurchaseOrder> getPurchaseOrderById(Long idPurchaseOrder) {
		// TODO Auto-generated method stub
		try {
			PurchaseOrder savedPurchaseOrder=purchaseOrderRepository.getPurchaseOrderById(idPurchaseOrder);
			return new ServiceResponse<PurchaseOrder>(
				HttpStatus.CREATED,
				"PurchaseOrder retrieved successfully",
				List.of(savedPurchaseOrder),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve purchaseOrder.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the purchaseOrder.");
		}	}

	@Override
	public ServiceResponse<List<PurchaseOrderItems>> getPurchaseOrderItemsByPurchaseOrderId(Long purchaseOrderId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseOrderItems> savedPurchaseOrderItems=purchaseOrderItemsRepository.getPurchaseOrderItemsByPurchaseOrderId(purchaseOrderId, pageable);
			ServiceResponse<List<PurchaseOrderItems>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseOrderItems retrieved successfully",
				savedPurchaseOrderItems,
				(long) savedPurchaseOrderItems.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve purchaseOrderItems.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the purchaseOrderItems.");
		}		
	}

	@Override
	public ServiceResponse<List<PurchaseOrder>> getPurchaseOrdersByVendorId(Long vendorId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseOrder> savedPurchaseOrders=purchaseOrderRepository.getPurchaseOrdersByVendorId(vendorId, pageable);
			ServiceResponse<List<PurchaseOrder>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseOrder retrieved successfully",
				savedPurchaseOrders,
				(long) savedPurchaseOrders.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve purchaseOrder.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the purchaseOrder.");
		}	
	}

	@Override
	public ServiceResponse<GoodsReceivedNotes> saveGoodsReceivedNotes(GoodsReceivedNotes goodsRecievedNotes, String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user= userRepository.findByUsername(username);
			goodsRecievedNotes.setCreatedBy(user);
			goodsRecievedNotes.setModifiedBy(user);
			GoodsReceivedNotes savedGoodsReceivedNotes=goodsReceivedNotesRepository.save(goodsRecievedNotes);
			return new ServiceResponse<GoodsReceivedNotes>(
				HttpStatus.CREATED,
				"GoodsReceivedNotes saved successfully",
				List.of(savedGoodsReceivedNotes),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save purchaseOrder.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the purchaseOrder.");
		}	
	}

	@Override
	public ServiceResponse<List<GoodsReceivedNotes>> getAllGoodsReceivedNotes(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<GoodsReceivedNotes> savedGoodsReceivedNotes=goodsReceivedNotesRepository.getAllGoodsReceivedNotes(pageable);
			ServiceResponse<List<GoodsReceivedNotes>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"GoodsReceivedNotes retrieved successfully",
				savedGoodsReceivedNotes,
				(long) savedGoodsReceivedNotes.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve GoodsReceivedNotes.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the GoodsReceivedNotes.");
		}	
	}

	@Override
	public ServiceResponse<GoodsReceivedNotes> getGoodsReceivedNotesById(Long idGoodsReceivedNotes) {
		// TODO Auto-generated method stub
		try {
			GoodsReceivedNotes savedGoodsReceivedNotes=goodsReceivedNotesRepository.getAllGoodsReceivedNotes(idGoodsReceivedNotes);
			return new ServiceResponse<GoodsReceivedNotes>(
				HttpStatus.CREATED,
				"GoodsReceivedNotes retrieved successfully",
				List.of(savedGoodsReceivedNotes),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve GoodsReceivedNotes.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the GoodsReceivedNotes.");
		}	
	}

	@Override
	public ServiceResponse<List<GoodsReceivedNotes>> getBetweenGoodsReceivedNotes(Date fromDate, Date toDate,
			Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<GoodsReceivedNotes> savedGoodsReceivedNotes=goodsReceivedNotesRepository.getBetweenGoodsReceivedNotes(fromDate, toDate, pageable);
			ServiceResponse<List<GoodsReceivedNotes>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"GoodsReceivedNotes retrieved successfully",
				savedGoodsReceivedNotes,
				(long) savedGoodsReceivedNotes.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve GoodsReceivedNotes.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the GoodsReceivedNotes.");
		}	
	}

	@Override
	public ServiceResponse<List<GoodsReceivedNotes>> getGoodsReceivedNotesByStoreId(Long storeId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<GoodsReceivedNotes> savedGoodsReceivedNotes=goodsReceivedNotesRepository.getGoodsReceivedNotesByStoreId(storeId, pageable);
			ServiceResponse<List<GoodsReceivedNotes>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"GoodsReceivedNotes retrieved successfully",
				savedGoodsReceivedNotes,
				(long) savedGoodsReceivedNotes.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve GoodsReceivedNotes.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the GoodsReceivedNotes.");
		}	
	}

	@Override
	public ServiceResponse<List<GoodsReceivedNotes>> getGoodsReceivedNotesByVendorId(Long vendorId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<GoodsReceivedNotes> savedGoodsReceivedNotes=goodsReceivedNotesRepository.getGoodsReceivedNotesByVendorId(vendorId, pageable);
			ServiceResponse<List<GoodsReceivedNotes>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"GoodsReceivedNotes retrieved successfully",
				savedGoodsReceivedNotes,
				(long) savedGoodsReceivedNotes.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve GoodsReceivedNotes.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the GoodsReceivedNotes.");
		}	
	}

	@Override
	public ServiceResponse<List<GoodsReceivedNotesItems>> getGoodsReceivedNotesItemsByGrnId(Long grnId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<GoodsReceivedNotesItems> savedGoodsReceivedNotesItems=goodsReceivedNotesItemsRepository.getGoodsReceivedNotesItemsByGrnId(grnId, pageable);
			ServiceResponse<List<GoodsReceivedNotesItems>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"GoodsReceivedNotesItems retrieved successfully",
				savedGoodsReceivedNotesItems,
				(long) savedGoodsReceivedNotesItems.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve GoodsReceivedNotesItems.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the GoodsReceivedNotesItems.");
		}	
	}

	@Override
	public ServiceResponse<PurchaseInvoice> savePurchaseInvoice(PurchaseInvoice purchaseInvoice, String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user=userRepository.findByUsername(username);
			purchaseInvoice.setCreatedBy(user);
			purchaseInvoice.setModifiedBy(user);
			PurchaseInvoice savedPurchaseInvoice=purchaseInvoiceRepository.save(purchaseInvoice);
			return new ServiceResponse<PurchaseInvoice>(
				HttpStatus.CREATED,
				"PurchaseInvoice saved successfully",
				List.of(savedPurchaseInvoice),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save purchaseInvoice.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the purchaseInvoice.");
		}	
	}

	@Override
	public ServiceResponse<List<PurchaseInvoice>> getAllPurchaseInvoices(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseInvoice> savedPurchaseInvoices=purchaseInvoiceRepository.getAllPurchaseInvoices(pageable);
			ServiceResponse<List<PurchaseInvoice>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseInvoices retrieved successfully",
				savedPurchaseInvoices,
				(long) savedPurchaseInvoices.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve PurchaseInvoices.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the PurchaseInvoices.");
		}	
	}

	@Override
	public ServiceResponse<List<PurchaseInvoice>> getPurchaseInvoicesByStoreId(Long storeId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseInvoice> savedPurchaseInvoices=purchaseInvoiceRepository.getPurchaseInvoicesByStoreId(storeId, pageable);
			ServiceResponse<List<PurchaseInvoice>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseInvoices retrieved successfully",
				savedPurchaseInvoices,
				(long) savedPurchaseInvoices.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve PurchaseInvoices.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the PurchaseInvoices.");
		}	
	}

	@Override
	public ServiceResponse<PurchaseInvoice> getPurchaseInvoicesById(Long idPurchaseInvoice) {
		// TODO Auto-generated method stub
		try {
			PurchaseInvoice savedPurchaseInvoice=purchaseInvoiceRepository.getPurchaseInvoicesById(idPurchaseInvoice);
			return new ServiceResponse<PurchaseInvoice>(
				HttpStatus.CREATED,
				"PurchaseInvoice retrieved successfully",
				List.of(savedPurchaseInvoice),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieved purchaseInvoice.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the purchaseInvoice.");
		}	
	}
	
	@Override
	public ServiceResponse<List<PurchaseInvoice>> getPurchaseInvoiceByVendorId(Long vendorId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseInvoice> savedPurchaseInvoices=purchaseInvoiceRepository.getPurchaseInvoiceByVendorId(vendorId, pageable);
			ServiceResponse<List<PurchaseInvoice>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseInvoices retrieved successfully",
				savedPurchaseInvoices,
				(long) savedPurchaseInvoices.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve PurchaseInvoices.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the PurchaseInvoices.");
		}	
	}

	@Override
	public ServiceResponse<List<PurchaseInvoice>> getBetweenPurchaseInvoice(Date fromDate, Date toDate,
			Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PurchaseInvoice> savedPurchaseInvoices=purchaseInvoiceRepository.getBetweenPurchaseInvoice(fromDate, toDate, pageable);
			ServiceResponse<List<PurchaseInvoice>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"PurchaseInvoices retrieved successfully",
				savedPurchaseInvoices,
				(long) savedPurchaseInvoices.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve PurchaseInvoices.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the PurchaseInvoices.");
		}	
	}

	@Override
	public ServiceResponse<VendorPayment> saveVendorPayment(VendorPayment vendorPayment,String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user=userRepository.findByUsername(username);
			vendorPayment.setCreatedBy(user);
			VendorPayment savedVendorPayment=vendorPaymentRepository.save(vendorPayment);
			return new ServiceResponse<VendorPayment>(
				HttpStatus.CREATED,
				"VendorPayments saved successfully",
				List.of(savedVendorPayment),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save vendorPayment.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the vendorPayment.");
		}	
	}

	@Override
	public ServiceResponse<List<VendorPayment>> getVendorPayments(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<VendorPayment> savedVendorPayments=vendorPaymentRepository.getVendorPayments(pageable);
			ServiceResponse<List<VendorPayment>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"VendorPayment retrieved successfully",
				savedVendorPayments,
				(long) savedVendorPayments.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve VendorPayments.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the VendorPayments.");
		}	
	}

	@Override
	public ServiceResponse<VendorPayment> getVendorPaymentById(Long idVendorPayment) {
		// TODO Auto-generated method stub
		try {
			VendorPayment savedVendorPayments=vendorPaymentRepository.getVendorPaymentById(idVendorPayment);
			return new ServiceResponse<VendorPayment>(
				HttpStatus.CREATED,
				"VendorPayment retrieved successfully",
				List.of(savedVendorPayments),
				1L	
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve VendorPayments.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the VendorPayments.");
		}		
	}

	@Override
	public ServiceResponse<List<VendorPayment>> getVendorPaymentByInvoiceId(Long invoiceId, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<VendorPayment> savedVendorPayments=vendorPaymentRepository.getVendorPaymentByInvoiceId(invoiceId,pageable);
			ServiceResponse<List<VendorPayment>> response= new ServiceResponse(
				HttpStatus.CREATED,
				"VendorPayment retrieved successfully",
				savedVendorPayments,
				(long) savedVendorPayments.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve VendorPayments.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the VendorPayments.");
		}	
	}	
}
