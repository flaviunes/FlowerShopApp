package com.example.flowershopapp.model

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("id")
    val id: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("deliver_to")
    val destination: String
)