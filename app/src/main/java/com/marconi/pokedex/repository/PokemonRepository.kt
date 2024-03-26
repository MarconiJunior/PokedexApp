package com.marconi.pokedex.repository

import com.marconi.pokedex.data.remote.PokeApi
import com.marconi.pokedex.data.remote.responses.Pokemon
import com.marconi.pokedex.data.remote.responses.PokemonList
import com.marconi.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    private val defaultErrorMessage = "An unknown error occurred."

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(defaultErrorMessage)
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Resource.Error(defaultErrorMessage)
        }
        return Resource.Success(response)
    }
}
