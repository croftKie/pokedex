package com.croftk.pokedex.presentation.main

import com.croftk.pokedex.presentation.main.data.AllPokemon
import com.croftk.pokedex.presentation.main.data.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit
	.Builder()
	.baseUrl("https://pokeapi.deno.dev/")
	.addConverterFactory(GsonConverterFactory.create())
	.build()

val pokemonService = retrofit.create(ApiService::class.java)

interface ApiService {
	@GET("pokemon/")
	suspend fun getPokemon(): List<Pokemon>

}