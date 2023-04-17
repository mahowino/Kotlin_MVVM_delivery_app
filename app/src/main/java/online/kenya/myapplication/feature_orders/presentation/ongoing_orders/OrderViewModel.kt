package online.kenya.myapplication.feature_orders.presentation.ongoing_orders

import android.media.metrics.PlaybackErrorEvent
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import online.kenya.myapplication.feature_orders.domain.use_cases.OrderUseCases
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val ordersUseCase: OrderUseCases
):ViewModel()
{
    fun onEvent(event: OrdersEvent){
        when(event){
            is OrdersEvent.callUser ->{

            }
        }
    }
}