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

import com.minerp.Admin.entity.Customer;
import com.minerp.Admin.entity.CustomerReceipts;
import com.minerp.Admin.entity.DeliveryCharges;
import com.minerp.Admin.entity.DeliveryNotes;
import com.minerp.Admin.entity.DeliveryNotesItems;
import com.minerp.Admin.entity.LogisticExpense;
import com.minerp.Admin.entity.SalesInvoice;
import com.minerp.Admin.entity.SalesOrder;
import com.minerp.Admin.entity.SalesOrderAddress;
import com.minerp.Admin.entity.SalesOrderItems;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private SalesService salesService;
	
	Pageable pageable=PageRequest.of(0,10);
	
	@PostMapping("/savecustomer")
	public ResponseEntity<ServiceResponse<Customer>> saveCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String token){
		ServiceResponse<Customer> response=salesService.saveCustomer(customer,token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<ServiceResponse<Customer>> getCustomerById(@PathVariable("id") Long idCustomer, @RequestHeader("Authorization") String token){
		ServiceResponse<Customer> response=salesService.getCustomerById(idCustomer);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcustomers")
	public ResponseEntity<ServiceResponse<List<Customer>>> getAllCustomers(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Customer>> response=salesService.getAllCustomers(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savesalesorder")
	public ResponseEntity<ServiceResponse<SalesOrder>> saveSalesOrder(@RequestBody SalesOrder salesOrder, @RequestHeader("Authorization") String token){
		ServiceResponse<SalesOrder> response=salesService.saveSalesOrder(salesOrder,token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsalesorders")
	public ResponseEntity<ServiceResponse<List<SalesOrder>>> getAllSalesOrders(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesOrder>> response=salesService.getAllSalesOrder(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsalesorders/{id}")
	public ResponseEntity<ServiceResponse<SalesOrder>> getSalesOrderById(@PathVariable("id") Long idSalesOrder, @RequestHeader("Authorization") String token){
		ServiceResponse<SalesOrder> response=salesService.getSalesOrderById(idSalesOrder);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsoitemsbysoid/{id}")
	public ResponseEntity<ServiceResponse<List<SalesOrderItems>>> getSalesOrderItemsBySalesOrderId(@PathVariable("id") Long salesOrderId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesOrderItems>> response=salesService.getSalesOrderItemsBySalesOrderId(salesOrderId, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsoaddressbysoid/{id}")
	public ResponseEntity<ServiceResponse<List<SalesOrderAddress>>> getSalesOrderAddressBySalesOrderId(@PathVariable("id") Long salesOrderId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesOrderAddress>> response=salesService.getSalesOrderAddressBySalesOrderId(salesOrderId, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsalesorders/{fromDate}/{toDate}")
	public ResponseEntity<ServiceResponse<List<SalesOrder>>> getSalesOrdersBetweenDates(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesOrder>> response=salesService.getSalesOrdersBetweenDates(fromDate, toDate, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsolebysoid/{id}")
	public ResponseEntity<ServiceResponse<List<LogisticExpense>>> getLogisticExpenseBySalesOrderId(@PathVariable("id") Long salesOrderId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<LogisticExpense>> response=salesService.getLogisticExpenseBySalesOrderId(salesOrderId,pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/deliverynote")
	public ResponseEntity<ServiceResponse<DeliveryNotes>> saveDeliveryNotes(@RequestBody DeliveryNotes deliveryNotes, @RequestHeader("Authorization") String token){
		ServiceResponse<DeliveryNotes> response=salesService.saveDeliveryNotes(deliveryNotes,token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getdeliverynotes")
	public ResponseEntity<ServiceResponse<List<DeliveryNotes>>> getDeliveryNotes(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<DeliveryNotes>> response=salesService.getDeliveryNotes(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getdnbyid/{id}")
	public ResponseEntity<ServiceResponse<DeliveryNotes>> getDeliveryNotesById(@PathVariable("id") Long idDeliveryNotes, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<DeliveryNotes> response=salesService.getDeliveryNotesById(idDeliveryNotes);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getdnitemsbydnid/{id}")
	public ResponseEntity<ServiceResponse<List<DeliveryNotesItems>>> getDeliveryNotesItemsByDeliveryNotesId(@PathVariable("id") Long deliveryNotesId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<DeliveryNotesItems>> response=salesService.getDeliveryNotesItemsByDeliveryNotesId(deliveryNotesId,pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getdeliverychargesbydnid/{id}")
	public ResponseEntity<ServiceResponse<List<DeliveryCharges>>> getDeliveryChargesByDeliveryNotesId(@PathVariable("id") Long deliveryNotesId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<DeliveryCharges>> response=salesService.getDeliveryChargesByDeliveryNotesId(deliveryNotesId,pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savesalesinvoice")
	public ResponseEntity<ServiceResponse<SalesInvoice>> saveSalesInvoice(@RequestBody SalesInvoice salesInvoice, @RequestHeader("Authorization") String token){
		ServiceResponse<SalesInvoice> response=salesService.saveSalesInvoice(salesInvoice,token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsalesinvoices")
	public ResponseEntity<ServiceResponse<List<SalesInvoice>>> getAllSalesInvoices(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesInvoice>> response=salesService.getAllSalesInvoices(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsalesinvoices/{fromDate}/{toDate}")
	public ResponseEntity<ServiceResponse<List<SalesInvoice>>> getSalesInvoicesBetweenDates(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesInvoice>> response=salesService.getSalesInvoicesBetweenDates(fromDate, toDate, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsibycustomerid/{id}")
	public ResponseEntity<ServiceResponse<List<SalesInvoice>>> getSalesInvoicesByCustomerId(@PathVariable("id") Long customerId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesInvoice>> response=salesService.getSalesInvoicesByCustomerId(customerId, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsalesinvoices/{id}")
	public ResponseEntity<ServiceResponse<SalesInvoice>> getSalesInvoiceById(@PathVariable("id") Long idSalesInvoice, @RequestHeader("Authorization") String token){
		ServiceResponse<SalesInvoice> response=salesService.getSalesInvoiceById(idSalesInvoice);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getsibystoreid/{id}")
	public ResponseEntity<ServiceResponse<List<SalesInvoice>>> getSalesInvoiceByStoreId(@PathVariable("id") Long storeId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<SalesInvoice>> response=salesService.getSalesInvoiceByStoreId(storeId,pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savecustomerreceipts")
	public ResponseEntity<ServiceResponse<CustomerReceipts>> saveCustomerReceipts(@RequestBody CustomerReceipts customerReceipts, @RequestHeader("Authorization") String token){
		ServiceResponse<CustomerReceipts> response=salesService.saveCustomerReceipts(customerReceipts,token);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/customerreceipts")
	public ResponseEntity<ServiceResponse<List<CustomerReceipts>>> getAllCustomerReceipts(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<CustomerReceipts>> response=salesService.getAllCustomerReceipts(pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcustomerreceipts/{id}")
	public ResponseEntity<ServiceResponse<CustomerReceipts>> getCustomerReceiptsById(@PathVariable("id") Long idCustomerReceipts, @RequestHeader("Authorization") String token){
		ServiceResponse<CustomerReceipts> response=salesService.getCustoemrReceiptsById(idCustomerReceipts);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcrbycustomerid/{id}")
	public ResponseEntity<ServiceResponse<CustomerReceipts>> getCustomerReceiptsByCustomerId(@PathVariable("id") Long customerId, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<CustomerReceipts> response=salesService.getCustomerReceiptsByCustomerId(customerId, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcustomerreceipts/{fromDate}/{toDate}")
	public ResponseEntity<ServiceResponse<List<CustomerReceipts>>> getCustomerReceiptsBetweenDates(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<CustomerReceipts>> response=salesService.getCustomerReceiptsBetweenDates(fromDate, toDate, pageable);
        return new ResponseEntity<>(response, response.getStatusCode());
	}
}
