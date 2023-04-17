package online.kenya.myapplication.feature_orders.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Goods(
    val goodName:String,
    val goodDescription:String,
    val goodCategory:String,
    val goodVariants:List<GoodVariants>,
    @PrimaryKey
    val goodId:String?=null

)
