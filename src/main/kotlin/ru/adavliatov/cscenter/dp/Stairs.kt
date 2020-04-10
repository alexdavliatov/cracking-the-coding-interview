package ru.adavliatov.cscenter.dp

fun main() {
    readLine()
    val stairs = readLine()!!.split(" ").map { it.toInt() }
//    val stairs = "3 4 10 10 0 -6 -10 0".split(" ").map { it.toInt() }
    println(stairs(stairs))
}

fun stairs(stairs: List<Int>): Int {
    if (stairs.isEmpty()) return 0
    val n = stairs.size
    if (n == 1) return stairs.first()
    if (n == 2) return maxOf(stairs[1], stairs[0] + stairs[1])
    val go = MutableList(n) { 0 }
    go[0] = stairs[0]
    go[1] = maxOf(stairs[1], stairs[0] + stairs[1])
    for (i in 2 until n) {
        go[i] = maxOf(go[i - 1], go[i - 2]) + stairs[i]
    }

    return go[n - 1]
}
