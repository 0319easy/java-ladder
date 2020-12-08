package my.project.view;

import java.util.Scanner;

/**
 * Created : 2020-12-04 오전 8:53
 * Developer : Seo
 */
public class InputView {
    public static final String ENTER_USERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String ENTER_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getUsers() {
        System.out.println(ENTER_USERS);
        return scanner.nextLine();
    }

    public static int getLadderHeight() {
        System.out.println(ENTER_LADDER_HEIGHT);
        return scanner.nextInt();
    }

    private InputView() {
    }
}
