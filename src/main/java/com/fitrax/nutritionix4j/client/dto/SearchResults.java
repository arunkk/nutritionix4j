package com.fitrax.nutritionix4j.client.dto;

public class SearchResults
{

	private int total_hits;
	private float max_score;

	private SearchItem[] hits;

	public int getTotal_hits()
	{
		return total_hits;
	}

	public void setTotal_hits(int total_hits)
	{
		this.total_hits = total_hits;
	}

	public float getMax_score()
	{
		return max_score;
	}

	public void setMax_score(float max_score)
	{
		this.max_score = max_score;
	}

	public SearchItem[] getHits()
	{
		return hits;
	}

	public void setHits(SearchItem[] hits)
	{
		this.hits = hits;
	}

}

/*
 * { "total_hits": 4458, "max_score": 3.9801846, "hits": [ { "_index":
 * "f762ef22-e660-434f-9071-a10ea6691c27", "_type": "item", "_id":
 * "513fc9cb673c4fbc2600536a", "_score": 3.9801846, "fields": { "item_id":
 * "513fc9cb673c4fbc2600536a", "item_name": "Taco", "brand_id":
 * "513fbc1283aa2dc80c000b96", "brand_name": "Taco Inn", "nf_serving_size_qty":
 * 1, "nf_serving_size_unit": "serving" } },
 * 
 * } ] }
 */
