package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {
    @Test
    void reverteToString() {
        assertThat("abcdef").isEqualTo(new ReversedSequence("fedcba").toString());
    }
}
