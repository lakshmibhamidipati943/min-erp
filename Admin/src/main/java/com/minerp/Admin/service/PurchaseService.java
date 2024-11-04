package com.minerp.Admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.minerp.Admin.entity.GoodsReceivedNotes;
import com.minerp.Admin.entity.GoodsReceivedNotesItems;
import com.minerp.Admin.entity.PurchaseInvoice;
import com.minerp.Admin.entity.PurchaseOrder;
import com.minerp.Admin.entity.PurchaseOrderItems;
import com.minerp.Admin.entity.Vendor;
import com.minerp.Admin.entity.VendorItem;
import com.minerp.Admin.entity.VendorPayment;
import com.minerp.Admin.response.ServiceResponse;

public interface PurchaseService {

	ServiceResponse<Vendor> saveVendor(Vendor vendor,String token);
	
	ServiceResponse<List<Vendor>> getAllVendors(Pageable pageable);

	ServiceResponse<Vendor> getVendorById(Long idVendor);

	ServiceResponse<VendorItem> saveVendorItems(VendorItem vendorItem);

	ServiceResponse<List<VendorItem>> getVendorItemsByVendorId(Long idVendor, Pageable pageable);

	ServiceResponse<PurchaseOrder> savePurchaseOrder(PurchaseOrder purchaseOrder, String token);

	ServiceResponse<List<PurchaseOrder>> getAllPurchaseOrders(Pageable pageable);

	ServiceResponse<List<PurchaseOrder>> getBetweenPurchaseOrders(Date fromDate, Date toDate, Pageable pageable);

	ServiceResponse<List<PurchaseOrder>> getPurchaseOrdersByStoreId(Long storeId, Pageable pageable);

	ServiceResponse<PurchaseOrder> getPurchaseOrderById(Long idPurchaseOrder);

	ServiceResponse<List<PurchaseOrderItems>> getPurchaseOrderItemsByPurchaseOrderId(Long idPurchaseOrder,
			Pageable pageable);

	ServiceResponse<List<PurchaseOrder>> getPurchaseOrdersByVendorId(Long vendorId, Pageable pageable);

	ServiceResponse<GoodsReceivedNotes> saveGoodsReceivedNotes(GoodsReceivedNotes goodsRecievedNotes, String token);

	ServiceResponse<List<GoodsReceivedNotes>> getAllGoodsReceivedNotes(Pageable pageable);

	ServiceResponse<GoodsReceivedNotes> getGoodsReceivedNotesById(Long idGoodsReceivedNotes);

	ServiceResponse<List<GoodsReceivedNotes>> getBetweenGoodsReceivedNotes(Date fromDate, Date toDate,
			Pageable pageable);

	ServiceResponse<List<GoodsReceivedNotes>> getGoodsReceivedNotesByStoreId(Long storeId, Pageable pageable);

	ServiceResponse<List<GoodsReceivedNotes>> getGoodsReceivedNotesByVendorId(Long vendorId, Pageable pageable);

	ServiceResponse<List<GoodsReceivedNotesItems>> getGoodsReceivedNotesItemsByGrnId(Long grnId, Pageable pageable);

	ServiceResponse<PurchaseInvoice> savePurchaseInvoice(PurchaseInvoice purchaseInvoice, String token);

	ServiceResponse<List<PurchaseInvoice>> getAllPurchaseInvoices(Pageable pageable);

	ServiceResponse<List<PurchaseInvoice>> getPurchaseInvoicesByStoreId(Long storeId, Pageable pageable);

	ServiceResponse<PurchaseInvoice> getPurchaseInvoicesById(Long idPurchaseInvoice);

	ServiceResponse<List<PurchaseInvoice>> getPurchaseInvoiceByVendorId(Long vendorId, Pageable pageable);

	ServiceResponse<List<PurchaseInvoice>> getBetweenPurchaseInvoice(Date fromDate, Date toDate, Pageable pageable);

	ServiceResponse<VendorPayment> saveVendorPayment(VendorPayment vendorPayment, String token);

	ServiceResponse<List<VendorPayment>> getVendorPayments(Pageable pageable);

	ServiceResponse<VendorPayment> getVendorPaymentById(Long idVendorPayment);

	ServiceResponse<List<VendorPayment>> getVendorPaymentByInvoiceId(Long invoiceId, Pageable pageable);

}
