package com.fitrax.nutritionix4j.client;


public class AppConfig
{
	public static final String  baseUrl = "http://api.nutritionix.com/v1_1/";
	public static final boolean isCacheEnabled = true;
	public static final int cacheTtl = 2 * 60 * 60; // 2 Hrs
	
	public static final String ehCacheConfig = "ehcache-config.xml";
	public static final int maxConnectionsPool = 100;
	public static String appID = "0841abfa";
	public static String appKey = "83c79fab0de91c3ce6ec1848e1aa0794";
	
}