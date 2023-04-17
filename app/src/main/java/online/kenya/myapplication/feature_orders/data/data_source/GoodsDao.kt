package online.kenya.myapplication.feature_orders.data.data_source

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import online.kenya.myapplication.feature_orders.domain.model.Goods
import online.kenya.myapplication.feature_orders.domain.model.Order

@Dao
interface GoodsDao {

    @Query("SELECT * FROM `goods`")
    fun getGoods(): Flow<List<Goods>>

    @Query("SELECT * FROM `goods` WHERE goodId=:id")
    suspend fun getGoodsById(id:String): Goods?

}