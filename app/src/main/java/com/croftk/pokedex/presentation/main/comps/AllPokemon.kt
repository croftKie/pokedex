package com.croftk.pokedex.presentation.main.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberAsyncImagePainter
import com.croftk.pokedex.R
import com.croftk.pokedex.presentation.main.PokedexViewModel
import com.croftk.pokedex.presentation.main.data.Pokemon

@Composable
fun AllPokemon(
	modifier: Modifier = Modifier,
	viewState: PokedexViewModel.AllPokemonState,
	selectedPokemonIndex: MutableState<Int>,
	dexViewState: MutableState<String>,
	searchValue: MutableState<String>,
	listState: LazyListState
) {

	val filtered = viewState.list.filter {
		it.name.contains(searchValue.value)
	}

	LazyColumn(
		modifier = Modifier.padding(top = 16.dp),
		horizontalAlignment = Alignment.End,
		state = listState
	) {
		itemsIndexed(filtered){ index, it ->
			Row(
				modifier = Modifier
					.fillMaxWidth(if (selectedPokemonIndex.value == index) 0.9f else 0.7f)
					.height(48.dp)
					.clip(shape = RoundedCornerShape(8.dp))
					.background(Color(it.color.toColorInt())),
				verticalAlignment = Alignment.CenterVertically,
				){
				Image(
					modifier = Modifier
						.padding(horizontal = 8.dp)
						.fillMaxHeight(0.75f),
					painter = rememberAsyncImagePainter(it.imageUrl),
					contentDescription = null
				)
				Text(
					text = it.name,
					color = Color.DarkGray,
					fontWeight = FontWeight.Bold,
					fontSize = 24.sp,
				)
			}
			Spacer(modifier = Modifier.height(24.dp))
		}
	}
}