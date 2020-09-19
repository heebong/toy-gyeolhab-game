package domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.*

internal class CardSetTest {
    @ParameterizedTest
    @MethodSource("provideForIsHab")
    fun `isHab - 합인 경우`(cardSet: CardSet) {
        cardSet.isHab() `should be equal to` true
    }

    @ParameterizedTest
    @MethodSource("provideForIsHabNot")
    fun `isHab - 합이 아닌 경우`(cardSet: CardSet) {
        cardSet.isHab() `should be equal to` false
    }

    private fun provideForIsHab(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(CardSet(Card(Shape.MOON, Color.GREEN, Background.BLACK), Card(Shape.MOON, Color.ORANGE, Background.BLACK), Card(Shape.MOON, Color.PURPLE, Background.BLACK))),
            Arguments.of(CardSet(Card(Shape.MOON, Color.GREEN, Background.BLACK), Card(Shape.STAR, Color.ORANGE, Background.BLACK), Card(Shape.SUN, Color.PURPLE, Background.BLACK))),
            Arguments.of(CardSet(Card(Shape.MOON, Color.GREEN, Background.BLACK), Card(Shape.STAR, Color.ORANGE, Background.GRAY), Card(Shape.SUN, Color.PURPLE, Background.WHITE)))
        )
    }

    private fun provideForIsHabNot(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(CardSet(Card(Shape.MOON, Color.GREEN, Background.BLACK), Card(Shape.MOON, Color.ORANGE, Background.BLACK), Card(Shape.MOON, Color.PURPLE, Background.GRAY))),
            Arguments.of(CardSet(Card(Shape.MOON, Color.GREEN, Background.BLACK), Card(Shape.STAR, Color.ORANGE, Background.BLACK), Card(Shape.SUN, Color.GREEN, Background.BLACK))),
            Arguments.of(CardSet(Card(Shape.MOON, Color.GREEN, Background.BLACK), Card(Shape.SUN, Color.ORANGE, Background.GRAY), Card(Shape.SUN, Color.PURPLE, Background.WHITE)))
        )
    }
}