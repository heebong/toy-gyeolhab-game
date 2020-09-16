package domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test


class AllCardsTest {

    @Test
    fun `all - 모든 경우의 카드 수를 미리 만든다`() {
        val allCards = AllCards.cards

        allCards.size `should be equal to` 27
    }

    @Test
    fun `pickRoundCards - 9장의 카드를 임의로 뽑는다`() {
        val roundCards = AllCards.pickRoundCards()

        roundCards.cards.size `should be equal to` 9
        roundCards.cards.size `should be equal to` roundCards.cards.toSet().size
    }
}