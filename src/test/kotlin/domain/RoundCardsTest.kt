package domain

import domain.Background.BLACK
import domain.Background.GRAY
import domain.Background.WHITE
import domain.Color.GREEN
import domain.Color.ORANGE
import domain.Color.PURPLE
import domain.RoundCards.Companion.LIMIT_SIZE
import domain.Shape.MOON
import domain.Shape.STAR
import domain.Shape.SUN
import exception.RoundCardsException
import org.amshove.kluent.AnyException
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should not throw`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.`with message`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.*

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

    @Test
    fun `합 리스트를 찾는다`() {
        val cards = listOf(
            Card(MOON, GREEN, BLACK), Card(SUN, GREEN, GRAY), Card(SUN, PURPLE, GRAY),
            Card(MOON, GREEN, WHITE), Card(SUN, GREEN, WHITE), Card(STAR, PURPLE, BLACK),
            Card(STAR, ORANGE, BLACK), Card(MOON, ORANGE, BLACK), Card(MOON, PURPLE, BLACK)
        )
        val roundCards = RoundCards(cards)

        val habs: Set<CardIndexSet> = roundCards.habs

        habs `should be equal to` setOf(CardIndexSet(9, 8, 1), CardIndexSet(7, 4, 3))
    }
}