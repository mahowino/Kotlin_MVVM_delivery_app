package online.kenya.myapplication.feature_orders.domain.use_cases

data class OrderUseCases(
    val getOrders:GetOrdersUseCase,
    val callOrderGiver:CallOrderGiverUseCase
)
