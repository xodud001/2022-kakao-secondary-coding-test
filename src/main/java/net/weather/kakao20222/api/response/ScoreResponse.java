package net.weather.kakao20222.api.response;

public record ScoreResponse(String status,
                            Float efficiencyScore,
                            Float accuracyScore1,
                            Float accuracyScore2,
                            Float score
) {
}
