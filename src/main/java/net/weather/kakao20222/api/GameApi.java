package net.weather.kakao20222.api;

import net.weather.kakao20222.api.request.ChangeGradeRequest;
import net.weather.kakao20222.api.request.MatchRequest;
import net.weather.kakao20222.api.request.StartRequest;
import net.weather.kakao20222.api.response.*;
import org.springframework.web.reactive.function.client.WebClient;


public class GameApi {

    private final WebClient client;

    public GameApi(String baseUrl, String authToken) {
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Auth-Token", authToken)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public StartResponse start(StartRequest request){
        return this.client.post()
                .uri(uriBuilder -> uriBuilder.path("/start").build())
                .bodyValue(request)
                .retrieve()
                .bodyToMono(StartResponse.class)
                .block();

    }

    public WaitingResponse waitingLine(String authKey){
        return this.client.get()
                .uri(uriBuilder -> uriBuilder.path("/waiting_line").build())
                .header("Authorization", authKey)
                .retrieve()
                .bodyToMono(WaitingResponse.class)
                .block();
    }

    public GameResultResponse gameResult(String authKey){
        return this.client.get()
                .uri(uriBuilder -> uriBuilder.path("/game_result").build())
                .header("Authorization", authKey)
                .retrieve()
                .bodyToMono(GameResultResponse.class)
                .block();
    }

    public UserInfoResponse userInfo(String authKey){
        return this.client.get()
                .uri(uriBuilder -> uriBuilder.path("/user_info").build())
                .header("Authorization", authKey)
                .retrieve()
                .bodyToMono(UserInfoResponse.class)
                .block();
    }

    public MatchResponse match(MatchRequest request, String authKey){
        return this.client.put()
                .uri(uriBuilder -> uriBuilder.path("/match").build())
                .header("Authorization", authKey)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(MatchResponse.class)
                .block();
    }

    public ChangeGradeResponse changeGrade(ChangeGradeRequest request, String authKey){
        return this.client.put()
                .uri(uriBuilder -> uriBuilder.path("/change_grade").build())
                .header("Authorization", authKey)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChangeGradeResponse.class)
                .block();
    }

    public ScoreResponse score(String authKey){
        return this.client.get()
                .uri(uriBuilder -> uriBuilder.path("/score").build())
                .header("Authorization", authKey)
                .retrieve()
                .bodyToMono(ScoreResponse.class)
                .block();
    }
}
