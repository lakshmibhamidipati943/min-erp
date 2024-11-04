package com.minerp.Admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
import com.minerp.Admin.entity.User;
import com.minerp.Admin.entity.Vendor;
import com.minerp.Admin.exception.InternalServerErrorException;
import com.minerp.Admin.exception.UnauthorizedException;
import com.minerp.Admin.repository.CustomerRepository;
import com.minerp.Admin.repository.UserRepository;
import com.minerp.Admin.repository.VendorRepository;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.security.JwtUtil;

@Service
public class SalesServiceImpl implements SalesService{

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ServiceResponse<Customer> saveCustomer(Customer customer, String token) {
		// TODO Auto-generated method stub
		try {
			String username=jwtUtil.extractUsername(token);
			User user= userRepository.findByUsername(username);
			customer.setCreatedBy(user);
			customer.setModifiedBy(user);
			Customer savedCustomer=customerRepository.save(customer);
			return new ServiceResponse<Customer>(
				HttpStatus.CREATED,
				"Customer saved successfully",
				List.of(savedCustomer),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save customer.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the customer.");
		}	}

	@Override
	public ServiceResponse<Customer> getCustomerById(Long idCustomer) {
		// TODO Auto-generated method stub
		try {
			Customer savedcustomer=customerRepository.getCustomerById(idCustomer);
			return new ServiceResponse<Customer>(
				HttpStatus.CREATED,
				"Customer retrieved successfully",
				List.of(savedcustomer),
				1L
			);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve customer.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the customer.");
		}	}

	@Override
	public ServiceResponse<List<Customer>> getAllCustomers(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Customer> customers=customerRepository.getAllCustomers(pageable);
			ServiceResponse<List<Customer>> response= new ServiceResponse(
				HttpStatus.OK,
				"Customers returned successfully",
				customers,
				(long) customers.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve customers.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the customers");
		}	}

	@Override
	public ServiceResponse<SalesOrder> saveSalesOrder(SalesOrder salesOrder, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesOrder>> getAllSalesOrder(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<SalesOrder> getSalesOrderById(Long idSalesOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesOrderItems>> getSalesOrderItemsBySalesOrderId(Long salesOrderId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesOrderAddress>> getSalesOrderAddressBySalesOrderId(Long salesOrderId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesOrder>> getSalesOrdersBetweenDates(Date fromDate, Date toDate, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<LogisticExpense>> getLogisticExpenseBySalesOrderId(Long salesOrderId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<DeliveryNotes> saveDeliveryNotes(DeliveryNotes deliveryNotes, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<DeliveryNotes>> getDeliveryNotes(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<DeliveryNotes> getDeliveryNotesById(Long idDeliveryNotes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<DeliveryNotesItems>> getDeliveryNotesItemsByDeliveryNotesId(Long deliveryNotesId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<DeliveryCharges>> getDeliveryChargesByDeliveryNotesId(Long deliveryNotesId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<SalesInvoice> saveSalesInvoice(SalesInvoice salesInvoice, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesInvoice>> getAllSalesInvoices(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesInvoice>> getSalesInvoicesBetweenDates(Date fromDate, Date toDate,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesInvoice>> getSalesInvoicesByCustomerId(Long customerId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<SalesInvoice> getSalesInvoiceById(Long idSalesInvoice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<SalesInvoice>> getSalesInvoiceByStoreId(Long storeId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<CustomerReceipts> saveCustomerReceipts(CustomerReceipts customerReceipts, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<CustomerReceipts>> getAllCustomerReceipts(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<CustomerReceipts> getCustoemrReceiptsById(Long idCustomerReceipts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<CustomerReceipts> getCustomerReceiptsByCustomerId(Long customerId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResponse<List<CustomerReceipts>> getCustomerReceiptsBetweenDates(Date fromDate, Date toDate,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
