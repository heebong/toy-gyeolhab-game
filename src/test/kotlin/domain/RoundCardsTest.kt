package domain

import domain.RoundCards.Companion.LIMIT_SIZE
import exception.RoundCardsException
import org.amshove.kluent.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RoundCardsTest {

    @Test
    fun `LIMIT_SIZE - 9`() {
        LIMIT_SIZE `should be equal to` 9
    }

    @Test
    fun `init`() {
        val roundCards = AllCards.cards.toList().subList(0, LIMIT_SIZE)

        invoking { RoundCards(roundCards) }
            .`should not throw`(AnyException)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, LIMIT_SIZE-1, LIMIT_SIZE+1, 27])
    fun `init - cards 크기가 9가 아니면 RoundCardException 발생`(size: Int) {
        val roundCards = AllCards.cards.toList().subList(0, size)

        validateThrowRoundCardsException(roundCards, "RoundCards의 크기는 ${LIMIT_SIZE}여야 합니다.")
    }

    @Test
    fun `init - cards에는 중복이 있으면 RoundCardException 발생`() {
        val roundCards = AllCards.cards.toList().subList(0, LIMIT_SIZE-1).toMutableList()
        roundCards.add(roundCards.last())

        validateThrowRoundCardsException(roundCards, "중복되는 Card로 설정할 수 없습니다.")
    }

    private fun validateThrowRoundCardsException(
        roundCards: List<Card>,
        message: String
    ) {
        invoking { RoundCards(roundCards) }
            .`should throw`(RoundCardsException::class)
            .`with message`(message)
    }
}