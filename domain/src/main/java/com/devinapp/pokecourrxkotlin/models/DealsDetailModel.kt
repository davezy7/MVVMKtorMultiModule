package com.devinapp.pokecourrxkotlin.models

data class DealsDetailModel(
    val gameInfo: DealsGameInfoModel,
    val cheaperStores: ArrayList<DealsCheaperStoreModel>,
    val cheapestPrice: DealsCheapestPriceModel
)

data class DealsGameInfoModel(
    val gameID: String,
    val metacriticScore: String,
    val salePrice: String,
    val releaseDate: Int,
    val thumb: String,
    val steamRatingCount: String,
    val steamworks: String,
    val metacriticLink: String,
    val storeID: String,
    val steamAppID: String,
    val steamRatingPercent: String,
    val name: String,
    val publisher: String,
    val retailPrice: String,
    val steamRatingText: String
)

data class DealsCheaperStoreModel(
    val salePrice: String,
    val dealID: String,
    val storeID: String,
    val retailPrice: String
)

data class DealsCheapestPriceModel(
    val date: Long,
    val price: String
)