package com.fitrax.nutritionix4j.client.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item
{

	@JsonProperty("old_api_id")
	private Object oldApiId;
	@JsonProperty("item_id")
	private String itemId;
	@JsonProperty("item_name")
	private String itemName;
	@JsonProperty("leg_loc_id")
	private int legLocId;
	@JsonProperty("brand_id")
	private String brandId;
	@JsonProperty("brand_name")
	private String brandName;
	@JsonProperty("item_description")
	private String itemDescription;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("nf_ingredient_statement")
	private Object nfIngredientStatement;
	@JsonProperty("nf_water_grams")
	private Object nfWaterGrams;
	@JsonProperty("nf_calories")
	private int nfCalories;
	@JsonProperty("nf_calories_from_fat")
	private int nfCaloriesFromFat;
	@JsonProperty("nf_total_fat")
	private double nfTotalFat;
	@JsonProperty("nf_saturated_fat")
	private Object nfSaturatedFat;
	@JsonProperty("nf_trans_fatty_acid")
	private Object nfTransFattyAcid;
	@JsonProperty("nf_polyunsaturated_fat")
	private Object nfPolyunsaturatedFat;
	@JsonProperty("nf_monounsaturated_fat")
	private Object nfMonounsaturatedFat;
	@JsonProperty("nf_cholesterol")
	private int nfCholesterol;
	@JsonProperty("nf_sodium")
	private Object nfSodium;
	@JsonProperty("nf_total_carbohydrate")
	private double nfTotalCarbohydrate;
	@JsonProperty("nf_dietary_fiber")
	private Object nfDietaryFiber;
	@JsonProperty("nf_sugars")
	private Object nfSugars;
	@JsonProperty("nf_protein")
	private Object nfProtein;
	@JsonProperty("nf_vitamin_a_dv")
	private Object nfVitaminADv;
	@JsonProperty("nf_vitamin_c_dv")
	private Object nfVitaminCDv;
	@JsonProperty("nf_calcium_dv")
	private Object nfCalciumDv;
	@JsonProperty("nf_iron_dv")
	private Object nfIronDv;
	@JsonProperty("nf_refuse_pct")
	private Object nfRefusePct;
	@JsonProperty("nf_servings_per_container")
	private Object nfServingsPerContainer;
	@JsonProperty("nf_serving_size_qty")
	private int nfServingSizeQty;
	@JsonProperty("nf_serving_size_unit")
	private String nfServingSizeUnit;
	@JsonProperty("nf_serving_weight_grams")
	private Object nfServingWeightGrams;
	@JsonProperty("allergen_contains_milk")
	private Object allergenContainsMilk;
	@JsonProperty("allergen_contains_eggs")
	private Object allergenContainsEggs;
	@JsonProperty("allergen_contains_fish")
	private Object allergenContainsFish;
	@JsonProperty("allergen_contains_shellfish")
	private Object allergenContainsShellfish;
	@JsonProperty("allergen_contains_tree_nuts")
	private Object allergenContainsTreeNuts;
	@JsonProperty("allergen_contains_peanuts")
	private Object allergenContainsPeanuts;
	@JsonProperty("allergen_contains_wheat")
	private Object allergenContainsWheat;
	@JsonProperty("allergen_contains_soybeans")
	private Object allergenContainsSoybeans;
	@JsonProperty("allergen_contains_gluten")
	private Object allergenContainsGluten;
	@JsonProperty("usda_fields")
	private Object usdaFields;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("old_api_id")
	public Object getOldApiId()
	{
		return oldApiId;
	}

	@JsonProperty("old_api_id")
	public void setOldApiId(Object oldApiId)
	{
		this.oldApiId = oldApiId;
	}

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

	@JsonProperty("leg_loc_id")
	public int getLegLocId()
	{
		return legLocId;
	}

	@JsonProperty("leg_loc_id")
	public void setLegLocId(int legLocId)
	{
		this.legLocId = legLocId;
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

	@JsonProperty("item_description")
	public String getItemDescription()
	{
		return itemDescription;
	}

	@JsonProperty("item_description")
	public void setItemDescription(String itemDescription)
	{
		this.itemDescription = itemDescription;
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

	@JsonProperty("nf_ingredient_statement")
	public Object getNfIngredientStatement()
	{
		return nfIngredientStatement;
	}

	@JsonProperty("nf_ingredient_statement")
	public void setNfIngredientStatement(Object nfIngredientStatement)
	{
		this.nfIngredientStatement = nfIngredientStatement;
	}

	@JsonProperty("nf_water_grams")
	public Object getNfWaterGrams()
	{
		return nfWaterGrams;
	}

	@JsonProperty("nf_water_grams")
	public void setNfWaterGrams(Object nfWaterGrams)
	{
		this.nfWaterGrams = nfWaterGrams;
	}

	@JsonProperty("nf_calories")
	public int getNfCalories()
	{
		return nfCalories;
	}

	@JsonProperty("nf_calories")
	public void setNfCalories(int nfCalories)
	{
		this.nfCalories = nfCalories;
	}

	@JsonProperty("nf_calories_from_fat")
	public int getNfCaloriesFromFat()
	{
		return nfCaloriesFromFat;
	}

	@JsonProperty("nf_calories_from_fat")
	public void setNfCaloriesFromFat(int nfCaloriesFromFat)
	{
		this.nfCaloriesFromFat = nfCaloriesFromFat;
	}

	@JsonProperty("nf_total_fat")
	public double getNfTotalFat()
	{
		return nfTotalFat;
	}

	@JsonProperty("nf_total_fat")
	public void setNfTotalFat(double nfTotalFat)
	{
		this.nfTotalFat = nfTotalFat;
	}

	@JsonProperty("nf_saturated_fat")
	public Object getNfSaturatedFat()
	{
		return nfSaturatedFat;
	}

	@JsonProperty("nf_saturated_fat")
	public void setNfSaturatedFat(Object nfSaturatedFat)
	{
		this.nfSaturatedFat = nfSaturatedFat;
	}

	@JsonProperty("nf_trans_fatty_acid")
	public Object getNfTransFattyAcid()
	{
		return nfTransFattyAcid;
	}

	@JsonProperty("nf_trans_fatty_acid")
	public void setNfTransFattyAcid(Object nfTransFattyAcid)
	{
		this.nfTransFattyAcid = nfTransFattyAcid;
	}

	@JsonProperty("nf_polyunsaturated_fat")
	public Object getNfPolyunsaturatedFat()
	{
		return nfPolyunsaturatedFat;
	}

	@JsonProperty("nf_polyunsaturated_fat")
	public void setNfPolyunsaturatedFat(Object nfPolyunsaturatedFat)
	{
		this.nfPolyunsaturatedFat = nfPolyunsaturatedFat;
	}

	@JsonProperty("nf_monounsaturated_fat")
	public Object getNfMonounsaturatedFat()
	{
		return nfMonounsaturatedFat;
	}

	@JsonProperty("nf_monounsaturated_fat")
	public void setNfMonounsaturatedFat(Object nfMonounsaturatedFat)
	{
		this.nfMonounsaturatedFat = nfMonounsaturatedFat;
	}

	@JsonProperty("nf_cholesterol")
	public int getNfCholesterol()
	{
		return nfCholesterol;
	}

	@JsonProperty("nf_cholesterol")
	public void setNfCholesterol(int nfCholesterol)
	{
		this.nfCholesterol = nfCholesterol;
	}

	@JsonProperty("nf_sodium")
	public Object getNfSodium()
	{
		return nfSodium;
	}

	@JsonProperty("nf_sodium")
	public void setNfSodium(Object nfSodium)
	{
		this.nfSodium = nfSodium;
	}

	@JsonProperty("nf_total_carbohydrate")
	public double getNfTotalCarbohydrate()
	{
		return nfTotalCarbohydrate;
	}

	@JsonProperty("nf_total_carbohydrate")
	public void setNfTotalCarbohydrate(double nfTotalCarbohydrate)
	{
		this.nfTotalCarbohydrate = nfTotalCarbohydrate;
	}

	@JsonProperty("nf_dietary_fiber")
	public Object getNfDietaryFiber()
	{
		return nfDietaryFiber;
	}

	@JsonProperty("nf_dietary_fiber")
	public void setNfDietaryFiber(Object nfDietaryFiber)
	{
		this.nfDietaryFiber = nfDietaryFiber;
	}

	@JsonProperty("nf_sugars")
	public Object getNfSugars()
	{
		return nfSugars;
	}

	@JsonProperty("nf_sugars")
	public void setNfSugars(Object nfSugars)
	{
		this.nfSugars = nfSugars;
	}

	@JsonProperty("nf_protein")
	public Object getNfProtein()
	{
		return nfProtein;
	}

	@JsonProperty("nf_protein")
	public void setNfProtein(Object nfProtein)
	{
		this.nfProtein = nfProtein;
	}

	@JsonProperty("nf_vitamin_a_dv")
	public Object getNfVitaminADv()
	{
		return nfVitaminADv;
	}

	@JsonProperty("nf_vitamin_a_dv")
	public void setNfVitaminADv(Object nfVitaminADv)
	{
		this.nfVitaminADv = nfVitaminADv;
	}

	@JsonProperty("nf_vitamin_c_dv")
	public Object getNfVitaminCDv()
	{
		return nfVitaminCDv;
	}

	@JsonProperty("nf_vitamin_c_dv")
	public void setNfVitaminCDv(Object nfVitaminCDv)
	{
		this.nfVitaminCDv = nfVitaminCDv;
	}

	@JsonProperty("nf_calcium_dv")
	public Object getNfCalciumDv()
	{
		return nfCalciumDv;
	}

	@JsonProperty("nf_calcium_dv")
	public void setNfCalciumDv(Object nfCalciumDv)
	{
		this.nfCalciumDv = nfCalciumDv;
	}

	@JsonProperty("nf_iron_dv")
	public Object getNfIronDv()
	{
		return nfIronDv;
	}

	@JsonProperty("nf_iron_dv")
	public void setNfIronDv(Object nfIronDv)
	{
		this.nfIronDv = nfIronDv;
	}

	@JsonProperty("nf_refuse_pct")
	public Object getNfRefusePct()
	{
		return nfRefusePct;
	}

	@JsonProperty("nf_refuse_pct")
	public void setNfRefusePct(Object nfRefusePct)
	{
		this.nfRefusePct = nfRefusePct;
	}

	@JsonProperty("nf_servings_per_container")
	public Object getNfServingsPerContainer()
	{
		return nfServingsPerContainer;
	}

	@JsonProperty("nf_servings_per_container")
	public void setNfServingsPerContainer(Object nfServingsPerContainer)
	{
		this.nfServingsPerContainer = nfServingsPerContainer;
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

	@JsonProperty("nf_serving_weight_grams")
	public Object getNfServingWeightGrams()
	{
		return nfServingWeightGrams;
	}

	@JsonProperty("nf_serving_weight_grams")
	public void setNfServingWeightGrams(Object nfServingWeightGrams)
	{
		this.nfServingWeightGrams = nfServingWeightGrams;
	}

	@JsonProperty("allergen_contains_milk")
	public Object getAllergenContainsMilk()
	{
		return allergenContainsMilk;
	}

	@JsonProperty("allergen_contains_milk")
	public void setAllergenContainsMilk(Object allergenContainsMilk)
	{
		this.allergenContainsMilk = allergenContainsMilk;
	}

	@JsonProperty("allergen_contains_eggs")
	public Object getAllergenContainsEggs()
	{
		return allergenContainsEggs;
	}

	@JsonProperty("allergen_contains_eggs")
	public void setAllergenContainsEggs(Object allergenContainsEggs)
	{
		this.allergenContainsEggs = allergenContainsEggs;
	}

	@JsonProperty("allergen_contains_fish")
	public Object getAllergenContainsFish()
	{
		return allergenContainsFish;
	}

	@JsonProperty("allergen_contains_fish")
	public void setAllergenContainsFish(Object allergenContainsFish)
	{
		this.allergenContainsFish = allergenContainsFish;
	}

	@JsonProperty("allergen_contains_shellfish")
	public Object getAllergenContainsShellfish()
	{
		return allergenContainsShellfish;
	}

	@JsonProperty("allergen_contains_shellfish")
	public void setAllergenContainsShellfish(Object allergenContainsShellfish)
	{
		this.allergenContainsShellfish = allergenContainsShellfish;
	}

	@JsonProperty("allergen_contains_tree_nuts")
	public Object getAllergenContainsTreeNuts()
	{
		return allergenContainsTreeNuts;
	}

	@JsonProperty("allergen_contains_tree_nuts")
	public void setAllergenContainsTreeNuts(Object allergenContainsTreeNuts)
	{
		this.allergenContainsTreeNuts = allergenContainsTreeNuts;
	}

	@JsonProperty("allergen_contains_peanuts")
	public Object getAllergenContainsPeanuts()
	{
		return allergenContainsPeanuts;
	}

	@JsonProperty("allergen_contains_peanuts")
	public void setAllergenContainsPeanuts(Object allergenContainsPeanuts)
	{
		this.allergenContainsPeanuts = allergenContainsPeanuts;
	}

	@JsonProperty("allergen_contains_wheat")
	public Object getAllergenContainsWheat()
	{
		return allergenContainsWheat;
	}

	@JsonProperty("allergen_contains_wheat")
	public void setAllergenContainsWheat(Object allergenContainsWheat)
	{
		this.allergenContainsWheat = allergenContainsWheat;
	}

	@JsonProperty("allergen_contains_soybeans")
	public Object getAllergenContainsSoybeans()
	{
		return allergenContainsSoybeans;
	}

	@JsonProperty("allergen_contains_soybeans")
	public void setAllergenContainsSoybeans(Object allergenContainsSoybeans)
	{
		this.allergenContainsSoybeans = allergenContainsSoybeans;
	}

	@JsonProperty("allergen_contains_gluten")
	public Object getAllergenContainsGluten()
	{
		return allergenContainsGluten;
	}

	@JsonProperty("allergen_contains_gluten")
	public void setAllergenContainsGluten(Object allergenContainsGluten)
	{
		this.allergenContainsGluten = allergenContainsGluten;
	}

	@JsonProperty("usda_fields")
	public Object getUsdaFields()
	{
		return usdaFields;
	}

	@JsonProperty("usda_fields")
	public void setUsdaFields(Object usdaFields)
	{
		this.usdaFields = usdaFields;
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