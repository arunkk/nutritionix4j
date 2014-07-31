package com.fitrax.nutritionix4j.client;

import com.fitrax.nutritionix4j.client.dto.Brand;
import com.fitrax.nutritionix4j.client.dto.Item;
import com.fitrax.nutritionix4j.client.dto.SearchResults;

public interface NutritionixClient
{

	// Worker functions
	public abstract SearchResults search(String phrase);

	public abstract SearchResults search(String phrase, String brand_id,
			int calorie_max, int calorie_min, String resultsPage, String fields);

	public abstract Item item(String id, String upc, String fields);

	public abstract Brand brand(String brand_id);

	public abstract void shutdown();

}