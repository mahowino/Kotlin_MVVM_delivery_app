package online.kenya.myapplication.feature_orders.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GoodVariants(
    val goodVariantName:String,
    val goodVariantDescription:String,
    val retailPrice:Double,
    val wholesalePrice:Double,
    val wholesaleQuantities:Int,
    @PrimaryKey
    val goodVariantId:String?=null
)
