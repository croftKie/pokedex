package com.croftk.pokedex.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.croftk.pokedex.presentation.main.data.Pokemon
import kotlinx.coroutines.launch

class PokedexViewModel: ViewModel() {

	private val _allPokemonState = mutableStateOf(AllPokemonState())
	val allPokemonState: State<AllPokemonState> = _allPokemonState

	init{
		fetchAllPokemon()
	}

	private fun fetchAllPokemon(){
		viewModelScope.launch {
			try{
				val res = pokemonService.getPokemon()
				println(res)
				_allPokemonState.value = _allPokemonState.value.copy(
					list = res,
					loading = false,
					error = null
				)
			} catch (e: Exception){
				_allPokemonState.value = _allPokemonState.value.copy(
					loading = false,
					error = "Error fetching Pokemon data: ${e}"
				)
			}
		}
	}

	data class AllPokemonState(
		val loading: Boolean = true,
		val error: String? = null,
		val list: List<Pokemon> = emptyList()
	)

}