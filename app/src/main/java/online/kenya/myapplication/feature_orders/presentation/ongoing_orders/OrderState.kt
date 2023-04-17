package online.kenya.myapplication.feature_orders.presentation.ongoing_orders

import online.kenya.myapplication.feature_orders.domain.model.Order

data class OrdersState(
    val orders:List<Order> = emptyList()

)