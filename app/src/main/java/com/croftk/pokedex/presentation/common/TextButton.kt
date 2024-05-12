package com.croftk.pokedex.presentation.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TextButton(
	text: String,
	onClick: ()->Unit
) {
	androidx.compose.material3.TextButton(
		onClick = onClick,
		) {
		Text(
			text = text,
			style = MaterialTheme.typography.labelMedium,
			color = Color.Gray
		)
	}
}