package net.weather.kakao20222.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StartResponse(@JsonProperty("auth_key") String authKey, Integer problem, Integer time) {
}
