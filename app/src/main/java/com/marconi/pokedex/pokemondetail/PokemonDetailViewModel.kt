package com.marconi.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.marconi.pokedex.data.remote.responses.Pokemon
import com.marconi.pokedex.repository.PokemonRepository
import com.marconi.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}