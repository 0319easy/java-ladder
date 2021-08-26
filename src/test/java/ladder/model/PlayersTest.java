package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("게임 참가자 컬렉션 테스트")
public class PlayersTest {

    @DisplayName("게임 참가자들은 주입받은 이름 목록대로 정상 생성되어야 한다.")
    @Test
    void createPlayersTest() {
        // given, when
        Players players = new Players(Arrays.asList("pobi", "honux", "crong", "jk"));

        // when, then
        assertThat(players.getNames()).containsExactly("pobi", "honux", "crong", "jk");
    }

    @DisplayName("게임 참가자가 없으면 예외가 발생한다.")
    @Test
    void emptyPlayersExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(Collections.emptyList()))
                .withMessage("게임 참가자가 없습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(null))
                .withMessage("게임 참가자가 없습니다.");
    }
}
