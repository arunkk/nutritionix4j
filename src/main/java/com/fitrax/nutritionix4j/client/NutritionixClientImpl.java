package com.fitrax.nutritionix4j.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitrax.nutritionix4j.client.dto.Brand;
import com.fitrax.nutritionix4j.client.dto.Item;
import com.fitrax.nutritionix4j.client.dto.SearchResults;

/**
 * @author arunk
 * 
 */
public class NutritionixClientImpl implements NutritionixClient
{
	private final PoolingHttpClientConnectionManager cm;
	private final CloseableHttpClient httpclient;

	private final String appId, appKey;
	private final ObjectMapper mapper;

	private final String baseUrl;

	private final int maxConnectionsPool;

	public NutritionixClientImpl(String appId, String appKey, String baseUrl,
			int maxConnectionsPool)
	{
		this.baseUrl = baseUrl;
		this.appId = appId;
		this.appKey = appKey;
		this.maxConnectionsPool = maxConnectionsPool;

		mapper = new ObjectMapper(); // Jackson Object Mapper

		// Validations.
		if (baseUrl == null)
		{
			throw new RuntimeException(" Base URL is null");
		}

		// Init connection pool
		cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(this.maxConnectionsPool);

		httpclient = HttpClientBuilder.create().setConnectionManager(cm)
				.build();

	}

	// Worker functions
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fitrax.nutritionix4j.client.NutritionixClient#search(java.lang.String
	 * )
	 */
	@Override
	public SearchResults search(String phrase)
	{
		return search(phrase, null, -1, -1, null, "*");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fitrax.nutritionix4j.client.NutritionixClient#search(java.lang.String
	 * , java.lang.String, int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public SearchResults search(String phrase, String brand_id,
			int calorie_max, int calorie_min, String resultsPage, String fields)
	{

		HttpGet httpget = null;

		try
		{
			String resourceUrl = new StringBuilder(baseUrl).append("/search/")
					.append(phrase).toString();

			URIBuilder uri = new URIBuilder(resourceUrl);

			// set all the params
			if (calorie_max > 0)
				uri.addParameter("calorie_max", Integer.toString(calorie_max));
			if (calorie_min > 0)
				uri.addParameter("calorie_min", Integer.toString(calorie_min));
			if (brand_id != null)
				uri.addParameter("brand_id", brand_id);
			if (resultsPage != null)
				uri.addParameter("resultsPage", resultsPage);

			if (fields != null)
				uri.addParameter("fields", resultsPage);

			uri.addParameter("appId", appId);
			uri.addParameter("appKey", appKey);

			httpget = new HttpGet(uri.build());

			HttpContext context = new BasicHttpContext();

			// execute the method
			HttpResponse response = httpclient.execute(httpget, context);

			// get the response body as an array of bytes
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK
					&& entity != null)
			{
				String payload = EntityUtils.toString(entity);
				SearchResults results = mapper.readValue(payload,
						SearchResults.class);
				return results;
			}

		} catch (Exception e)
		{
			if (httpget != null)
				httpget.abort();
			System.out.println(" - error: " + e);
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fitrax.nutritionix4j.client.NutritionixClient#item(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Item item(String id, String upc, String fields)
	{

		HttpGet httpget = null;

		try
		{
			String resourceUrl = new StringBuilder(baseUrl).append("/item")
					.toString();

			URIBuilder uri = new URIBuilder(resourceUrl);

			uri.addParameter("appId", appId);
			uri.addParameter("appKey", appKey);

			if (id != null)
				uri.addParameter("id", id);
			if (upc != null)
				uri.addParameter("upc", upc);

			if (fields != null)
				uri.addParameter("fields", fields);

			httpget = new HttpGet(uri.build());

			HttpContext context = new BasicHttpContext();

			// execute the method
			HttpResponse response = httpclient.execute(httpget, context);

			// get the response body as an array of bytes
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK
					&& entity != null)
			{
				String payload = EntityUtils.toString(entity);
				Item item = mapper.readValue(payload, Item.class);
				return item;
			}

		} catch (Exception e)
		{
			if (httpget != null)
				httpget.abort();
			System.out.println(" - error: " + e);
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fitrax.nutritionix4j.client.NutritionixClient#brand(java.lang.String)
	 */
	@Override
	public Brand brand(String brand_id)
	{

		HttpGet httpget = null;

		try
		{
			String resourceUrl = new StringBuilder(baseUrl).append("/brand/")
					.append(brand_id).toString();

			URIBuilder uri = new URIBuilder(resourceUrl);

			uri.addParameter("appId", appId);
			uri.addParameter("appKey", appKey);

			httpget = new HttpGet(uri.build());

			HttpContext context = new BasicHttpContext();

			// execute the method
			HttpResponse response = httpclient.execute(httpget, context);

			// get the response body as an array of bytes
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK
					&& entity != null)
			{
				String payload = EntityUtils.toString(entity);
				Brand brand = mapper.readValue(payload, Brand.class);
				return brand;
			} else
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitrax.nutritionix4j.client.NutritionixClient#shutdown()
	 */
	@Override
	public void shutdown()
	{
		try
		{
			httpclient.close();
			cm.shutdown();
			cm.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
