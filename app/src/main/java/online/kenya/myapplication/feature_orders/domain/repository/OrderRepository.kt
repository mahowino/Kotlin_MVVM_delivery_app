package online.kenya.myapplication.feature_orders.domain.repository

import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import online.kenya.myapplication.feature_orders.domain.model.Order

interface OrderRepository {

    fun getOrders(): Flow<List<Order>>

    fun getCompleteOrders(): Flow<List<Order>>

    suspend fun getOrderById(id:String): Order?

}