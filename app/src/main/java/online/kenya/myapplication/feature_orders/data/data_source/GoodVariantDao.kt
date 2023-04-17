package online.kenya.myapplication.feature_orders.data.data_source

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GoodVariantDao {

    @Query("SELECT * FROM `goodvariants`")
    fun getGoodVariants(): Flow<List<GoodVariantDao>>

    @Query("SELECT * FROM `goodvariants` WHERE goodVariantId=:id")
    suspend fun getGoodVariantsById(id:String): GoodVariantDao?

}