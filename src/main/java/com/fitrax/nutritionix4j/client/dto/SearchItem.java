package com.fitrax.nutritionix4j.client.dto;

/*
 *  {
 "_index": "f762ef22-e660-434f-9071-a10ea6691c27",
 "_type": "item",
 "_id": "513fc9cb673c4fbc2600536a",
 "_score": 3.9801846,
 "fields": {
 "item_id": "513fc9cb673c4fbc2600536a",
 "item_name": "Taco",
 "brand_id": "513fbc1283aa2dc80c000b96",
 "brand_name": "Taco Inn",
 "nf_serving_size_qty": 1,
 "nf_serving_size_unit": "serving"
 }
 */
public class SearchItem
{

	public static class Fields
	{
		public String item_id;
		public String item_name;
		public String brand_id;
		public String brand_name;
		public int nf_serving_size_qty;
		public String nf_serving_size_unit;

		public Fields()
		{
		}

		public String getItem_id()
		{
			return item_id;
		}

		public void setItem_id(String item_id)
		{
			this.item_id = item_id;
		}

		public String getItem_name()
		{
			return item_name;
		}

		public void setItem_name(String item_name)
		{
			this.item_name = item_name;
		}

		public String getBrand_id()
		{
			return brand_id;
		}

		public void setBrand_id(String brand_id)
		{
			this.brand_id = brand_id;
		}

		public String getBrand_name()
		{
			return brand_name;
		}

		public void setBrand_name(String brand_name)
		{
			this.brand_name = brand_name;
		}

		public int getNf_serving_size_qty()
		{
			return nf_serving_size_qty;
		}

		public void setNf_serving_size_qty(int nf_serving_size_qty)
		{
			this.nf_serving_size_qty = nf_serving_size_qty;
		}

		public String getNf_serving_size_unit()
		{
			return nf_serving_size_unit;
		}

		public void setNf_serving_size_unit(String nf_serving_size_unit)
		{
			this.nf_serving_size_unit = nf_serving_size_unit;
		}

	}

	private String _index;
	private String _type;
	private String _id;
	private float _score;

	private Fields fields;

	public String get_index()
	{
		return _index;
	}

	public void set_index(String _index)
	{
		this._index = _index;
	}

	public String get_type()
	{
		return _type;
	}

	public void set_type(String _type)
	{
		this._type = _type;
	}

	public String get_id()
	{
		return _id;
	}

	public void set_id(String _id)
	{
		this._id = _id;
	}

	public float get_score()
	{
		return _score;
	}

	public void set_score(float _score)
	{
		this._score = _score;
	}

	public Fields getFields()
	{
		return fields;
	}

	public void setFields(Fields fields)
	{
		this.fields = fields;
	}

}
