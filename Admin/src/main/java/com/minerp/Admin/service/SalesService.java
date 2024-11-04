package com.minerp.Admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

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

public interface SalesService {

	ServiceResponse<Customer> saveCustomer(Customer customer, String token);

	ServiceResponse<Customer> getCustomerById(Long idCustomer);

	ServiceResponse<List<Customer>> getAllCustomers(Pageable pageable);

	ServiceResponse<SalesOrder> saveSalesOrder(SalesOrder salesOrder, String token);

	ServiceResponse<List<SalesOrder>> getAllSalesOrder(Pageable pageable);

	ServiceResponse<SalesOrder> getSalesOrderById(Long idSalesOrder);

	ServiceResponse<List<SalesOrderItems>> getSalesOrderItemsBySalesOrderId(Long salesOrderId, Pageable pageable);

	ServiceResponse<List<SalesOrderAddress>> getSalesOrderAddressBySalesOrderId(Long salesOrderId, Pageable pageable);

	ServiceResponse<List<SalesOrder>> getSalesOrdersBetweenDates(Date fromDate, Date toDate, Pageable pageable);

	ServiceResponse<List<LogisticExpense>> getLogisticExpenseBySalesOrderId(Long salesOrderId, Pageable pageable);

	ServiceResponse<DeliveryNotes> saveDeliveryNotes(DeliveryNotes deliveryNotes, String token);

	ServiceResponse<List<DeliveryNotes>> getDeliveryNotes(Pageable pageable);

	ServiceResponse<DeliveryNotes> getDeliveryNotesById(Long idDeliveryNotes);

	ServiceResponse<List<DeliveryNotesItems>> getDeliveryNotesItemsByDeliveryNotesId(Long deliveryNotesId,
			Pageable pageable);

	ServiceResponse<List<DeliveryCharges>> getDeliveryChargesByDeliveryNotesId(Long deliveryNotesId, Pageable pageable);

	ServiceResponse<SalesInvoice> saveSalesInvoice(SalesInvoice salesInvoice, String token);

	ServiceResponse<List<SalesInvoice>> getAllSalesInvoices(Pageable pageable);

	ServiceResponse<List<SalesInvoice>> getSalesInvoicesBetweenDates(Date fromDate, Date toDate, Pageable pageable);

	ServiceResponse<List<SalesInvoice>> getSalesInvoicesByCustomerId(Long customerId, Pageable pageable);

	ServiceResponse<SalesInvoice> getSalesInvoiceById(Long idSalesInvoice);

	ServiceResponse<List<SalesInvoice>> getSalesInvoiceByStoreId(Long storeId, Pageable pageable);

	ServiceResponse<CustomerReceipts> saveCustomerReceipts(CustomerReceipts customerReceipts, String token);

	ServiceResponse<List<CustomerReceipts>> getAllCustomerReceipts(Pageable pageable);

	ServiceResponse<CustomerReceipts> getCustoemrReceiptsById(Long idCustomerReceipts);

	ServiceResponse<CustomerReceipts> getCustomerReceiptsByCustomerId(Long customerId, Pageable pageable);

	ServiceResponse<List<CustomerReceipts>> getCustomerReceiptsBetweenDates(Date fromDate, Date toDate,
			Pageable pageable);

}
