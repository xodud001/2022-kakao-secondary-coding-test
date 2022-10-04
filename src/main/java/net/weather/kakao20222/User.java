package net.weather.kakao20222;

import lombok.Getter;

@Getter
public class User {

    private int score;

    public User() {
        this.score = 40_000;
    }
}
