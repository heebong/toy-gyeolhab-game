package domain

class Player(val name: String) {
    private var _score: Long = 0
    val score
        get() = _score

    fun win() {
        _score += 1
    }
}