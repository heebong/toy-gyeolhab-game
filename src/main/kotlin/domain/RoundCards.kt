package domain

import exception.RoundCardsException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

data class RoundCards(val cards: List<Card>) {

    init {
        validateInitRoundCards(cards.size == LIMIT_SIZE) { "RoundCards의 크기는 ${LIMIT_SIZE}여야 합니다." }
        validateInitRoundCards(cards.size == cards.toSet().size) { "중복되는 Card로 설정할 수 없습니다." }
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