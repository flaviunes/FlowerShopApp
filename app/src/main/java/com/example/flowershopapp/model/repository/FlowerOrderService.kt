package com.example.flowershopapp.model.repository

import com.example.flowershopapp.model.Order
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://demo0520503.mockable.io"

class FlowerOrderService {

    var api: OrdersApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        api = retrofit.create(OrdersApi::class.java)
    }

    fun getOrders(): Call<Array<Order>> = api.getOrders()

}