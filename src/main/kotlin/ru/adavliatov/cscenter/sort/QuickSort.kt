package ru.adavliatov.cscenter.sort

import kotlin.random.Random

fun main() {
    intArrayOf(7, 6, 5, 4, 3, 2, 1)
        .apply { quicksort() }
        .run { println(contentToString()) }
}

val r: Random = Random

fun IntArray.quicksort(s: Int = 0, f: Int = this.size - 1) {
    if (f - s <= 1) return

    val m = partition(s, f)
    quicksort(s, m - 1)
    quicksort(m + 1, f)
}

private fun IntArray.partition(s: Int, f: Int): Int {
    val m = r.nextInt(s, f)
    swap(s, m)
    val el = this[s]
    var l = s

    for (i in s + 1..f) {
        if (this[i] > el) continue

        l++
        swap(l, i)
    }
    swap(s, l)

    return l
}

fun IntArray.swap(i: Int, j: Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}