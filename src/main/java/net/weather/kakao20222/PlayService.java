package net.weather.kakao20222;

import net.weather.kakao20222.api.GameApi;
import net.weather.kakao20222.api.Property;
import net.weather.kakao20222.api.request.ChangeGradeRequest;
import net.weather.kakao20222.api.request.MatchRequest;
import net.weather.kakao20222.api.request.StartRequest;
import net.weather.kakao20222.api.request.UserRequest;
import net.weather.kakao20222.api.response.*;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayService {

    private final GameApi api;
    private final String authKey;
    private final Map<Integer, User> users;

    public PlayService(String baseUrl, String authToken) {
        this.api = new GameApi(baseUrl, authToken);

        StartResponse start = api.start(new StartRequest(2));
        this.authKey = start.authKey();

        UserInfoResponse userInfoResponse = api.userInfo(start.authKey());
        users = userInfoResponse.userInfo().stream().map(u -> new User(u.id())).collect(Collectors.toMap(User::getId, Function.identity()));
    }


    public void simulation() {

        play(authKey);

        ScoreResponse score = api.score(authKey);
        System.out.println("score = " + score);
    }

    private void play(String authKey) {

        api.match(new MatchRequest(new Integer[0][0]), authKey);

        // available matching
        for (int i = 1; i < 595; i++) {
            System.out.println("== GAME " + i + " ==");
            GameResultResponse gameResultResponse = api.gameResult(authKey);
            System.out.println(gameResultResponse);
            adjustGrade(gameResultResponse.gameResult());

            WaitingResponse waitingResponse = api.waitingLine(authKey);
            System.out.println(waitingResponse);
            List<MatchingUserResponse> waitings = waitingResponse.waitingLine();
            PriorityQueue<User> queue = new PriorityQueue<>();
            for (MatchingUserResponse waitingUser : waitings) {
                queue.offer(users.get(waitingUser.id()));
            }

            Integer[][] pairs = new Integer[queue.size() / 2][2];
            int j = 0;
            while (!queue.isEmpty() && queue.size() >= 2) {
                pairs[j][0] = queue.poll().getId();
                pairs[j][1] = queue.poll().getId();
                j++;
            }
            MatchResponse match = api.match(new MatchRequest(pairs), authKey);
            System.out.println(match);
        }
        push();

        MatchResponse match = api.match(new MatchRequest(new Integer[0][0]), authKey);
        System.out.println(match);
    }

    private void push() {
        List<UserRequest> userRequests = users.values().stream().map(u -> new UserRequest(u.getId(), u.getScore())).collect(Collectors.toList());
        System.out.println(userRequests);
        api.changeGrade(new ChangeGradeRequest(userRequests), authKey);
    }

    private void adjustGrade(List<ResultInfo> gameResult) {
        for (ResultInfo result : gameResult) {

            User winner = users.get(result.win());
            User loser = users.get(result.lose());

            double point = Property.BASE_POINT * ( (Property.MAX_PLAY_TIME - result.taken() - Property.MIN_PLAY_TIME) / (double)Property.MAX_PLAY_TIME);

            winner.win((int) point);
            loser.lose((int) point);

            System.out.println("== Adjust ==");
            System.out.println("Winner: " + winner);
            System.out.println("Loser: " + loser);
            System.out.println("Match Point: " + point);
        }
    }

}
