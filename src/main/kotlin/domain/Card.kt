package domain

fun List<Card>.indexOfPlusOne(element: Card) = this.indexOf(element) + 1

fun isHab(sum: Int) = sum % 3 == 0

data class Card(
    val shape: Shape,
    val color: Color,
    val background: Background
)