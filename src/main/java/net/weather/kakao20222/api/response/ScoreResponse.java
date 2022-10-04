package net.weather.kakao20222.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ScoreResponse(String status,
                            @JsonProperty("efficiency_score") Float efficiencyScore,
                            @JsonProperty("accuracy_score1") Float accuracyScore1,
                            @JsonProperty("accuracy_score2") Float accuracyScore2,
                            Float score
) {
}
