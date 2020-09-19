package domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CardTest {

    @ParameterizedTest
    @ValueSource(ints = [3, 6, 9])
    fun `isHab - 숫자의 합이 3의 배수일 경우만 합이다`(sum: Int) {
        isHab(sum) `should be equal to` true
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 4, 5, 8])
    fun `isHab - 숫자의 합이 3의 배수가 아니면 합이 아니다`(sum: Int) {
        isHab(sum) `should be equal to` false
    }
}