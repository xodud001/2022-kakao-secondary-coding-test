package net.weather.kakao20222.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserInfoResponse(@JsonProperty("user_info") List<UserResponse> userInfo) {
}
