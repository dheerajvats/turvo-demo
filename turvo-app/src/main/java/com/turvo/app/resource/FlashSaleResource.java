package com.turvo.app.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.app.dao.utils.Constants;
import com.turvo.app.dao.utils.Response;
import com.turvo.app.pojo.FlashSaleResponse;
import com.turvo.app.service.IFlashSaleService;

@RestController
@CrossOrigin
public class FlashSaleResource {
	
	@Autowired
	IFlashSaleService saleService;
	
	@PutMapping(value = "/startSale", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> startSale(@RequestParam String saleId, HttpServletRequest request) {
		
		saleService.startSale(saleId);
		
		FlashSaleResponse response = new FlashSaleResponse();
		response.setMessage(Constants.SALE_START_MESSAGE);
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/endSale", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> endSale(@RequestParam String saleId, HttpServletRequest request) {
		
		saleService.endSale(saleId);
		
		FlashSaleResponse response = new FlashSaleResponse();
		response.setMessage(Constants.SALE_STOP_MESSAGE);
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}


}
