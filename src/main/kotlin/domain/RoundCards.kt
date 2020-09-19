package domain

import com.marcinmoskala.math.combinations
import domain.RoundCards.Companion.LIMIT_SIZE
import exception.RoundCardsException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

private val combinations = (0 until LIMIT_SIZE).toSet().combinations(3)

data class RoundCards(val cards: List<Card>) {
    val habs: Set<CardIndexSet>
    val candidateHabs: MutableSet<CardIndexSet>

    init {
        validateInitRoundCards(cards.size == LIMIT_SIZE) { "RoundCards의 크기는 ${LIMIT_SIZE}여야 합니다." }
        validateInitRoundCards(cards.size == cards.toSet().size) { "중복되는 Card로 설정할 수 없습니다." }

        habs = combinations
                .asSequence()
            .map { it.toList() }
            .map { CardSet(cards[it[0]], cards[it[1]], cards[it[2]]) }
            .filter { it.isHab() }
            .map { it.toIndexOfPlusOne(cards) }
            .toSet()
        candidateHabs = habs.toMutableSet()
    }

    companion object {
        const val LIMIT_SIZE = 9
    }
}

/**
 * [RoundCards]를 초기화할 때 사용하는 validate.
 * Throws an [RoundCardsException] with the result of calling [lazyMessage] if the [value] is false.
 */
@OptIn(ExperimentalContracts::class)
private inline fun validateInitRoundCards(value: Boolean, lazyMessage: () -> Any) {
    contract {
        returns() implies value
    }
    if (!value) {
        val message = lazyMessage()
        throw RoundCardsException(message.toString())
    }
}