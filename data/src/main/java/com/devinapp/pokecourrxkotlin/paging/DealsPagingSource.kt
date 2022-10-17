package com.devinapp.pokecourrxkotlin.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.devinapp.pokecourrxkotlin.models.ListDealsModel
import com.devinapp.pokecourrxkotlin.models.ListDealsResponse
import com.devinapp.pokecourrxkotlin.network.pagingSucceeded
import com.devinapp.pokecourrxkotlin.services.GameDealsServices
import java.io.IOException
import javax.inject.Inject

class DealsPagingSource @Inject constructor(
    private val service: GameDealsServices,
    private val query: HashMap<String, String>
): PagingSource<Int, ListDealsModel>() {

    override fun getRefreshKey(state: PagingState<Int, ListDealsModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListDealsModel> {
        val page = params.key ?: 1

        return service.getDealsList(page, query).pagingSucceeded { response ->
            val result = arrayListOf<ListDealsModel>()
            response.forEach { result.add(it.toModel()) }
            LoadResult.Page(
                data = result,
                prevKey = if(page == 1) null else page,
                nextKey = if(page == 100) null else page.plus(1)
            )
        }
    }
}