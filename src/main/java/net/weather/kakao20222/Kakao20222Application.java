package net.weather.kakao20222;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@RequiredArgsConstructor
public class Kakao20222Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Kakao20222Application.class, args);

        String baseUrl = "https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod";
        String authToken = "bb63aceb4b8e57855b1b18767497e4d0";

        new PlayService(baseUrl, authToken).simulation();

        context.close();
    }

}
