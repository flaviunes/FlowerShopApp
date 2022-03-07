package com.example.flowershopapp.model.repository

import com.example.flowershopapp.model.Order

class FlowerRepository {
    companion object {
        fun getFlowerOrders() = listOf(
            Order("Red roses", "60.00$", "Bianca"),
            Order("Blue roses", "10.00$", "Monica"),
            Order("Red lilies", "6.00$", "Laura")
        )
    }
}
