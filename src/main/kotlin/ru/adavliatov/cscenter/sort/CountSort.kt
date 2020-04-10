package ru.adavliatov.cscenter.sort

fun main() {
    val n = readLine()!!.toInt()
    val counts = IntArray(11) { 0 }

    readLine()!!
        .split(" ")
        .forEach { counts[it.toInt()]++ }

    var sb = StringBuilder(2 * n - 1)
    counts.forEachIndexed { i, count ->
        repeat(count) { sb = sb.append(i).append(" ") }
    }
    println(sb.removeSurrounding(" "))
}

fun t(): Int {
    while (true);
}