package com.fitrax.nutritionix4j.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.cache.CachingHttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;


/**
 * @author arunk
 * 
 */
public class NutritionixProxy
{
	private static NutritionixProxy instance = null;
	private final PoolingHttpClientConnectionManager cm;
	private final CloseableHttpClient httpclient;

	private final String appId,appKey;
	
	private NutritionixProxy()
	{
		cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(AppConfig.maxConnectionsPool);

		httpclient = CachingHttpClientBuilder.create().setConnectionManager(cm).build();
		
		if ( AppConfig.baseUrl == null)
		{
			throw new RuntimeException(" Resource URL is null");
		}
		
		this.appId = AppConfig.appID;
		this.appKey = AppConfig.appKey;
	}
	
	public String search(String phrase)
	{
		return search(phrase,null,-1,-1,null,"*");
	}

	public String search(String phrase, String brand_id, int calorie_max,int calorie_min, String resultsPage, String fields)
	{
		
		HttpGet httpget = null;

		try
		{
			String resourceUrl = new StringBuilder(AppConfig.baseUrl).append("/search").toString();
			
			URIBuilder uri = new URIBuilder(resourceUrl);
			
			// set all the params
			uri.addParameter("phrase", phrase);
			if ( calorie_max > 0) uri.addParameter("calorie_max", Integer.toString(calorie_max));
			if ( calorie_min > 0) uri.addParameter("calorie_min", Integer.toString(calorie_min));
			if ( brand_id != null) uri.addParameter("brand_id", brand_id);
			if ( resultsPage != null) uri.addParameter("resultsPage", resultsPage);
			
			if ( fields != null) uri.addParameter("fields", resultsPage);
			
			
			httpget = new HttpGet(uri.build());

			HttpContext context = new BasicHttpContext();

			// execute the method
			HttpResponse response = httpclient.execute(httpget, context);

			// get the response body as an array of bytes
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity != null)
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


	public String item(String id,String upc, String fields)
	{
		
		HttpGet httpget = null;

		try
		{
			String resourceUrl = new StringBuilder(AppConfig.baseUrl).append("/item").toString();
			
			URIBuilder uri = new URIBuilder(resourceUrl);
			
			httpget = new HttpGet(uri.build());

			HttpContext context = new BasicHttpContext();

			// execute the method
			HttpResponse response = httpclient.execute(httpget, context);

			// get the response body as an array of bytes
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity != null)
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
	
	public String brand(String brand_id)
	{
		
		HttpGet httpget = null;

		try
		{
			String resourceUrl = new StringBuilder(AppConfig.baseUrl).append("/brand/").append(brand_id).toString();
			
			URIBuilder uri = new URIBuilder(resourceUrl);
			
			uri.addParameter("appId", appId);
			uri.addParameter("appKey", appKey);
			
			httpget = new HttpGet(uri.build());

			HttpContext context = new BasicHttpContext();

			// execute the method
			HttpResponse response = httpclient.execute(httpget, context);

			// get the response body as an array of bytes
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity != null)
			{
				String payload = EntityUtils.toString(entity);
				return payload;
			}
			else
			{
				System.out.println(" Error! - " + response.getStatusLine());
				System.out.println(" Error! - " + EntityUtils.toString(entity));
			}

		} catch (Exception e)
		{
			if (httpget != null)
				httpget.abort();
			System.out.println(" - error: " + e);
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

	public static synchronized NutritionixProxy getInstance()
	{
		if ( instance == null )
		{
			instance = new NutritionixProxy();
		}
		return instance;
	}
}
