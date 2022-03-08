package com.example.flowershopapp.model.repository

import com.example.flowershopapp.model.Order
import retrofit2.Call
import retrofit2.http.GET

interface OrdersApi {

    @GET("/orders")
    fun getOrders(): Call<Array<Order>>
}