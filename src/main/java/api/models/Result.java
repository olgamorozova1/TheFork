package api.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("name")
    public String name;
    @JsonProperty("url")
    public String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
