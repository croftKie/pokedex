package com.croftk.pokedex.presentation.onboarding.data

import androidx.annotation.DrawableRes
import com.croftk.pokedex.R

data class Page(
	val title: String,
	val desc: String,
	@DrawableRes val image: Int
)

val Pages = listOf<Page>(
	Page(
		title = "Catch 'em All!",
		desc = "Find everything you'd need to know about the original 151 Pokémon. Including full colour sprites, types and locations.",
		image = R.drawable.onboard_0
	),
	Page(
		title = "Search and Select",
		desc = "You can explore the pokemon one by one, or search for a specific pokemon by their name.",
		image = R.drawable.onboard_1
	),
	Page(
		title = "Styled like Ash's.",
		desc = "The Pokédex uses a retro style to give the feeling of Ash's Pokédex from the manga and anime.",
		image = R.drawable.onboard_2
	)
)