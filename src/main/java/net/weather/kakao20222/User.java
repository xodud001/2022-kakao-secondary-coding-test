package net.weather.kakao20222;

import lombok.Getter;
import lombok.ToString;
import net.weather.kakao20222.api.Property;

@Getter
@ToString
public class User implements Comparable<User> {

    private final int id;
    private int score;

    public User(int id) {
        this.id = id;
        this.score = 4000;
    }

    public void win(int score){
        this.score = Math.min(Property.MAX_POINT, this.score + score) ;
    }
    public void lose(int score){
        this.score = Math.max(Property.MIN_POINT, this.score - score) ;
    }

    @Override
    public int compareTo(User o) {
        return this.score - o.score;
    }
}
