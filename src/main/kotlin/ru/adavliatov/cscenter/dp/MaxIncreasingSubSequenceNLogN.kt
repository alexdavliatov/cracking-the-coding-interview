package ru.adavliatov.cscenter.dp

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { -it.toInt() }.toIntArray()
    val (max, path) = maxIncreasingSubsequenceNLogN(arr)
    println(max)
    println(path.joinToString(separator = " "))
}

fun maxIncreasingSubsequenceNLogN(arr: IntArray): Pair<Int?, List<Int>> {
    val d = IntArray(arr.size + 1) { Int.MAX_VALUE }
    val di = IntArray(arr.size + 1) { Int.MAX_VALUE }
    val dp = IntArray(arr.size + 1) { Int.MAX_VALUE }
    var dSize = 0
    d[dSize++] = Int.MIN_VALUE
    d[dSize] = arr[0]
    di[dSize++] = 0
    val n = arr.size
    for (i in 1 until n) {
        val elem = arr[i]
        if (elem >= d[dSize - 1]) {
            dp[i] = di[dSize - 1]
            d[dSize] = elem
            di[dSize++] = i
            continue
        }

        var ji = d.binarySearch(elem, 0, dSize - 1)
        val j = if (ji < 0)
            -ji - 1
        else {
            while (d[ji] == elem) ji++
            ji
        }
        d[j] = elem
        di[j] = i
        dp[i] = di[j - 1]

    }

    val path = mutableListOf<Int>()

    var i = di[dSize - 1]
    while (i < Int.MAX_VALUE) {
        path += i
        i = dp[i]
    }

    return path.size to path.reversed().map { it + 1 }
}