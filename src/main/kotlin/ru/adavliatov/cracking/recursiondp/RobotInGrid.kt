package ru.adavliatov.cracking.recursiondp

fun main(vararg args: String) {
    println(robotInGrid(3, 3))
}

fun robotInGrid(r: Int, c: Int): Int {
    val arr = intArray2D(r, c) { _, _ -> 0 }
    for (i in 0 until r) arr[i][0] = 1
    for (j in 0 until c) arr[0][j] = 1
//    var prevRow = IntArray(c) { 1 }
//    var prevColumn = IntArray(r) { 1 }
    for (i in 1 until r)
        for (j in 1 until c)
            arr[i][j] = arr[i - 1][j] + arr[i][j - 1]

    return arr[r - 1][c - 1]
}

typealias DoubleArray2D = Array<DoubleArray>

fun doubleArray2D(rows: Int, cols: Int, block: (i: Int, j: Int) -> Double): DoubleArray2D =
    Array(rows) { i ->
        DoubleArray(cols) { j -> block(i, j) }
    }

typealias IntArray2D = Array<IntArray>

fun intArray2D(rows: Int, cols: Int, block: (i: Int, j: Int) -> Int): IntArray2D =
    Array(rows) { i ->
        IntArray(cols) { j -> block(i, j) }
    }