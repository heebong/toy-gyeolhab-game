package domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

internal class PlayersTest {
    @Test
    fun constructor() {
        // when
        val players = Players("white" to "black")

        // then
        players.white.name `should be equal to` "white"
        players.black.name `should be equal to` "black"
        players.nowTurn `should be equal to` players.white
    }
}