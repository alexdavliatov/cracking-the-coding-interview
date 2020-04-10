package ru.adavliatov.cscenter.sort

import kotlin.math.abs

fun main() {
    val (n, m) = readPair()

    val default = 0 to 0
    val ls = Array(n) { default }
    val rs = Array(n) { default }

//    val lc = mutableMapOf<Int, Int>().withDefault { 0 }
//    val rc = mutableMapOf<Int, Int>().withDefault { 0 }

    (0 until n)
        .map {
            val range = readPair() mult 2
            val (l, r) = range

//            lc[l] = lc.getValue(l) + 1
//            rc[r] = rc.getValue(r) + 1

            ls[it] = range
            rs[it] = range
        }

    val lComparator = Comparator { r1: Pair<Int, Int>, r2: Pair<Int, Int> -> r1.first.compareTo(r2.first) }
    val rComparator = Comparator { r1: Pair<Int, Int>, r2: Pair<Int, Int> -> r1.second.compareTo(r2.second) }

    ls.sortWith(lComparator)
    rs.sortWith(rComparator)

    numbers()
        .map { point ->
            val p = point * 2
            val lpos = ls.binarySearch((p + 1) to 0, lComparator, 0, n).prepare()
            val rpos = rs.binarySearch(0 to (p - 1), rComparator, 0, n).prepare()

            maxOf(0, abs(n - (n - lpos) - rpos)) //lc.getValue(p)
        }
        .joinToString(" ")
        .let { println(it) }
}

private fun readPair() = readLine()!!.split(" ").let { it[0].toInt() to it[1].toInt() }
private fun numbers() = readLine()!!.split(" ").asSequence().map { it.toInt() }
private fun Int.prepare() = if (this < 0) -this - 1 else this
private infix fun Pair<Int, Int>.mult(n: Int) = first * n to second * n
//6 4
//0 7
//2 6
//5 9
//6 8
//6 9
//8 9
//5 6 7 8

