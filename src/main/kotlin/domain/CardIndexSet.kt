package domain

data class CardIndexSet(val first: Int, val second: Int, val third: Int) {
    val cardIndexSet: Triple<Int, Int, Int>

    init {
        cardIndexSet = Triple(first, second, third)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardIndexSet

        if (setOf(first, second, third) != setOf(other.first, other.second, other.third)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = first
        result = 31 * result + second
        result = 31 * result + third
        return result
    }


}