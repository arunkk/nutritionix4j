package com.fitrax.nutritionix4j.client;

public class NutritionixClientBuilder
{
	private String baseUrl = "http://api.nutritionix.com/v1_1/";
	private int maxConnectionsPool = 100; // defaults
	private String appId;
	private String appKey;

	public static NutritionixClientBuilder builder()
	{
		return new NutritionixClientBuilder();
	}

	public NutritionixClientBuilder setAppId(String appId)
	{
		this.appId = appId;
		return this;
	}

	public NutritionixClientBuilder setAppKey(String appKey)
	{
		this.appKey = appKey;
		return this;
	}

	public NutritionixClientBuilder setMaxConnectionsPool(int maxConnectionsPool)
	{
		this.maxConnectionsPool = maxConnectionsPool;
		return this;
	}

	public NutritionixClientBuilder setBaseUrl(String baseUrl)
	{
		this.baseUrl = baseUrl;
		return this;
	}

	public NutritionixClient build()
	{
		return new NutritionixClientImpl(appId, appKey, baseUrl,
				maxConnectionsPool);
	}
}
