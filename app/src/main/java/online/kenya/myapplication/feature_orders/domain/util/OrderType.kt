package online.kenya.myapplication.feature_orders.domain.util

import java.util.Objects

sealed class OrderType {
    object Ascending:OrderType()
    object Descending:OrderType()

}