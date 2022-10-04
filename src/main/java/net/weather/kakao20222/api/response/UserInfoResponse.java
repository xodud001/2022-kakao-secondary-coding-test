package net.weather.kakao20222.api.response;

import java.util.List;

public record UserInfoResponse(List<UserResponse> user_info) {
}
