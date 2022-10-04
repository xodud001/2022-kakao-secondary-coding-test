package net.weather.kakao20222;

import net.weather.kakao20222.api.GameApi;
import net.weather.kakao20222.api.request.StartRequest;
import net.weather.kakao20222.api.response.StartResponse;

public class PlayService {

    private final GameApi api;
    public PlayService(String baseUrl, String authToken){
         this.api = new GameApi(baseUrl, authToken);
    }


    public void play(){
        StartResponse start = api.start(new StartRequest(1));

        System.out.println(start);
    }

}
