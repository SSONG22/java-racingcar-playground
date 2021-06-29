package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @DisplayName("1. 문자열을 숫자로 변환")
    @Test
    void 쉼표_또는_콜론_구분() {
        assertThat(StringAddCalculator.changeIntoNum("")).isEqualTo(Arrays.asList());
        assertThat(StringAddCalculator.changeIntoNum("1,2")).isEqualTo(Arrays.asList(1, 2));
        assertThat(StringAddCalculator.changeIntoNum("1,2,3")).isEqualTo(Arrays.asList(1, 2, 3));
        assertThat(StringAddCalculator.changeIntoNum("1,2:3")).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("2. 숫자 계산")
    @Test
    void 리스트_넘버_덧셈() {
        assertThat(StringAddCalculator.sumList(Arrays.asList())).isEqualTo(0);
        assertThat(StringAddCalculator.sumList(Arrays.asList(1, 2))).isEqualTo(3);
        assertThat(StringAddCalculator.sumList(Arrays.asList(1, 2, 3))).isEqualTo(6);
    }

    @DisplayName("합치기")
    @Test
    void 문자열덧셈() {
        assertThat(StringAddCalculator.addValue("")).isEqualTo(0);
        assertThat(StringAddCalculator.addValue("1,2")).isEqualTo(3);
        assertThat(StringAddCalculator.addValue("1,2,3")).isEqualTo(6);
        assertThat(StringAddCalculator.addValue("1,2:3")).isEqualTo(6);
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}