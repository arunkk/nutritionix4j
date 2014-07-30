package com.fitrax.nutritionix4j.client.caching;

import java.io.IOException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.cache.CachingHttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import com.fitrax.nutritionix4j.client.AppConfig;
import com.fitrax.nutritionix4j.client.Strategy;


/**
 * @author arunk
 * 
 */
public class CachingNutritionixProxy
{
	private static CachingNutritionixProxy instance = null;
	private final PoolingHttpClientConnectionManager cm;
	private final CloseableHttpClient httpclient;

	private Cache memoryOnlyCache;

	private CachingNutritionixProxy()
	{
		cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(100);

		httpclient = CachingHttpClientBuilder.create().setConnectionManager(cm).build();
		
		int cacheExpiry = AppConfig.cacheTtl;
		memoryOnlyCache = new Cache("nutritionix_cache", 200, false, false, cacheExpiry, cacheExpiry);
		EHCacheHelper.getInstance().getCacheManager().addCache(memoryOnlyCache);
		
		// Check for amsUri and throw Runtime Exception
		if ( AppConfig.baseUrl == null)
		{
			throw new RuntimeException(" Resource URL is null");
		}
	}

	public String getABTestResouce(String testName, String appId)
	{
		
		HttpGet httpget = null;

		try
		{
			String resourceUrl = new StringBuilder(AppConfig.baseUrl).append("/")
			        .append(appId).append("/").append(testName).append(".abtest").toString();
			
			URIBuilder uri = new URIBuilder(resourceUrl);
			
			httpget = new HttpGet(uri.build());

			HttpContext context = new BasicHttpContext();

			// execute the method
			HttpResponse response = httpclient.execute(httpget, context);

			// get the response body as an array of bytes
			HttpEntity entity = response.getEntity();
			if (entity != null)
			{
				String payload = EntityUtils.toString(entity);
				return payload;
			}

		} catch (Exception e)
		{
			if (httpget != null)
				httpget.abort();
			System.out.println(" - error: " + e);
		}

		return null;

	}

	public Strategy getABTestStrategy(String testName, String appId)
	{
		
		String compositeKey = testName.trim()+":"+appId.trim();
		
		// Check if the apiKey is found in the cache
		if ( memoryOnlyCache != null  && memoryOnlyCache.isKeyInCache(compositeKey) )
		{
			// get the Element
			Element ele = memoryOnlyCache.get(compositeKey);
			
			if ( ele != null && ele.isExpired() == false)
			{
				return (Strategy)memoryOnlyCache.get(compositeKey).getObjectValue();
			}
		}
		
		// Item is not Cache
		String payload = getABTestResouce(testName, appId);
		
		Strategy responseObject;
        try
        {
	        responseObject = new Strategy(payload);
	        if (responseObject != null)
			{
				// Put the item in the cache
				memoryOnlyCache.put(new Element(compositeKey, responseObject));
				
				return responseObject;
			}
        } catch (JSONException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        } catch (IOException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		return null;
		
	}
	
	public void shutdown()
	{
		try {
			httpclient.close();
			cm.shutdown();
			cm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static synchronized CachingNutritionixProxy getInstance()
	{
		if ( instance == null )
		{
			instance = new CachingNutritionixProxy();
		}
		return instance;
	}
}
