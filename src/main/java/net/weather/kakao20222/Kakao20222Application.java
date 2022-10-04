package net.weather.kakao20222;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Kakao20222Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Kakao20222Application.class, args);

        context.close();
    }

}
