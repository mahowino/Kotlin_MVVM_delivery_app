package online.kenya.myapplication.feature_orders.data.repository

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.flow.Flow
import online.kenya.myapplication.feature_orders.data.data_source.OrderDao
import online.kenya.myapplication.feature_orders.domain.model.Order
import online.kenya.myapplication.feature_orders.domain.repository.OrderRepository

class OrderRepositoryImpl(
    private val dao :OrderDao
):OrderRepository {
    override fun getOrders(): Flow<List<Order>> {
        return dao.getOrders()
    }

    override fun getCompleteOrders(): Flow<List<Order>> {
        //get from endpoint
        //cache in database if a condition is not true
        //if data in cache, remove from cache else remove from endpoint
        TODO("Not yet implemented")
    }

    override suspend fun getOrderById(id: String): Order? {
        return dao.getOrderById(id)
    }



}