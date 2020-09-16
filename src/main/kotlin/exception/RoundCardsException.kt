package exception

class RoundCardsException(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause)
