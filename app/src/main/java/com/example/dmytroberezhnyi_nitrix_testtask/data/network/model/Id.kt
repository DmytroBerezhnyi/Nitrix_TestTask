package com.example.dmytroberezhnyi_nitrix_testtask.data.network.model

import com.google.gson.annotations.SerializedName

data class Id (

	@SerializedName("kind") val kind : String,
	@SerializedName("videoId") val videoId : String
)