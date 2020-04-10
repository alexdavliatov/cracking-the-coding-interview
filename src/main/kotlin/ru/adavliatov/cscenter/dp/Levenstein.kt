package ru.adavliatov.cscenter.dp

import ru.adavliatov.cracking.recursiondp.IntArray2D
import ru.adavliatov.cracking.recursiondp.intArray2D

fun main() {
    val lev = levensteinDistance(
//        "DISTANCE".toCharArray(),
//        "EDITING".toCharArray()
        readLine()!!.toCharArray(),
        readLine()!!.toCharArray()
    )
//    lev.forEach {
//        println(it.contentToString())
//    }
    println(lev[lev.size - 1][lev[0].size - 1])
}

fun levensteinDistance(a: CharArray, b: CharArray): IntArray2D {
    if (a.size < b.size) return levensteinDistance(b, a)
//    val d = intArray2D(2, b.size + 1) { _, _ -> Int.MAX_VALUE }
    val d = intArray2D(a.size + 1, b.size + 1) { _, _ -> Int.MAX_VALUE }
    d[0][0] = 0
    for (i in a.indices) d[i + 1][0] = i + 1
    for (j in b.indices) d[0][j + 1] = j + 1
//    d[1] = d[0].clone()
    for (i in 1..a.size) {
//        d[1][0]++
        for (j in 1..b.size) {
//            val diff = if (a[i - 1] == b[j - 1]) 0 else 1
//            d[1][j] = minOf(d[0][j] + 1, d[1][j - 1] + 1, d[0][j - 1] + diff)
            val diff = if (a[i - 1] == b[j - 1]) 0 else 1
            d[i][j] = minOf(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + diff)
        }
//        d[0] = d[1].clone()
    }

    return d
//        .also { (0 until d.size).map { println(d[it].contentToString()) } }
}

fun IntArray2D.recoverPath(): List<String> {
    var (i, j) = (size - 1) to (this[0].size - 1)
    val path = mutableListOf<String>()
    while (i > 0 && j > 0) {
        val min = minOf(this[i - 1][j - 1], this[i][j - 1], this[i - 1][j])
        when (min) {
            this[i - 1][j - 1] -> {
                path += if (this[i][j] == min) "Nothing" else "Replace"
                i--
                j--
            }
            this[i - 1][j] -> {
                path += "A-"
                i--
            }
            this[i][j - 1] -> {
                path += "B-"
                j--
            }
        }
    }
    (0 until i).map { path += "A-" }
    (0 until j).map { path += "B-" }

    return path.reversed()
}