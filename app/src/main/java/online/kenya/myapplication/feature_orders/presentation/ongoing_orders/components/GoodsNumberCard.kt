package online.kenya.myapplication.feature_orders.presentation.ongoing_orders.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun GoodsCardNumber(){
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF8B4513))
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}