package com.fitrax.nutritionix4j.client.caching;

import com.fitrax.nutritionix4j.client.AppConfig;

import net.sf.ehcache.CacheManager;


public class EHCacheHelper
{
	private CacheManager cacheManager;

	// private constructor for singleton.
	private EHCacheHelper()
	{
		if (cacheManager == null)
		{
			cacheManager = CacheManager.create(EHCacheHelper.class.getResourceAsStream(AppConfig.ehCacheConfig));
		}
	}
	
	// factory to get the singleton instance.
	public static EHCacheHelper getInstance()
	{
		return SingletonHolder.instance;
	}
	
	public CacheManager getCacheManager()
	{
		return cacheManager;
	}
	
	// Holder pattern
	private static class SingletonHolder
	{
		public static EHCacheHelper instance;
		
		static
		{
			if (instance == null)
			{
				instance = new EHCacheHelper();
			}
		}
	}
}