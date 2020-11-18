package domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

internal class PlayerTest {

    @Test
    internal fun create() {
        // given
        val name = "player1"

        // when
        val player = Player(name = name)

        // then
        player.name `should be equal to` name
        player.score `should be equal to` 0L
    }

    @Test
    fun win_score_1_point() {
        // given
        val player = Player(name = "player")

        // when
        player.win()

        // then
        player.score `should be equal to` 1L
    }
}