package domain

data class CardSet(val first: Card, val second: Card, val third: Card) {
    val cardSet: Triple<Card, Card, Card>

    init {
        cardSet = Triple(first, second, third)
    }

    fun isHab() = isHab(sumShapeNumber()) and isHab(sumColorNumber()) and isHab(sumBackgroundNumber())

    private fun sumShapeNumber() = cardSet.toList().map { it.shape }.sumBy { it.number }
    private fun sumColorNumber() = cardSet.toList().map { it.color }.sumBy { it.number }
    private fun sumBackgroundNumber() = cardSet.toList().map { it.background }.sumBy { it.number }

    fun toIndexOfPlusOne(cards: List<Card>) =
        CardIndexSet(cards.indexOfPlusOne(first), cards.indexOfPlusOne(second), cards.indexOfPlusOne(third))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardSet

        if (setOf(first, second, third) != setOf(other.first, other.second, other.third)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = first.hashCode()
        result = 31 * result + second.hashCode()
        result = 31 * result + third.hashCode()
        return result
    }
}