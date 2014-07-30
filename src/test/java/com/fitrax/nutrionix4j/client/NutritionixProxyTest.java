package com.fitrax.nutrionix4j.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fitrax.nutritionix4j.client.NutritionixProxy;

public class NutritionixProxyTest {

	@Test
	public void testSearch() {
		String response = NutritionixProxy.getInstance().search("yogurt");
		
		assertNotNull(response);
		
		System.out.println(" Response is " + response);
	}

	@Test
	public void testItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrand() {
		String response = NutritionixProxy.getInstance().brand("513fbc1283aa2dc80c000053");
		
		assertNotNull(response);
		
		System.out.println(" Response is " + response);
	}

}
