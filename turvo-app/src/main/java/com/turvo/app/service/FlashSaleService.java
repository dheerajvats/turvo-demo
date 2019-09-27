package com.turvo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.dao.IFlashSaleDataService;

@Service
public class FlashSaleService implements IFlashSaleService {

	@Autowired
	IFlashSaleDataService saleDataService;
	
	@Override
	public void startSale(String saleId) {
		
		saleDataService.startFlashSale(saleId);
		
	}

	@Override
	public void endSale(String saleId) {
		
		saleDataService.endFlashSale(saleId);
		
	}

}
