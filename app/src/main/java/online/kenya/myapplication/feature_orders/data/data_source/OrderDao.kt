package online.kenya.myapplication.feature_orders.data.data_source

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import online.kenya.myapplication.feature_orders.domain.model.Order

@Dao
interface OrderDao {

    @Query("SELECT * FROM `order`")
    fun getOrders(): Flow<List<Order>>

    @Query("SELECT * FROM `order` WHERE orderId=:id")
    suspend fun getOrderById(id:String):Order?

}