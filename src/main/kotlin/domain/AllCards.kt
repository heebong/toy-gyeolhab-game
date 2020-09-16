package domain

object AllCards {
    val cards: Set<Card>

    init {
        cards = Shape.values().flatMap { shape ->
            Color.values().flatMap { color ->
                Background.values().map { background -> Card(shape, color, background) }
            }
        }.toSet()
    }

    fun pickRoundCards(): RoundCards {
        val shuffled = cards.shuffled()

        val roundCards = shuffled.subList(0, RoundCards.LIMIT_SIZE)
        return RoundCards(roundCards)
    }
}