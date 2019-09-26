package com.turvo.app.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.app.dao.utils.Constants;
import com.turvo.app.dao.utils.Response;
import com.turvo.app.pojo.OrderResponse;
import com.turvo.app.pojo.PurchaseOrderRequest;
import com.turvo.app.service.IPurchaseOrderService;

@RestController
@CrossOrigin
public class PurchaseOrderResource {
	
	@Autowired
	IPurchaseOrderService orderService;
	
	@PostMapping(value = "/orderProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> orderProduct(@RequestBody PurchaseOrderRequest orderRequest, HttpServletRequest request) {
				
		OrderResponse response = orderService.placeOrder(orderRequest);
		
		if(response.getMessage().equals(Constants.ORDER_SUCCESS_MESSAGE)) {
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
