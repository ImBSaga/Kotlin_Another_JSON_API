package com.uda_kotlin.finaltask.model.getdata

data class Response(
	val data: List<DataItem?>? = null,
	val message: String? = null,
	val isSuccess: Boolean? = null
)

data class DataItem(
	val nama: String? = null,
	val photo: String? = null,
	val id: String? = null,
	val category: String? = null
)

