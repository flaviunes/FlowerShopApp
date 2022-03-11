package com.example.flowershopapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowershopapp.R
import com.example.flowershopapp.model.Order
import com.example.flowershopapp.model.repository.FlowerOrderService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OrdersViewModel: ViewModel() {
    val ordersLiveData: LiveData<Array<Order>>
        get() = _ordersLiveData
    private val _ordersLiveData: MutableLiveData<Array<Order>> = MutableLiveData()


    val failureMessage: LiveData<Int>
        get() = _failureMessage
    private val _failureMessage: MutableLiveData<Int> = MutableLiveData()

    private val orderService = FlowerOrderService()

    fun onOrderScreenEntered() {
        val call = orderService.getOrders()
        call.enqueue(object : Callback<Array<Order>> {
            override fun onResponse(call: Call<Array<Order>>, response: Response<Array<Order>>) {
                if (!response.body().isNullOrEmpty()) {
                    _ordersLiveData.postValue(response.body())
                } else {
                    _failureMessage.value = R.string.empty_orders
                }
            }

            override fun onFailure(call: Call<Array<Order>>, t: Throwable) {
                _failureMessage.value = R.string.empty_orders
            }
        })
    }
}