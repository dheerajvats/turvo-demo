package com.turvo.app.dao;

import com.turvo.app.entity.FlashSale;

public interface IFlashSaleDataService {
	
	public void startFlashSale(String flashSaleId);
	
	public void endFlashSale(String flashSaleId);
	
	public FlashSale findBySaleId(String saleId);

}
