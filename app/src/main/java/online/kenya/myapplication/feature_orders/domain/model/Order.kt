package online.kenya.myapplication.feature_orders.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity
data class Order(
    val userName:String,
    val userPhoneNumber:String,
    val Amount:Double,
    val Goods:List<Goods>,
    val userLocation:LatLng,
    @PrimaryKey
    val orderId:String?=null
){

}
