package com.croftk.pokedex.presentation.common

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Button(
	modifier: Modifier = Modifier,
	colors: ButtonColors = ButtonDefaults.buttonColors(),
	text: String,
	icon: ImageVector? = null,
	onClick: ()->Unit
) {
	androidx.compose.material3.OutlinedButton(
		modifier = modifier,
		colors = colors,
		onClick = onClick,
		shape = RoundedCornerShape(size = 6.dp),
		border = BorderStroke(3.dp, color = Color.Black)
	) {
		if(icon != null){
			Image(icon, contentDescription = null)
		}
		Text(
			text = text,
			style = MaterialTheme.typography.labelMedium
		)
	}
}