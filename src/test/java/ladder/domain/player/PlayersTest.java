package ladder.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayersTest {
    Players players;

    @BeforeEach
    void before() {
        String names = "pobi, hano, zero";
        players = new Players(names);
    }

    @Test
    void validNameCheck() {
        String names = "pobi, hano, zero, zero";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Players(names));
    }


}