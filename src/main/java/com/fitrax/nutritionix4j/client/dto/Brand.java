package com.fitrax.nutritionix4j.client.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Brand
{

	/*
	 * "brand_id":"513fbc1283aa2dc80c000053", "old_api_id":"0PewL8juRBSozVk",
	 * "name":"McDonald's", "website":"http://www.mcdonalds.com", "type":1,
	 * "created_at":"2011-07-01T08:45:47.000Z",
	 * "updated_at":"2014-07-21T20:00:51.000Z"
	 */
	private String brand_id;

	private String old_api_id;
	private String name;
	private String website;
	private int type;
	private String created_at;
	private String updated_at;

	public String getBrand_id()
	{
		return brand_id;
	}

	public void setBrand_id(String brand_id)
	{
		this.brand_id = brand_id;
	}

	public String getOld_api_id()
	{
		return old_api_id;
	}

	public void setOld_api_id(String old_api_id)
	{
		this.old_api_id = old_api_id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getCreated_at()
	{
		return created_at;
	}

	public void setCreated_at(String created_at)
	{
		this.created_at = created_at;
	}

	public String getUpdated_at()
	{
		return updated_at;
	}

	public void setUpdated_at(String updated_at)
	{
		this.updated_at = updated_at;
	}

}