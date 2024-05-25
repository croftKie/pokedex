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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberAsyncImagePainter
import com.croftk.pokedex.R
import com.croftk.pokedex.presentation.main.data.Pokemon
import com.croftk.pokedex.ui.theme.bug
import com.croftk.pokedex.ui.theme.dark
import com.croftk.pokedex.ui.theme.dragon
import com.croftk.pokedex.ui.theme.electric
import com.croftk.pokedex.ui.theme.fairy
import com.croftk.pokedex.ui.theme.fighting
import com.croftk.pokedex.ui.theme.fire
import com.croftk.pokedex.ui.theme.flying
import com.croftk.pokedex.ui.theme.ghost
import com.croftk.pokedex.ui.theme.grass
import com.croftk.pokedex.ui.theme.ground
import com.croftk.pokedex.ui.theme.ice
import com.croftk.pokedex.ui.theme.normal
import com.croftk.pokedex.ui.theme.poison
import com.croftk.pokedex.ui.theme.psychic
import com.croftk.pokedex.ui.theme.rock
import com.croftk.pokedex.ui.theme.steel
import com.croftk.pokedex.ui.theme.water
import java.util.Locale

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
				.fillMaxHeight(0.3f),
			verticalAlignment = Alignment.Top
		) {
			PokeImage(selectedPokemon)
			HeaderInfo(selectedPokemon = selectedPokemon)
		}
		Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
			LocationInfo(selectedPokemon = selectedPokemon)
			AbilityInfo(selectedPokemon = selectedPokemon)
		}
		BottomText(selectedPokemon = selectedPokemon)
	}
}
	
@Composable
fun PokeImage(selectedPokemon: MutableState<Pokemon?>){
	Column(modifier = Modifier
		.fillMaxWidth(0.3f)
		.clip(shape = RoundedCornerShape(8.dp))
		.background(Color.White),
		verticalArrangement = Arrangement.Top){
		Image(
			modifier = Modifier
				.fillMaxHeight(0.7f)
				.background(Color.White),
			painter = rememberAsyncImagePainter(selectedPokemon.value?.imageUrl),
			contentDescription = null
		)
	}
}

@Composable
fun HeaderInfo(selectedPokemon: MutableState<Pokemon?>){
	Column(
		modifier = Modifier
			.padding(start = 12.dp)
			.fillMaxWidth()
			.fillMaxHeight(),
		verticalArrangement = Arrangement.Top,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Column(
			modifier = Modifier
				.clip(shape = RoundedCornerShape(8.dp))
				.background(Color.White)
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
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 8.dp),
			horizontalArrangement = Arrangement.spacedBy(8.dp),
			verticalAlignment = Alignment.Top
		) {
			selectedPokemon.value?.types?.forEachIndexed { index, type ->
				Text(
					modifier = Modifier
						.clip(shape = RoundedCornerShape(4.dp))
						.background(selectColor(type))
						.padding(4.dp),
					text = type
				)
			}
		}
	}
}

@Composable
fun LocationInfo(selectedPokemon: MutableState<Pokemon?>){
	Column(
		modifier = Modifier
			.fillMaxWidth(0.5f)
			.clip(shape = RoundedCornerShape(8.dp))
			.background(Color.White),
		horizontalAlignment = Alignment.Start,
		verticalArrangement = Arrangement.spacedBy(8.dp)
	) {
		selectedPokemon.value?.locations?.forEachIndexed { index, loc ->
			Text( modifier = Modifier.padding(8.dp), text = loc)
		}
	}
}

@Composable
fun AbilityInfo(selectedPokemon: MutableState<Pokemon?>){
	Column(
		modifier = Modifier
			.fillMaxWidth(1f)
			.clip(shape = RoundedCornerShape(8.dp))
			.background(Color.White),
		horizontalAlignment = Alignment.Start,
		verticalArrangement = Arrangement.spacedBy(8.dp)
	) {
		selectedPokemon.value?.abilities?.forEachIndexed { index, ability ->
			Text( modifier = Modifier.padding(8.dp), text = ability.name)
		}
	}
}

@Composable
fun BottomText(selectedPokemon: MutableState<Pokemon?>){
	Column(modifier = Modifier
		.fillMaxHeight(1f),
		verticalArrangement = Arrangement.Bottom
	){
		Box(
			modifier = Modifier
				.padding(8.dp)
				.clip(shape = RoundedCornerShape(8.dp))
				.background(Color.White)
				.fillMaxHeight(0.4f),
		){
			Text(modifier = Modifier.padding(16.dp), text = selectedPokemon.value?.description!!)
		}
	}
}


fun selectColor(type: String): Color{
	when (type.lowercase(Locale.getDefault())){
		"bug" -> return bug
		"dark" -> return dark
		"dragon" -> return dragon
		"electric" -> return electric
		"fairy" -> return fairy
		"fighting" -> return fighting
		"fire" -> return fire
		"flying" -> return flying
		"ghost" -> return ghost
		"grass" -> return grass
		"ground" -> return ground
		"ice" -> return ice
		"normal" -> return normal
		"poison" -> return poison
		"psychic" -> return psychic
		"rock" -> return rock
		"steel" -> return steel
		"water" -> return water
		else -> return Color.White
	}
}