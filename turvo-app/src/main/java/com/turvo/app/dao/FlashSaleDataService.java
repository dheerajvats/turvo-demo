package com.turvo.app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.dao.utils.SaleStatus;
import com.turvo.app.entity.FlashSale;
import com.turvo.app.repository.FlashSaleRepository;

@Service
public class FlashSaleDataService implements IFlashSaleDataService {
	
	@Autowired
	FlashSaleRepository repository;

	@Override
	public void startFlashSale(String flashSaleId) {
		Optional<FlashSale> sale = repository.findById(flashSaleId);
		FlashSale flashSale = sale.get();
		flashSale.setStatus(SaleStatus.ACTIVE);
		flashSale.setRegistrationOpen(Boolean.FALSE);
		repository.save(flashSale);
	}
	
	@Override
	public void endFlashSale(String flashSaleId) {
		Optional<FlashSale> sale = repository.findById(flashSaleId);
		FlashSale flashSale = sale.get();
		flashSale.setStatus(SaleStatus.ENDED);
		flashSale.setRegistrationOpen(Boolean.TRUE);
		repository.save(flashSale);
	}

}
