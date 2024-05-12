package com.croftk.pokedex.presentation.main.data

data class Pokemon(
	val id: Int,
	val name: String,
	val genus: String,
	val description: String,
	val imageUrl: String,
	val types: List<String>,
	val abilities: List<Ability>,
//	val stats: List<Any>,
	val locations: List<String>,
	val color: String,
)

data class Ability(
	val name: String,
	val effect: String,
	val description: String,
)

data class AllPokemon(
	val results: List<Pokemon>
)