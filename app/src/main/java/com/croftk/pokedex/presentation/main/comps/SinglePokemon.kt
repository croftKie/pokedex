package com.croftk.pokedex.presentation.main.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberAsyncImagePainter
import com.croftk.pokedex.R
import com.croftk.pokedex.presentation.main.data.Pokemon

@Composable
fun SinglePokemon(modifier: Modifier = Modifier, selectedPokemon: MutableState<Pokemon?>) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color(selectedPokemon.value?.color?.toColorInt()!!))
			.padding(18.dp)
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.70f),
			verticalAlignment = Alignment.CenterVertically
		) {
			Box(modifier = Modifier
				.fillMaxWidth(0.5f)
				.background(Color.White)
				.border(5.dp, color = Color.Black)){
				Image(
					modifier = Modifier
						.fillMaxSize(0.9f)
						.background(Color.White)
						.align(Alignment.Center),
					painter = rememberAsyncImagePainter(selectedPokemon.value?.imageUrl),
					contentDescription = null
				)
			}
			Column(
				modifier = Modifier
					.padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
					.fillMaxWidth()
					.fillMaxHeight(),
				verticalArrangement = Arrangement.SpaceBetween,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Column(
					modifier = Modifier
						.background(Color.White)
						.border(2.dp, color = Color.Black)
						.padding(8.dp)
						.fillMaxWidth()
				){
					Row(
						verticalAlignment = Alignment.CenterVertically
					) {
						Image(
							modifier = Modifier
								.fillMaxSize(0.15f)
								.background(Color.White),
							painter = painterResource(id = R.drawable.pokeball),
							contentDescription = null
						)
						Text(
							fontSize = 20.sp,
							fontWeight = FontWeight.Bold,
							text = selectedPokemon.value?.name!!
						)
					}
					Text(text = selectedPokemon.value?.genus!!)
				}
				Text(text = "Types:", modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.Bold)
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween
				) {
					selectedPokemon.value?.types?.forEachIndexed { index, type ->
						Text(
							modifier = Modifier
								.background(Color.White)
								.border(2.dp, color = Color.Black)
								.padding(8.dp),
							text = type
						)
					}
				}
				Text(text = "Locations:", modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.Bold)
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.background(Color.White)
						.border(2.dp, color = Color.Black),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					selectedPokemon.value?.locations?.forEachIndexed { index, loc ->
						Text(text = loc)
					}
				}
			}
		}
		Box(modifier = Modifier
			.background(Color.White)
			.fillMaxSize()
			.border(5.dp, color = Color.Black)){
			Text(
				modifier = Modifier
					.padding(24.dp)
					.background(Color.White),
				text = selectedPokemon.value?.description!!
			)
		}
	}
}