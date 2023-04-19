package online.kenya.myapplication.feature_orders.presentation.ongoing_orders

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Context
import android.media.metrics.PlaybackErrorEvent
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import online.kenya.myapplication.feature_orders.domain.model.InvalidPhoneNumberException
import online.kenya.myapplication.feature_orders.domain.use_cases.OrderUseCases
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val ordersUseCase: OrderUseCases,
    @ApplicationContext private val application: Application
): AndroidViewModel(application)
{
    init {
        getOrders()
    }
    private val _state= mutableStateOf(OrdersState())
    val state: State<OrdersState> =_state
    private var getOrdersJob:Job?=null
    suspend fun onEvent(event: OrdersEvent){
        when(event){
            is OrdersEvent.callUser ->{

                    try {
                        event.order.orderId?.let { ordersUseCase.callOrderGiver(it) }
                    } catch (e: InvalidPhoneNumberException) {
                        // handle invalid phone number
                    } catch (e: IllegalStateException) {
                        // handle SIM not ready
                    }
                    catch (e: ActivityNotFoundException) {
                        // handle user cancelling the call
                    }

            }
            is OrdersEvent.acceptOrder -> {

            }
            is OrdersEvent.receiveOrder -> {

            }
        }
    }
    private fun getOrders(){
        getOrdersJob?.cancel()
        getOrdersJob=ordersUseCase.getOrders()
            .onEach {
                orders ->
                _state.value=state.value.copy(
                    orders=orders
                )
            }.launchIn(viewModelScope)
    }
}