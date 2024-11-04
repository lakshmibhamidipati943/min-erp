package com.minerp.Admin.controller;

import java.util.Date;
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

import com.minerp.Admin.entity.GoodsReceivedNotes;
import com.minerp.Admin.entity.GoodsReceivedNotesItems;
import com.minerp.Admin.entity.PurchaseInvoice;
import com.minerp.Admin.entity.PurchaseOrder;
import com.minerp.Admin.entity.PurchaseOrderItems;
import com.minerp.Admin.entity.Vendor;
import com.minerp.Admin.entity.VendorItem;
import com.minerp.Admin.entity.VendorPayment;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	Pageable pageable=PageRequest.of(0, 10);
	
	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping("/savevendor")
	public ResponseEntity<ServiceResponse<Vendor>> saveVendor(@RequestBody Vendor vendor, @RequestHeader("Authorization") String token){
		ServiceResponse<Vendor> response=purchaseService.saveVendor(vendor,token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getvendors")
	public ResponseEntity<ServiceResponse<List<Vendor>>> getAllVendors(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Vendor>> response=purchaseService.getAllVendors(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getvendors/{id}")
	public ResponseEntity<ServiceResponse<Vendor>> getVendorById(@PathVariable("id") Long idVendor, @RequestHeader("Authorization") String token){
		ServiceResponse<Vendor> response=purchaseService.getVendorById(idVendor);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savevendoritems")
	public ResponseEntity<ServiceResponse<VendorItem>> saveVendorItems(@RequestBody VendorItem vendorItem, @RequestHeader("Authorization") String token){
		ServiceResponse<VendorItem> response=purchaseService.saveVendorItems(vendorItem);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getvitemsbyvid/{id}")
	public ResponseEntity<ServiceResponse<List<VendorItem>>> getVendorItemsByVendorId(@PathVariable("id") Long idVendor, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<VendorItem>> response=purchaseService.getVendorItemsByVendorId(idVendor, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
		
	@PostMapping("/savepurchaseorder")
	public ResponseEntity<ServiceResponse<PurchaseOrder>> savePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder, @RequestHeader("Authorization") String token){
		ServiceResponse<PurchaseOrder> response=purchaseService.savePurchaseOrder(purchaseOrder,token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getpurchaseorders")
	public ResponseEntity<ServiceResponse<List<PurchaseOrder>>> getAllPurchaseOrders(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseOrder>> response=purchaseService.getAllPurchaseOrders(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getpurchaseorders/{fromDate}/{toDate}")
	public ResponseEntity<ServiceResponse<List<PurchaseOrder>>> getBetweenPurchaseOrders(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseOrder>> response=purchaseService.getBetweenPurchaseOrders(fromDate, toDate, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getpurchaseordersbystoreid/{id}")
	public ResponseEntity<ServiceResponse<List<PurchaseOrder>>> getPurchaseOrdersByStoreId(@PathVariable("id") Long storeId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseOrder>> response=purchaseService.getPurchaseOrdersByStoreId(storeId, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getpurchaseorderbyid/{id}")
	public ResponseEntity<ServiceResponse<PurchaseOrder>> getPurchaseOrderById(@PathVariable("id") Long idPurchaseOrder, @RequestHeader("Authorization") String token){
		ServiceResponse<PurchaseOrder> response=purchaseService.getPurchaseOrderById(idPurchaseOrder);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getpoitemsbypoid/{id}")
	public ResponseEntity<ServiceResponse<List<PurchaseOrderItems>>> getPurchaseOrderItemsByPurchaseOrderId(@PathVariable("id") Long purchaseOrderId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseOrderItems>> response=purchaseService.getPurchaseOrderItemsByPurchaseOrderId(purchaseOrderId,pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getposbyvendorid/{id}")
	public ResponseEntity<ServiceResponse<List<PurchaseOrder>>> getPurchaseOrdersByVendorId(@PathVariable("id") Long vendorId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseOrder>> response=purchaseService.getPurchaseOrdersByVendorId(vendorId, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savegrn")
	public ResponseEntity<ServiceResponse<GoodsReceivedNotes>> saveGoodsReceivedNotes(@RequestBody GoodsReceivedNotes goodsRecievedNotes, @RequestHeader("Authorization") String token){
		ServiceResponse<GoodsReceivedNotes> response=purchaseService.saveGoodsReceivedNotes(goodsRecievedNotes, token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getgrns")
	public ResponseEntity<ServiceResponse<List<GoodsReceivedNotes>>> getAllGoodsReceivedNotes(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<GoodsReceivedNotes>> response=purchaseService.getAllGoodsReceivedNotes(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getgrnbyid/{id}")
	public ResponseEntity<ServiceResponse<GoodsReceivedNotes>> getGoodsReceivedNotesById(@PathVariable("id") Long idGoodsReceivedNotes, @RequestHeader("Authorization") String token){
		ServiceResponse<GoodsReceivedNotes> response=purchaseService.getGoodsReceivedNotesById(idGoodsReceivedNotes);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getgrns/{fromDate}/{toDate}")
	public ResponseEntity<ServiceResponse<List<GoodsReceivedNotes>>> getBetweenGoodsReceivedNotes(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<GoodsReceivedNotes>> response=purchaseService.getBetweenGoodsReceivedNotes(fromDate, toDate, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getgrnsbystoreid/{id}")
	public ResponseEntity<ServiceResponse<List<GoodsReceivedNotes>>> getGoodsReceivedNotesByStoreId(@PathVariable("id") Long storeId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<GoodsReceivedNotes>> response=purchaseService.getGoodsReceivedNotesByStoreId(storeId, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getgrnbyvendorid/{id}")
	public ResponseEntity<ServiceResponse<List<GoodsReceivedNotes>>> getGoodsReceivedNotesByVendorId(@PathVariable("id") Long vendorId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<GoodsReceivedNotes>> response=purchaseService.getGoodsReceivedNotesByVendorId(vendorId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getgrnitemsbygrnid/{id}")
	public ResponseEntity<ServiceResponse<List<GoodsReceivedNotesItems>>> getGoodsReceivedNotesItemsByGrnId(@PathVariable("id") Long grnId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<GoodsReceivedNotesItems>> response=purchaseService.getGoodsReceivedNotesItemsByGrnId(grnId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode()); 
	}
	
	@PostMapping("/savepurchaseinvoice")
	public ResponseEntity<ServiceResponse<PurchaseInvoice>> savePurchaseInvoice(@RequestBody PurchaseInvoice purchaseInvoice, @RequestHeader("Authorization") String token){
		ServiceResponse<PurchaseInvoice> response=purchaseService.savePurchaseInvoice(purchaseInvoice, token);
		return new ResponseEntity<>(response, response.getStatusCode()); 
	}
	
	@GetMapping("/getpurchaseinvoices")
	public ResponseEntity<ServiceResponse<List<PurchaseInvoice>>> getAllPurchaseInvoices(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseInvoice>> response=purchaseService.getAllPurchaseInvoices(pageable);
		return new ResponseEntity<>(response, response.getStatusCode()); 
	}
	
	@GetMapping("/getpibystoreid/{id}")
	public ResponseEntity<ServiceResponse<List<PurchaseInvoice>>> getPurchaseInvoicesByStoreId(@PathVariable("id") Long storeId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseInvoice>> response=purchaseService.getPurchaseInvoicesByStoreId(storeId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode()); 
	}
	
	@GetMapping("/getpibyid/{id}")
	public ResponseEntity<ServiceResponse<PurchaseInvoice>> getPurchaseInvoiceById(@PathVariable("id") Long idPurchaseInvoice, @RequestHeader("Authorization") String token){
		ServiceResponse<PurchaseInvoice> response= purchaseService.getPurchaseInvoicesById(idPurchaseInvoice);
		return new ResponseEntity<>(response, response.getStatusCode()); 
	}
	
	@GetMapping("/getpibyvendorid/{id}")
	public ResponseEntity<ServiceResponse<List<PurchaseInvoice>>> getPurchaseInvoiceByVendorId(@PathVariable("id") Long vendorId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseInvoice>> response=purchaseService.getPurchaseInvoiceByVendorId(vendorId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode()); 
	}
	
	@GetMapping("/getpurchaseivoices/{fromDate}/{toDate}")
	public ResponseEntity<ServiceResponse<List<PurchaseInvoice>>> getBetweenPurchaseInvoice(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PurchaseInvoice>> response=purchaseService.getBetweenPurchaseInvoice(fromDate, toDate, pageable);
		return new ResponseEntity<>(response, response.getStatusCode()); 
	}
	
	@PostMapping("/savevendorpayment")
	public ResponseEntity<ServiceResponse<VendorPayment>> saveVendorPayemt(@RequestBody VendorPayment vendorPayment, @RequestHeader("Authorization") String token){
		ServiceResponse<VendorPayment> response=purchaseService.saveVendorPayment(vendorPayment, token);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getvendorpayments")
	public ResponseEntity<ServiceResponse<List<VendorPayment>>> getVendorPayments(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<VendorPayment>> response=purchaseService.getVendorPayments(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getvendorpayments/{id}")
	public ResponseEntity<ServiceResponse<VendorPayment>> getVendorPaymentById(@PathVariable("id") Long idVendorPayment, @RequestHeader("Authorization") String token){
		ServiceResponse<VendorPayment> response=purchaseService.getVendorPaymentById(idVendorPayment);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getvpbyinvoiceid/{id}")
	public ResponseEntity<ServiceResponse<List<VendorPayment>>> getVendorPaymentByInvoiceId(@PathVariable("id") Long invoiceId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<VendorPayment>> response=purchaseService.getVendorPaymentByInvoiceId(invoiceId, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
 }
