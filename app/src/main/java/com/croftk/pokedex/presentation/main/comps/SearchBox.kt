package com.croftk.pokedex.presentation.main.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBox(modifier: Modifier = Modifier, searchValue: MutableState<String>) {
	Row (
		modifier = Modifier.padding(16.dp).background(Color.White).border(4.dp, Color.Black),
		verticalAlignment = Alignment.CenterVertically
	){
		Image(
			Icons.Default.Search,
			contentDescription = null,
			modifier = Modifier.padding(18.dp)
			)
		TextField(
			label = { Text(text = "Search Pokemon")},
			value = searchValue.value,
			onValueChange = {
				searchValue.value = it
			}
		)
	}
}

//@Preview
//@Composable
//private fun sp() {
//	SearchBox()
//}