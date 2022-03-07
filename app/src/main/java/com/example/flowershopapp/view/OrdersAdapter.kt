package com.example.flowershopapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flowershopapp.R
import com.example.flowershopapp.databinding.OrderItemBinding
import com.example.flowershopapp.model.Order

class OrdersAdapter(private val ordersList: List<Order>) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(binding: OrderItemBinding): RecyclerView.ViewHolder(binding.root) {
        val orderDescription = binding.orderDescription
        val orderDestination = binding.orderDestination
        val orderPrice = binding.orderPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = OrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = ordersList[position]
        val orderDescription = holder.orderDescription
        val orderPrice = holder.orderPrice
        val orderDestination = holder.orderDestination
        orderDescription.text = order.description
        orderDestination.text = order.destination
        orderPrice.text = order.price
    }

    override fun getItemCount(): Int = ordersList.size
}