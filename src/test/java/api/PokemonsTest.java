package api;

import api.clients.PokemonClient;
import api.models.PokemonUrl;

import org.junit.Test;

import java.util.List;


public class PokemonsTest {

    @Test
    public void saveNormalTypePokemon() {
        PokemonClient pokemonClient = new PokemonClient();

        PokemonUrl pokemonUrl = pokemonClient.getNumberOfPokemonsWithUrl(30);
        List<String> pokemonsOfNormalType = pokemonClient.findPokemonOfType(pokemonUrl, "normal");
    }
}
