package com.example.flowershopapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowershopapp.model.Order
import com.example.flowershopapp.model.repository.FlowerRepository

class OrdersViewModel(): ViewModel() {
    val ordersLiveData: LiveData<List<Order>>
        get() = _ordersLiveData
    private val _ordersLiveData: MutableLiveData<List<Order>> = MutableLiveData()

    fun onOrderScreenEntered() {
        _ordersLiveData.value = FlowerRepository.getFlowerOrders()
    }
}