package online.kenya.myapplication.feature_orders.domain.use_cases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import online.kenya.myapplication.feature_orders.domain.model.Order
import online.kenya.myapplication.feature_orders.domain.repository.OrderRepository


class GetOrdersUseCase(
    private val repository:OrderRepository
) {
    operator fun invoke(): Flow<List<Order>> {
        return repository.getOrders()
    }
}