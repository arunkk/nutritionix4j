package com.fitrax.nutritionix4j.client;

public interface NutritionixClient
{

	// Worker functions
	public abstract String search(String phrase);

	public abstract String search(String phrase, String brand_id,
			int calorie_max, int calorie_min, String resultsPage, String fields);

	public abstract String item(String id, String upc, String fields);

	public abstract String brand(String brand_id);

	public abstract void shutdown();

}