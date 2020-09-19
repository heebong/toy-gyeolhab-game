package domain

enum class Shape(val description: String, val number: Int) {
    STAR("별", 1),
    MOON("달", 2),
    SUN("해", 3)
}

enum class Color(val description: String, val number: Int) {
    GREEN("녹", 1),
    PURPLE("보", 2),
    ORANGE("주", 3)
}

enum class Background(val description: String, val number: Int) {
    WHITE("흰", 1),
    GRAY("회", 2),
    BLACK("검", 3)
}