package domain

class Players(names: Pair<String, String>) {
    val white: Player = Player(names.first)
    val black: Player = Player(names.second)
    val nowTurn: Player = white
}