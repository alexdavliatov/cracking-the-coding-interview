package ru.adavliatov.cscenter.dp

fun main() {
    val w = readLine()!!.split(" ")[0].toInt()
    val ws = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
//    val stairs = "3 4 10 10 0 -6 -10 0".split(" ").map { it.toInt() }
//    println(knapsack(10, intArrayOf(6, 3, 4, 2), intArrayOf(30, 14, 16, 9)))
//    println(knapsack(10, intArrayOf(1, 4, 8), intArrayOf(1, 4, 8)))
    println(knapsack(w, ws, ws))
}

fun knapsackWithDups(w: Int, ws: IntArray, cs: IntArray): Int {
    val d = IntArray(w + 1) { 0 }

    for (i in 1..w) {
        for (j in 0 until ws.size) {
            val wj = ws[j]
            val cj = cs[j]
            if (i - wj >= 0) {
                d[i] = maxOf(d[i], d[i - wj] + cj)
            }
        }
    }

    println(d.contentToString())

    return d[w]
}

fun knapsack(w: Int, ws: IntArray, cs: IntArray): Int {
    val d = intArray2D(w + 1, cs.size + 1) { _, _ -> 0 }

    for (i in 1..w) {
        for (j in 1..ws.size) {
            val wj = ws[j - 1]
            val cj = cs[j - 1]
            d[i][j] = d[i][j - 1]
            if (i - wj >= 0) {
                d[i][j] = maxOf(d[i][j - 1], d[i - wj][j - 1] + cj)
            }
        }
    }

//    println(d.joinToString("\n") { it.contentToString() })

    return d[w][ws.size]
}
typealias IntArray2D = Array<IntArray>

fun intArray2D(rows: Int, cols: Int, block: (i: Int, j: Int) -> Int): IntArray2D =
    Array(rows) { i ->
        IntArray(cols) { j -> block(i, j) }
    }
