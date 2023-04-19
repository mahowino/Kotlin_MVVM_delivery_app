package online.kenya.myapplication.feature_orders.domain.use_cases

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.TelephonyManager
import online.kenya.myapplication.feature_orders.domain.model.InvalidPhoneNumberException
import online.kenya.myapplication.feature_orders.domain.repository.OrderRepository
import kotlin.jvm.Throws

class CallOrderGiverUseCase(
private val repository: OrderRepository,
private val context: Context,
) {

    @Throws(InvalidPhoneNumberException::class)
    suspend operator fun invoke(id:String) {

        val phoneNumber= repository.getOrderById(id)?.userPhoneNumber

        if (phoneNumber?.isBlank() == true)throw InvalidPhoneNumberException("the phone number cannot be empty")

        if (phoneNumber?.length!=10)throw InvalidPhoneNumberException("the phone length has to be 10 characters")

        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        if (telephonyManager.simState == TelephonyManager.SIM_STATE_READY) {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$phoneNumber")
            context.startActivity(intent)
        } else {
            throw IllegalStateException("Unable to make phone call: SIM is not ready")
        }

    }


}
