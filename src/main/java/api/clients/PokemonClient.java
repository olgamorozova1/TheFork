package api.clients;

import api.NetworkUtil;
import api.models.PokemonUrl;
import api.models.Result;
import io.restassured.http.Method;
import io.restassured.response.Response;
import utils.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class PokemonClient extends NetworkUtil {

    public PokemonUrl getNumberOfPokemonsWithUrl(int limit) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(FileReader.readProperties("limit_param"), "30");
        Response allPokemonsResponse = request(
                Method.GET,
                FileReader.readProperties("pokemons_endpoint"),
                queryParams);
        Assert.assertEquals(allPokemonsResponse.getStatusCode(), 200);
        return allPokemonsResponse.getBody().as(PokemonUrl.class);
    }

    public List<String> findPokemonOfType(PokemonUrl pokemonUrl, String type) {
        List<String> pokemonsOfSpecifiedType = new ArrayList<>();

        for (Result result : pokemonUrl.getResults()) {
            Response pokemonResponse = request(
                    Method.GET,
                    result.getUrl());
            if (pokemonResponse.jsonPath().get("types.type.name").toString().contains(type)) {
                pokemonsOfSpecifiedType.add(result.name);
            }
        }
        return pokemonsOfSpecifiedType;
    }
}
