package online.kenya.myapplication.feature_orders.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        GoodsDao::class,
        GoodVariantDao::class,
        OrderDao::class,
    ],
    version = 1
)
abstract class OrderDatabase :RoomDatabase() {
    abstract val orderDao:OrderDao
    abstract val goodDao:GoodsDao
    abstract val goodVariantDao:GoodVariantDao
    companion object{
        const val DATABASE_NAME="ORDER_DATABASE"
    }
}
