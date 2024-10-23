package com.example.musictify.data.remote.response

class CategoryListResponse(val items: CategoryItemsResponse) {

    data class CategoryItemsResponse(val items: List<CategoryResponse>)

    data class CategoryResponse(
        val id: String,
        val name: String
    )
}