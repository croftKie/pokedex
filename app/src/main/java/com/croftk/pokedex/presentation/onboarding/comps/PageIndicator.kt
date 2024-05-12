package com.croftk.pokedex.presentation.onboarding.comps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
	modifier: Modifier = Modifier,
	numPages: Int,
	selectedPage: Int,
	selectedCol: Color = Color.Red,
	unselectedCol:Color = Color.Gray
){
	Row(
		modifier = modifier
	){
		repeat(numPages){
			Box(
				modifier = Modifier.size(16.dp).clip(CircleShape).background(color = if (it == selectedPage) selectedCol else unselectedCol)
			)
		}
	}
}