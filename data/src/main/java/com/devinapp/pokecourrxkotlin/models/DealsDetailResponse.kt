package com.devinapp.pokecourrxkotlin.models

import com.devinapp.pokecourrxkotlin.network.replaceIfNull
import com.google.gson.annotations.SerializedName

data class DealsDetailResponse(

    @SerializedName("gameInfo")
    val gameInfo: DealsGameInfoResponse? = null,

    @SerializedName("cheaperStores")
    val cheaperStores: ArrayList<DealsCheaperStoreResponse>? = null,

    @SerializedName("cheapestPrice")
    val cheapestPrice: DealsCheapestPriceResponse? = null

) {
    fun toModel(): DealsDetailModel {
        val cheaper = arrayListOf<DealsCheaperStoreModel>()
        cheaperStores?.forEach { cheaper.add(DealsCheaperStoreResponse.toModel(it)) }
        return DealsDetailModel(
            gameInfo = DealsGameInfoResponse.toModel(gameInfo),
            cheaperStores = cheaper,
            cheapestPrice = DealsCheapestPriceResponse.toModel(cheapestPrice)
        )
    }
}

data class DealsGameInfoResponse(

    @field:SerializedName("gameID")
    val gameID: String? = null,

    @field:SerializedName("metacriticScore")
    val metacriticScore: String? = null,

    @field:SerializedName("salePrice")
    val salePrice: String? = null,

    @field:SerializedName("releaseDate")
    val releaseDate: Int? = null,

    @field:SerializedName("thumb")
    val thumb: String? = null,

    @field:SerializedName("steamRatingCount")
    val steamRatingCount: String? = null,

    @field:SerializedName("steamworks")
    val steamworks: String? = null,

    @field:SerializedName("metacriticLink")
    val metacriticLink: String? = null,

    @field:SerializedName("storeID")
    val storeID: String? = null,

    @field:SerializedName("steamAppID")
    val steamAppID: String? = null,

    @field:SerializedName("steamRatingPercent")
    val steamRatingPercent: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("publisher")
    val publisher: String? = null,

    @field:SerializedName("retailPrice")
    val retailPrice: String? = null,

    @field:SerializedName("steamRatingText")
    val steamRatingText: String? = null
) {
    companion object {
        fun toModel(data: DealsGameInfoResponse?): DealsGameInfoModel {
            return DealsGameInfoModel(
                gameID = data?.gameID.replaceIfNull(),
                metacriticScore = data?.metacriticScore.replaceIfNull(),
                salePrice = data?.salePrice.replaceIfNull(),
                releaseDate = data?.releaseDate.replaceIfNull(),
                thumb = data?.thumb.replaceIfNull(),
                steamRatingCount = data?.steamRatingCount.replaceIfNull(),
                steamworks = data?.steamworks.replaceIfNull(),
                metacriticLink = data?.metacriticLink.replaceIfNull(),
                storeID = data?.storeID.replaceIfNull(),
                steamAppID = data?.steamAppID.replaceIfNull(),
                steamRatingPercent = data?.steamRatingPercent.replaceIfNull(),
                name = data?.name.replaceIfNull(),
                publisher = data?.publisher.replaceIfNull(),
                retailPrice = data?.retailPrice.replaceIfNull(),
                steamRatingText = data?.steamRatingText.replaceIfNull()
            )
        }
    }
}

data class DealsCheaperStoreResponse(
    @field:SerializedName("salePrice")
    val salePrice: String? = null,

    @field:SerializedName("dealID")
    val dealID: String? = null,

    @field:SerializedName("storeID")
    val storeID: String? = null,

    @field:SerializedName("retailPrice")
    val retailPrice: String? = null
) {
    companion object {
        fun toModel(data: DealsCheaperStoreResponse?): DealsCheaperStoreModel {
            return DealsCheaperStoreModel(
                salePrice = data?.salePrice.replaceIfNull(),
                dealID = data?.dealID.replaceIfNull(),
                storeID = data?.storeID.replaceIfNull(),
                retailPrice = data?.retailPrice.replaceIfNull()
            )
        }
    }
}

data class DealsCheapestPriceResponse(
    @field:SerializedName("date")
    val date: Long? = null,

    @field:SerializedName("price")
    val price: String? = null
) {
    companion object {
        fun toModel(data: DealsCheapestPriceResponse?): DealsCheapestPriceModel {
            return DealsCheapestPriceModel(
                date = data?.date.replaceIfNull(),
                price = data?.price.replaceIfNull()
            )
        }
    }
}