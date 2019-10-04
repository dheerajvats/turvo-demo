package com.turvo.app;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.turvo.app.dao.FlashSaleDataService;
import com.turvo.app.dao.RegistrationDataService;
import com.turvo.app.entity.FlashSale;
import com.turvo.app.entity.Registration;
import com.turvo.app.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

	@InjectMocks
	private RegistrationService registrationService;

	@Mock
	RegistrationDataService regDataService;

	@Mock
	FlashSaleDataService flashSaleDataService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegisterForSale() {
		Registration registration = new Registration();
		when(regDataService.registerForSale(registration)).thenReturn(2d);
		Assert.assertEquals((double) (regDataService.registerForSale(registration)), 2d, 0.001);
	}

	@Test
	public void testCheckRegistrationEligibility() {

		FlashSale sale = new FlashSale();
		sale.setRegistrationOpen(Boolean.TRUE);
		when(flashSaleDataService.findBySaleId("sale1")).thenReturn(sale);

		List<Registration> reg = new ArrayList<>();
		when(regDataService.findByCustomerAndSaleId("110001", "sale1")).thenReturn(reg);

		Assert.assertEquals(flashSaleDataService.findBySaleId("sale1").getRegistrationOpen()
				&& regDataService.findByCustomerAndSaleId("110001", "sale1").isEmpty(), Boolean.TRUE);

	}

}
