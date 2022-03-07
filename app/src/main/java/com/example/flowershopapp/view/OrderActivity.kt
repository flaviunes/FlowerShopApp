package com.example.flowershopapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowershopapp.R
import com.example.flowershopapp.databinding.OrderActivityBinding
import com.example.flowershopapp.model.Order
import com.example.flowershopapp.viewmodel.OrdersViewModel

class OrderActivity : AppCompatActivity() {
    private val orders: ArrayList<Order> = arrayListOf()
    lateinit var viewModel: OrdersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            defaultViewModelProviderFactory
        ).get(OrdersViewModel::class.java)
        val dataBinding: OrderActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.order_activity)
        setupOrdersList(dataBinding)
        viewModel.onOrderScreenEntered()

        viewModel.ordersLiveData.observe(this) {
            orders.addAll(it)
        }

    }

    private fun setupOrdersList(dataBinding: OrderActivityBinding) {
        val rvOrders = dataBinding.ordersList
        val adapter = OrdersAdapter(orders)
        rvOrders.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvOrders.layoutManager = layoutManager
        val dividerItemDecoration =
            DividerItemDecoration(rvOrders.context, layoutManager.orientation)
        rvOrders.addItemDecoration(dividerItemDecoration)
    }
}