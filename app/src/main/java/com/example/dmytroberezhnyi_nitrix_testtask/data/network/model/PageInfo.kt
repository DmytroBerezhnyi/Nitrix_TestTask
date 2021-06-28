package com.example.dmytroberezhnyi_nitrix_testtask.data.network.model

import com.google.gson.annotations.SerializedName

data class PageInfo (

	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("resultsPerPage") val resultsPerPage : Int
)