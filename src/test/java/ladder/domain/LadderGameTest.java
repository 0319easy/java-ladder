package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {

    private LineBuildStrategy lineBuildStrategy;

    @BeforeEach
    public void init(){
        lineBuildStrategy = new RandomLineBuildStrategy();
    }


    @DisplayName("사다리 생성 테스트")
    @Test
    void ladderBuildTest(){
        // given
        int ladderMaxHeight = 5;

        //when
        Ladders ladders = new Ladders(IntStream.range(0, ladderMaxHeight)
                .mapToObj(ladder -> new Ladder(lineBuildStrategy.build(3)))
                .collect(Collectors.toList()));

        // then
        assertThat(ladders.getLadders().size()).isEqualTo(ladderMaxHeight);
    }


    @DisplayName("사다리 최소 높이(1)보다 작은 경우 Exception Test")
    @ParameterizedTest
    @ValueSource(ints = {0, -2})
    void illegalPlayerNameExceptionTest(int maxHeight){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            LadderGame ladderGame = new LadderGame(new RandomLineBuildStrategy());
            ladderGame.start(3, maxHeight);

        }).withMessageContaining(LadderGameErrorMessage.OVER_MIN_HEIGHT.getErrorMessage());
    }


}
