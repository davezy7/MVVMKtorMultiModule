package com.devinapp.pokecourrxkotlin.models

data class ListDealsModel(
	val gameId: String,
	val metacriticScore: String,
	val salePrice: String,
	val releaseDate: Int,
	val thumb: String,
	val dealID: String,
	val steamRatingCount: String,
	val metacriticLink: String,
	val title: String,
	val storeID: String,
	val steamAppID: Any,
	val internalName: String,
	val steamRatingPercent: String,
	val dealRating: String,
	val normalPrice: String,
	val lastChange: Int,
	val savings: String,
	val isOnSale: String,
	val steamRatingText: String
)

