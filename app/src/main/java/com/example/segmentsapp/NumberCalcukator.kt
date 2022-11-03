package com.example.segmentsapp

class IndicatorManager {
    var currentIndicatorState = IntArray(7) { 0 }

    fun updateIndicatorState(segmentNum: Int, isSelected: Boolean) {
        currentIndicatorState[segmentNum - 1] = isSelected.toInt()
    }

    fun getNumber(): Number {
        return if (
            Number
                .values()
                .map { it.code }
                .contains(currentIndicatorState.joinToString(""))
        ) {
            Number.values().first { it.code == currentIndicatorState.joinToString("") }
        } else Number.UNDEFINED
    }

    fun resetIndicator() {
        currentIndicatorState.map { 0 }
    }

    private fun Boolean.toInt() = if (this) 1 else 0

    enum class Number(val code: String, val number: String?) {
        ZERO("1111110", "0"),
        ONE("0001100", "1"),
        TWO("1011011", "2"),
        THREE("0011111", "3"),
        FOUR("0101101", "4"),
        FIVE("0110111", "5"),
        SIX("1110111", "6"),
        SEVEN("0011100", "7"),
        EIGHT("1111111", "8"),
        NINE("0111111", "9"),
        UNDEFINED("UNDEFINED", null)
    }
}