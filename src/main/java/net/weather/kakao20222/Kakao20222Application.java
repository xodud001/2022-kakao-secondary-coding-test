package net.weather.kakao20222;

import lombok.RequiredArgsConstructor;
import net.weather.kakao20222.api.GameApi;
import net.weather.kakao20222.api.request.StartRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class Kakao20222Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Kakao20222Application.class, args);

        String baseUrl = "https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod";
        String authToken = "3afcabcf0232e6a152273fa34ca69bcd";

        new PlayService(baseUrl, authToken).play();

        context.close();
    }

}
