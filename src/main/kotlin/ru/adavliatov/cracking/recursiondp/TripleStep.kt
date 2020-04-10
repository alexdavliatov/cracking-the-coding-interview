package ru.adavliatov.cracking.recursiondp

import kotlin.math.max

fun tripleStep(n: Int): Int {
    val arr = IntArray(max(n + 1, 3))
    arr[0] = 1
    arr[1] = 2
    arr[2] = 4

    for (i in 3..n) {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
    }
    return arr[n]
}