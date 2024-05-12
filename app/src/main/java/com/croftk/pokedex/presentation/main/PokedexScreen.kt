package com.croftk.pokedex.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import com.croftk.pokedex.R
import com.croftk.pokedex.presentation.common.Button
import com.croftk.pokedex.presentation.main.comps.AllPokemon
import com.croftk.pokedex.presentation.main.comps.Home
import com.croftk.pokedex.presentation.main.comps.SearchBox
import com.croftk.pokedex.presentation.main.comps.SinglePokemon
import com.croftk.pokedex.presentation.main.data.Pokemon
import okhttp3.internal.wait

@Composable
fun PokedexScreen(modifier: Modifier = Modifier) {
	var dexViewState = remember {
		mutableStateOf("home")
	}
	var searchValue = remember {
		mutableStateOf("")
	}
	val pokedexViewModel: PokedexViewModel = viewModel()
	val viewState by pokedexViewModel.allPokemonState
	val selectedPokemon = remember {
		mutableStateOf<Pokemon?>(null)
	}


	Column(
		modifier
			.fillMaxSize()
			.background(color = Color("#FF3131".toColorInt())),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceBetween
	) {
		Image(painter = painterResource(id = R.drawable.top_pokedex), contentDescription = null)
		Column(
			modifier = Modifier
				.fillMaxWidth(0.9f)
				.fillMaxHeight(0.7f)
				.padding(top = 24.dp)
				.background(color = Color.White)
				.border(5.dp, color = Color.Black),
			horizontalAlignment = Alignment.End,
			verticalArrangement = Arrangement.Top
		) {
			when(dexViewState.value){
				"home"-> Home()
				"all"-> AllPokemon(
					viewState = viewState,
					selectedPokemon = selectedPokemon,
					dexViewState = dexViewState,
					searchValue = searchValue
				)
				"single"-> SinglePokemon(selectedPokemon = selectedPokemon)
				"search"->{
					SearchBox(searchValue = searchValue)
					AllPokemon(
						viewState = viewState,
						selectedPokemon = selectedPokemon,
						dexViewState = dexViewState,
						searchValue = searchValue
					)
				}
				else-> Home()
			}
		}
		Column(
			modifier = Modifier
				.fillMaxWidth(0.9f)
				.fillMaxHeight(),
			verticalArrangement = Arrangement.Center
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(),
				horizontalArrangement = Arrangement.SpaceEvenly,
				verticalAlignment = Alignment.CenterVertically
			) {
				Button(
					modifier = Modifier,
					colors = ButtonDefaults.buttonColors(
						containerColor = Color.White,
					),
					text = "",
					icon = Icons.Default.Home,
					onClick = {
						dexViewState.value = "home"
					}
				)
				Column {
					Button(
						colors = ButtonDefaults.buttonColors(
							containerColor = Color("#C13333".toColorInt()),
							contentColor = Color.White
						),
						text = "All Poké",
						icon = Icons.Default.List,
						onClick = {
							dexViewState.value = "all"
						}
					)
					Button(
						colors = ButtonDefaults.buttonColors(
							containerColor = Color("#335DAB".toColorInt()),
							contentColor = Color.White
						),
						text = " Search ",
						icon = Icons.Default.Search,
						onClick = {
							dexViewState.value = "search"
						}
					)
				}
				Column {
					Button(
						colors = ButtonDefaults.buttonColors(
							containerColor = Color.White,
						),
						text = "",
						icon = Icons.Default.KeyboardArrowUp,
						onClick = {}
					)
					Button(
						colors = ButtonDefaults.buttonColors(
							containerColor = Color.White,
						),
						text = "",
						icon = Icons.Default.KeyboardArrowDown,
						onClick = {}
					)
				}
			}
		}
	}
}

@Preview
@Composable
private fun PokePrev() {
	PokedexScreen()
}