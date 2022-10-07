package api.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonUrl {

    @JsonProperty("count")
    public long count;
    @JsonProperty("next")
    public String next;
    @JsonProperty("previous")
    public Object previous;
    @JsonProperty("results")
    public List<Result> results = null;

    public long getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public Object getPrevious() {
        return previous;
    }

    public List<Result> getResults() {
        return results;
    }
}
