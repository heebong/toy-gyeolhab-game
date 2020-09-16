package domain

enum class Shape(val description: String) {
    STAR("별"),
    MOON("달"),
    SUN("해")
}

enum class Color(val description: String) {
    GREEN("녹"),
    PURPLE("보"),
    ORANGE("주")
}

enum class Background(val description: String) {
    WHITE("흰"),
    GRAY("회"),
    BLACK("검")
}