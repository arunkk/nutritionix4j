package com.fitrax.nutritionix4j.client.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brand
{

	@JsonProperty("brand_id")
	private String brandId;
	@JsonProperty("old_api_id")
	private String oldApiId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("website")
	private String website;
	@JsonProperty("type")
	private int type;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

	@JsonProperty("old_api_id")
	public String getOldApiId()
	{
		return oldApiId;
	}

	@JsonProperty("old_api_id")
	public void setOldApiId(String oldApiId)
	{
		this.oldApiId = oldApiId;
	}

	@JsonProperty("name")
	public String getName()
	{
		return name;
	}

	@JsonProperty("name")
	public void setName(String name)
	{
		this.name = name;
	}

	@JsonProperty("website")
	public String getWebsite()
	{
		return website;
	}

	@JsonProperty("website")
	public void setWebsite(String website)
	{
		this.website = website;
	}

	@JsonProperty("type")
	public int getType()
	{
		return type;
	}

	@JsonProperty("type")
	public void setType(int type)
	{
		this.type = type;
	}

	@JsonProperty("created_at")
	public String getCreatedAt()
	{
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt()
	{
		return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt)
	{
		this.updatedAt = updatedAt;
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
