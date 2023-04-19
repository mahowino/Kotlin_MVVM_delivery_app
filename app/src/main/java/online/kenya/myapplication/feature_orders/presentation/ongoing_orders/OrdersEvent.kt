package online.kenya.myapplication.feature_orders.presentation.ongoing_orders

import online.kenya.myapplication.feature_orders.domain.model.Order

sealed class OrdersEvent {
    data class callUser(val order: Order) : OrdersEvent()
    data class acceptOrder(val order: Order): OrdersEvent()
    data class receiveOrder(val order:Order):OrdersEvent()
}
