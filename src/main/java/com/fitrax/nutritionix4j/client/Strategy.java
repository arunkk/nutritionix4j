package com.fitrax.nutritionix4j.client;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Strategy
{
	private HashMap<Integer, String> map;

	private HashMap<String,String> testUsers;
	
	public Strategy(String jsonString) throws JSONException, IOException
	{
		initialize(jsonString);
	}

	private void initialize(String jsonString) throws JSONException, IOException
	{ 
		
		JSONObject jsonObject = new JSONObject(jsonString);

		JSONObject bStrategy = jsonObject.getJSONObject("buckAllocationStrategy");

		JSONObject strategy = bStrategy.getJSONObject("simple");

		map = new HashMap<Integer, String>();

		int currPercent = 1;
		for (Iterator<String> itr = strategy.keys(); itr.hasNext();)
		{
			String key = itr.next();
			JSONObject plan = strategy.getJSONObject(key);
			int percent = plan.getInt("percent");
			String bucket = plan.getString("label");

			System.out.println(" Percent is " + percent + " bucket is " + bucket);
			
			
			for (int i = currPercent, max = currPercent+percent; i < max; i++)
			{
				map.put(new Integer(currPercent++), bucket);
			}
		}

		// Fill the rest with default

		for (int i = currPercent; i <= 100; i++)
		{
			map.put(new Integer(currPercent++), "default");
		}
		
		// Check for any test users
		testUsers = new HashMap<String, String>();
		JSONObject testIDJSON = jsonObject.getJSONObject("testIds");
		if ( testIDJSON != null )
		{
			for (Iterator<String> itr = testIDJSON.keys(); itr.hasNext();)
			{
				String key = itr.next();
				JSONObject payload = testIDJSON.getJSONObject(key);
				String bucket = payload.getString("label");
				addTestBucket(key, bucket);
			}
		}
	}

	public String allocateBucket(String userId) throws JSONException, IOException, NoSuchAlgorithmException
	{

		// Arun, check if the user is a test user.
		if ( userId != null && testUsers.containsKey(userId))
		{
			return testUsers.get(userId);
		}
						
		return map.get(getMod100(userId)+1);
	}
	
	public void addTestBucket(String userId,String label)
	{
		testUsers.put(userId, label);
	}
	
	private int getMod100(String userId) throws NoSuchAlgorithmException
	{
		MessageDigest mDigest = MessageDigest.getInstance("MD5");
		// Reset the digest
		mDigest.reset();
	
		// Create a 128 bit MD5 Digest from userId
		byte[] digest = mDigest.digest(userId.getBytes());
	
		// Get the LSB Integer
		int lsb = (int) digest[digest.length - 2] & 0xFF;
		lsb = lsb << 8 | ((int) digest[digest.length - 1] & 0xFF);
		return lsb % 100;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString()
    {
	    return "Strategy [map=" + map + ", testUsers=" + testUsers + "]";
    }
	
	
}