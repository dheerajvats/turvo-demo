package com.turvo.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.dao.ICountersDataService;
import com.turvo.app.dao.IFlashSaleDataService;
import com.turvo.app.dao.IInventoryDataService;
import com.turvo.app.dao.IPurchaseOrderDataService;
import com.turvo.app.dao.IRegistrationDataService;
import com.turvo.app.dao.utils.Constants;
import com.turvo.app.dao.utils.OrderStatus;
import com.turvo.app.dao.utils.RegistrationStatus;
import com.turvo.app.dao.utils.SaleStatus;
import com.turvo.app.entity.FlashSale;
import com.turvo.app.entity.PurchaseOrder;
import com.turvo.app.entity.Registration;
import com.turvo.app.pojo.OrderResponse;
import com.turvo.app.pojo.PurchaseOrderRequest;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {
	
	@Autowired
	IInventoryDataService inventoryDataService;
	
	@Autowired
	IRegistrationDataService regDataService;
	
	@Autowired
	ICountersDataService counterDataService;
	
	@Autowired
	IPurchaseOrderDataService orderDataService;
	
	@Autowired
	IFlashSaleDataService saleDataService;

	@Override
	public OrderResponse placeOrder(PurchaseOrderRequest orderRequest) {
		OrderResponse response = new OrderResponse();
		if (checkSaleActive(orderRequest.getSaleId()) && checkInventory(orderRequest.getProductId())
				&& checkRegistration(orderRequest.getCustomerId(), orderRequest.getSaleId())) {
			updateInventory(orderRequest.getProductId());
			PurchaseOrder order = saveOrder(orderRequest);
			updateRegistrationStatus(orderRequest.getCustomerId(), orderRequest.getSaleId());
			response.setMessage(Constants.ORDER_SUCCESS_MESSAGE);
			response.setOrderId(order.getOrderId());
			response.setProductId(order.getProductId());
			response.setStatus(order.getOrderStatus().toString());
		} else {
			response.setMessage(Constants.ORDER_ERROR_MESSAGE);
		}
		return response;
	}
	
	private Boolean checkInventory(Double productId) {
		Double quantity = 0d;
		quantity = inventoryDataService.returnProductInventory(productId);
		return quantity > 0d;
	}
	
	private Boolean checkSaleActive(String saleId) {
		FlashSale sale = saleDataService.findBySaleId(saleId);
		if(sale.getStatus().equals(SaleStatus.ACTIVE)) {
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	}
	
	private Boolean checkRegistration(String customerId, String saleId) {
		List<Registration> registration  = regDataService.findByCustomerAndSaleId(customerId, saleId);
		return registration.size()==1;
	}
	
	private void updateRegistrationStatus(String customerId, String saleId) {
		RegistrationStatus status = RegistrationStatus.USED;
		regDataService.updateRegistrationStatus(customerId, saleId, status);
	}
	
	private Double updateInventory(Double productId) {
		return inventoryDataService.decreaseInventory(productId);
	}
	
	private PurchaseOrder saveOrder(PurchaseOrderRequest orderRequest) {
		PurchaseOrder order = purchaseOrderDAOConvertor(orderRequest);
		return orderDataService.saveOrder(order);
	}
	
	private PurchaseOrder purchaseOrderDAOConvertor(PurchaseOrderRequest orderRequest) {
		PurchaseOrder order = new PurchaseOrder();
		order.setCustomerId(orderRequest.getCustomerId());
		order.setLastUpdated(new Date());
		order.setOrderedAt(new Date());
		order.setOrderId(counterDataService.getNextValue("orderid"));
		order.setProductId(orderRequest.getProductId());
		order.setOrderStatus(OrderStatus.PROCESSED);
		return order;
	}
}
