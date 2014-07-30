package com.fitrax.nutrionix4j.client;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fitrax.nutritionix4j.client.NutritionixClient;
import com.fitrax.nutritionix4j.client.NutritionixClientBuilder;
import com.fitrax.nutritionix4j.client.NutritionixClientImpl;

public class NutritionixProxyTest
{

	private final static String appId = "0841abfa";
	private final static String appKey = "83c79fab0de91c3ce6ec1848e1aa0794";

	private static NutritionixClient proxy;

	@BeforeClass
	public static void beforeClass()
	{
		proxy = NutritionixClientBuilder.builder().setAppId(appId)
				.setAppKey(appKey).build();
	}

	@AfterClass
	public static void afterClass()
	{
		if (proxy != null)
			proxy.shutdown();

		proxy = null;
	}

	@Test
	public void testSearch()
	{
		String response = proxy.search("yogurt");

		assertNotNull(response);

		System.out.println(" Response is " + response);
	}

	@Test
	public void testSearchCache()
	{
		testSearch();
		testSearch();
		testSearch();
	}

	@Test
	public void testItem()
	{
		String response = proxy.item("513fc9cb673c4fbc2600536a", null, "*");

		assertNotNull(response);

		System.out.println(" Response is " + response);
	}

	@Test
	public void testBrand() throws Exception
	{
		String response = proxy.brand("513fbc1283aa2dc80c000053");

		assertNotNull(response);

		System.out.println(" Response is " + response);
	}

}
