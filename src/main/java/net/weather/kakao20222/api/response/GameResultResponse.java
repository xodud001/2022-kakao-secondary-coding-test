package net.weather.kakao20222.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameResultResponse(@JsonProperty("game_result") List<ResultInfo> gameResult) {
}
