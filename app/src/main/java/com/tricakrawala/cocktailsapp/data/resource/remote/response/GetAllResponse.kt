package com.tricakrawala.cocktailsapp.data.resource.remote.response

import com.google.gson.annotations.SerializedName

data class GetAllResponse(

	@field:SerializedName("drinks")
	val drinks: List<DrinksItem>
)

data class DrinksItem(

	@field:SerializedName("strInstructionsDE")
	val strInstructionsDE: String,

	@field:SerializedName("strImageSource")
	val strImageSource: Any,

	@field:SerializedName("strIngredient10")
	val strIngredient10: Any,

	@field:SerializedName("strDrink")
	val strDrink: String,

	@field:SerializedName("strIngredient12")
	val strIngredient12: Any,

	@field:SerializedName("strIngredient11")
	val strIngredient11: Any,

	@field:SerializedName("strIngredient14")
	val strIngredient14: Any,

	@field:SerializedName("strCategory")
	val strCategory: String,

	@field:SerializedName("strAlcoholic")
	val strAlcoholic: String,

	@field:SerializedName("strIngredient13")
	val strIngredient13: Any,

	@field:SerializedName("strIngredient15")
	val strIngredient15: Any,

	@field:SerializedName("strCreativeCommonsConfirmed")
	val strCreativeCommonsConfirmed: String,

	@field:SerializedName("strIBA")
	val strIBA: Any,

	@field:SerializedName("strVideo")
	val strVideo: Any,

	@field:SerializedName("strTags")
	val strTags: Any,

	@field:SerializedName("strInstructions")
	val strInstructions: String,

	@field:SerializedName("strIngredient1")
	val strIngredient1: String,

	@field:SerializedName("strIngredient3")
	val strIngredient3: String,

	@field:SerializedName("strIngredient2")
	val strIngredient2: String,

	@field:SerializedName("strIngredient5")
	val strIngredient5: Any,

	@field:SerializedName("strIngredient4")
	val strIngredient4: String,

	@field:SerializedName("strIngredient7")
	val strIngredient7: Any,

	@field:SerializedName("strIngredient6")
	val strIngredient6: Any,

	@field:SerializedName("strIngredient9")
	val strIngredient9: Any,

	@field:SerializedName("strInstructionsFR")
	val strInstructionsFR: Any,

	@field:SerializedName("strIngredient8")
	val strIngredient8: Any,

	@field:SerializedName("idDrink")
	val idDrink: String,

	@field:SerializedName("strInstructionsES")
	val strInstructionsES: String,

	@field:SerializedName("strInstructionsIT")
	val strInstructionsIT: String,

	@field:SerializedName("strGlass")
	val strGlass: String,

	@field:SerializedName("strMeasure12")
	val strMeasure12: Any,

	@field:SerializedName("strMeasure13")
	val strMeasure13: Any,

	@field:SerializedName("strMeasure10")
	val strMeasure10: Any,

	@field:SerializedName("strMeasure11")
	val strMeasure11: Any,

	@field:SerializedName("strImageAttribution")
	val strImageAttribution: Any,

	@field:SerializedName("dateModified")
	val dateModified: String,

	@field:SerializedName("strDrinkAlternate")
	val strDrinkAlternate: Any,

	@field:SerializedName("strDrinkThumb")
	val strDrinkThumb: String,

	@field:SerializedName("strInstructionsZH-HANT")
	val strInstructionsZHHANT: Any,

	@field:SerializedName("strMeasure9")
	val strMeasure9: Any,

	@field:SerializedName("strMeasure7")
	val strMeasure7: Any,

	@field:SerializedName("strMeasure8")
	val strMeasure8: Any,

	@field:SerializedName("strMeasure5")
	val strMeasure5: Any,

	@field:SerializedName("strMeasure6")
	val strMeasure6: Any,

	@field:SerializedName("strMeasure3")
	val strMeasure3: String,

	@field:SerializedName("strMeasure4")
	val strMeasure4: String,

	@field:SerializedName("strMeasure1")
	val strMeasure1: String,

	@field:SerializedName("strMeasure2")
	val strMeasure2: String,

	@field:SerializedName("strInstructionsZH-HANS")
	val strInstructionsZHHANS: Any,

	@field:SerializedName("strMeasure14")
	val strMeasure14: Any,

	@field:SerializedName("strMeasure15")
	val strMeasure15: Any
)
