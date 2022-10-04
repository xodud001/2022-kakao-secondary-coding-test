package net.weather.kakao20222.api.request;

import java.util.List;

public record ChangeGradeRequest(List<UserRequest> commands) {
}
