package com.fitrax.nutrionix4j.client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitrax.nutritionix4j.client.NutritionixClient;
import com.fitrax.nutritionix4j.client.NutritionixClientBuilder;
import com.fitrax.nutritionix4j.client.dto.Brand;
import com.fitrax.nutritionix4j.client.dto.Item;
import com.fitrax.nutritionix4j.client.dto.SearchResults;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class NutritionixProxyTest
{

	private static NutritionixClient proxy;
	private static WireMockServer wireMockServer;

	private static ObjectMapper objMapper = new ObjectMapper();

	@ClassRule
	public static WireMockRule wireMockRule = new WireMockRule(8089);

	@BeforeClass
	public static void beforeClass()
	{

		NutritionixClientBuilder builder = NutritionixClientBuilder
				.builder()
				.setBaseUrl("http://127.0.0.1:8089/v1_1")
				.setAppId(
						System.getenv("APPID") == null ? "mock" : System
								.getenv("APPID"))
				.setAppKey(
						System.getenv("APPKEY") == null ? "mock" : System
								.getenv("APPKEY"));

		proxy = builder.build();

	}

	@AfterClass
	public static void afterClass()
	{
		if (proxy != null)
			proxy.shutdown();

		proxy = null;

		if (wireMockServer != null)
			wireMockServer.stop();
		wireMockServer = null;

	}

	@BeforeClass
	public static void initializeMockUrls() throws JsonProcessingException
	{
		Item item = new Item();
		item.setItemId("test_item");

		stubFor(get(urlMatching("/v1_1/item.*")).willReturn(
				aResponse().withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody(objMapper.writeValueAsString(item))));

		Brand brand = new Brand();
		brand.setBrandId("test_brand");

		stubFor(get(urlMatching("/v1_1/brand/.*")).willReturn(
				aResponse().withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody(objMapper.writeValueAsString(brand))));

		SearchResults results = new SearchResults();
		results.setTotal_hits(100);
		brand.setBrandId("test_search");

		stubFor(get(urlMatching("/v1_1/search/.*")).willReturn(
				aResponse().withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody(objMapper.writeValueAsString(results))));

	}

	@Test
	public void testSearch()
	{
		SearchResults response = proxy.search("yogurt");

		assertNotNull(response);

		System.out.println(" Response is " + response);
	}

	@Test
	public void testItem() throws JsonProcessingException
	{

		Item response = proxy.item("513fc9cb673c4fbc2600536a", null, "*");

		assertNotNull(response);

		System.out.println(" Response is " + response);
	}

	@Test
	public void testBrand() throws Exception
	{
		Brand response = proxy.brand("513fbc1283aa2dc80c000053");

		assertNotNull(response);

		System.out.println(" Response is " + response);
	}

}
