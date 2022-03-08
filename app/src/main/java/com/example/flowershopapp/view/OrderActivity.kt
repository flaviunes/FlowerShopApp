package com.example.flowershopapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        viewModel = ViewModelProvider(this, defaultViewModelProviderFactory)
            .get(OrdersViewModel::class.java)
        val dataBinding: OrderActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.order_activity)
        val rvOrders = dataBinding.ordersList
        val adapter = OrdersAdapter(orders)
        rvOrders.adapter = adapter
        rvOrders.layoutManager = LinearLayoutManager(this)

        viewModel.onOrderScreenEntered()

        viewModel.ordersLiveData.observe(this) {
            dataBinding.errorMessage.visibility = View.GONE
            orders.addAll(it)
            adapter.notifyDataSetChanged()
        }
        viewModel.failureMessage.observe(this) {
            dataBinding.errorMessage.visibility = View.VISIBLE
            dataBinding.errorMessage.text = getString(it)
        }

    }
}