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
		title = "lorem ipsum text here",
		desc = "lorem ipsum text is often used to provide a simulation of text blocks when true text is unavailable.",
		image = R.drawable.onboard_0
	),
	Page(
		title = "lorem ipsum text here",
		desc = "lorem ipsum text is often used to provide a simulation of text blocks when true text is unavailable.",
		image = R.drawable.onboard_1
	),
	Page(
		title = "lorem ipsum text here",
		desc = "lorem ipsum text is often used to provide a simulation of text blocks when true text is unavailable.",
		image = R.drawable.onboard_2
	)
)