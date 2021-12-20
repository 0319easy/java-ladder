package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.stream.Collectors;

/**
 * @author han
 */
public class ResultView {
    private static final String RESULT = "실행결과";
    private static final String FIVE_SPACE = "     ";
    private static final String LINE_WITH_BRIDGE = "-----|";
    private static final String LINE_WITHOUT_BRIDGE = FIVE_SPACE + "|";

    public static void print(Ladder ladder) {
        System.out.println(RESULT);
        System.out.println(printUsers(ladder.getUsers()));
        System.out.println(printLines(ladder.getLines()));
    }

    private static String printUsers(Users users) {
        return users.getUsers().
            stream().
            map(user -> FIVE_SPACE + printUser(user))
            .collect(Collectors.joining());
    }

    private static String printUser(User user) {
        return user.getName();
    }

    private static String printLines(Lines lines) {
        return lines.getLines().
            stream()
            .map(line -> printLine(line) + "\n")
            .collect(Collectors.joining());
    }

    private static String printLine(Line line) {
        return line.getPoints()
            .stream()
            .map(point -> printPoint(point))
            .collect(Collectors.joining());
    }

    private static String printPoint(Point point) {
        return point.hasLineBefore() ? LINE_WITH_BRIDGE : LINE_WITHOUT_BRIDGE;
    }
}
