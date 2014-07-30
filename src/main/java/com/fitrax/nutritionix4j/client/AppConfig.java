package com.fitrax.nutritionix4j.client;

public class AppConfig
{
	public final String baseUrl;

	public final int maxConnectionsPool;

	public static final AppConfig DEFAULT_CONFIG = new AppConfig(
			"http://api.nutritionix.com/v1_1/", 100);

	public AppConfig(String baseUrl, int maxConnectionsPool)
	{
		this.baseUrl = baseUrl;
		this.maxConnectionsPool = maxConnectionsPool;
	}

}