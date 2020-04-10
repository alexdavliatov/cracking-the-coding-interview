package ru.adavliatov.cscenter.dp

fun maxIncreasingSubsequence(arr: IntArray) : Pair<Int?, List<Int>> {
    val lengths = IntArray(arr.size) { 1 }
    for (i in 1 until arr.size) lengths[i] = arr.maxForElementBefore(i, lengths)

    return lengths.max() to arr.recoverSubSequence(lengths)
}

private fun IntArray.maxForElementBefore(i: Int, lengths: IntArray): Int {
    var max = 1
    for (j in i - 1 downTo 0) {
        if (this[i] <= this[j] && max <= lengths[j])
            max = lengths[j] + 1
    }

    return max
}

private fun IntArray.maxForElementBeforeMod(i: Int, lengths: IntArray): Int {
    var max = 1
    for (j in i - 1 downTo 0) {
        if (this[i] % this[j] == 0 && max <= lengths[j])
            max = lengths[j] + 1
    }

    return max
}

fun IntArray.recoverSubSequence(lengths: IntArray): List<Int> {
    var currentIndex = lengths.size - 1
    var currentMax = lengths[currentIndex]
    var tempMax = currentMax
    var tempElem = this[currentIndex]
    var path = mutableListOf(currentIndex)
    for (i in currentIndex - 1 downTo 0) {
        when {
            lengths[i] > currentMax -> {
                currentIndex = i
                currentMax = lengths[i]
                tempMax = currentMax
                tempElem = this[currentIndex]
                path = mutableListOf(currentIndex)
            }
            lengths[i] == tempMax - 1 && this[i] >= tempElem -> {
                tempMax--
                tempElem = this[i]
                path.plusAssign(i)
            }
        }
    }

    return path.map { this[it] }.reversed()
//    return path.reversed().map { it + 1 }
}