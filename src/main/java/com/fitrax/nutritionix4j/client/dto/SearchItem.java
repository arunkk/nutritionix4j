package com.fitrax.nutritionix4j.client.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchItem
{

	@JsonProperty("_index")
	private String index;
	@JsonProperty("_type")
	private String type;
	@JsonProperty("_id")
	private String id;
	@JsonProperty("_score")
	private double score;
	@JsonProperty("fields")
	private Fields fields;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("_index")
	public String getIndex()
	{
		return index;
	}

	@JsonProperty("_index")
	public void setIndex(String index)
	{
		this.index = index;
	}

	@JsonProperty("_type")
	public String getType()
	{
		return type;
	}

	@JsonProperty("_type")
	public void setType(String type)
	{
		this.type = type;
	}

	@JsonProperty("_id")
	public String getId()
	{
		return id;
	}

	@JsonProperty("_id")
	public void setId(String id)
	{
		this.id = id;
	}

	@JsonProperty("_score")
	public double getScore()
	{
		return score;
	}

	@JsonProperty("_score")
	public void setScore(double score)
	{
		this.score = score;
	}

	@JsonProperty("fields")
	public Fields getFields()
	{
		return fields;
	}

	@JsonProperty("fields")
	public void setFields(Fields fields)
	{
		this.fields = fields;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties()
	{
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value)
	{
		this.additionalProperties.put(name, value);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Fields
	{

		@JsonProperty("item_id")
		private String itemId;
		@JsonProperty("item_name")
		private String itemName;
		@JsonProperty("brand_id")
		private String brandId;
		@JsonProperty("brand_name")
		private String brandName;
		@JsonProperty("nf_serving_size_qty")
		private int nfServingSizeQty;
		@JsonProperty("nf_serving_size_unit")
		private String nfServingSizeUnit;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("item_id")
		public String getItemId()
		{
			return itemId;
		}

		@JsonProperty("item_id")
		public void setItemId(String itemId)
		{
			this.itemId = itemId;
		}

		@JsonProperty("item_name")
		public String getItemName()
		{
			return itemName;
		}

		@JsonProperty("item_name")
		public void setItemName(String itemName)
		{
			this.itemName = itemName;
		}

		@JsonProperty("brand_id")
		public String getBrandId()
		{
			return brandId;
		}

		@JsonProperty("brand_id")
		public void setBrandId(String brandId)
		{
			this.brandId = brandId;
		}

		@JsonProperty("brand_name")
		public String getBrandName()
		{
			return brandName;
		}

		@JsonProperty("brand_name")
		public void setBrandName(String brandName)
		{
			this.brandName = brandName;
		}

		@JsonProperty("nf_serving_size_qty")
		public int getNfServingSizeQty()
		{
			return nfServingSizeQty;
		}

		@JsonProperty("nf_serving_size_qty")
		public void setNfServingSizeQty(int nfServingSizeQty)
		{
			this.nfServingSizeQty = nfServingSizeQty;
		}

		@JsonProperty("nf_serving_size_unit")
		public String getNfServingSizeUnit()
		{
			return nfServingSizeUnit;
		}

		@JsonProperty("nf_serving_size_unit")
		public void setNfServingSizeUnit(String nfServingSizeUnit)
		{
			this.nfServingSizeUnit = nfServingSizeUnit;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties()
		{
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value)
		{
			this.additionalProperties.put(name, value);
		}

	}

}
