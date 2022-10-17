package com.devinapp.pokecourrxkotlin.models

import com.devinapp.pokecourrxkotlin.network.replaceIfNull
import com.google.gson.annotations.SerializedName

data class ListDealsResponse(

	@SerializedName("gameID")
	val gameId: String? = null,

	@SerializedName("metacriticScore")
	val metacriticScore: String? = null,

	@SerializedName("salePrice")
	val salePrice: String? = null,

	@SerializedName("releaseDate")
	val releaseDate: Int? = null,

	@SerializedName("thumb")
	val thumb: String? = null,

	@SerializedName("dealID")
	val dealID: String? = null,

	@SerializedName("steamRatingCount")
	val steamRatingCount: String? = null,

	@SerializedName("metacriticLink")
	val metacriticLink: String? = null,

	@SerializedName("title")
	val title: String? = null,

	@SerializedName("storeID")
	val storeID: String? = null,

	@SerializedName("steamAppID")
	val steamAppID: String? = null,

	@SerializedName("internalName")
	val internalName: String? = null,

	@SerializedName("steamRatingPercent")
	val steamRatingPercent: String? = null,

	@SerializedName("dealRating")
	val dealRating: String? = null,

	@SerializedName("normalPrice")
	val normalPrice: String? = null,

	@SerializedName("lastChange")
	val lastChange: Int? = null,

	@SerializedName("savings")
	val savings: String? = null,

	@SerializedName("isOnSale")
	val isOnSale: String? = null,

	@SerializedName("steamRatingText")
	val steamRatingText: String? = null
) {
	fun toModel(): ListDealsModel {
		return ListDealsModel(
			gameId = gameId.replaceIfNull(),
			metacriticScore = metacriticScore.replaceIfNull(),
			salePrice = salePrice.replaceIfNull(),
			releaseDate = releaseDate.replaceIfNull(),
			thumb = thumb.replaceIfNull(),
			dealID = dealID.replaceIfNull(),
			steamRatingCount = steamRatingCount.replaceIfNull(),
			metacriticLink = metacriticLink.replaceIfNull(),
			title = title.replaceIfNull(),
			storeID = storeID.replaceIfNull(),
			steamAppID = steamAppID.replaceIfNull(),
			internalName = internalName.replaceIfNull(),
			steamRatingPercent = steamRatingPercent.replaceIfNull(),
			dealRating = dealRating.replaceIfNull(),
			normalPrice = normalPrice.replaceIfNull(),
			lastChange = lastChange.replaceIfNull(),
			savings = savings.replaceIfNull(),
			isOnSale = isOnSale.replaceIfNull(),
			steamRatingText = steamRatingText.replaceIfNull()
		)
	}
}
