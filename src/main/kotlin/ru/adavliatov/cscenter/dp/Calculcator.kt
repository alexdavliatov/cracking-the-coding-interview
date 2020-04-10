package ru.adavliatov.cscenter.dp

fun main() {
    val n = readLine()!!.toInt()
    val (nearest, seq) = nearest(n)
    println(nearest)
    println(seq.joinToString(" "))
}

fun nearest(n: Int): Pair<Int, List<Int>> {
    val arr = IntArray(maxOf(n, 5) + 1)
    arr[0] = 0
    arr[1] = 0
    arr[2] = 1
    arr[3] = 1
    arr[4] = 2
    arr[5] = 3

    for (i in 6..n) {
        when {
            i % 6 == 0 -> arr[i] = minOf(arr[i - 1], arr[i / 2], arr[i / 3]) + 1
            i % 3 == 0 -> arr[i] = minOf(arr[i - 1], arr[i / 3]) + 1
            i % 2 == 0 -> arr[i] = minOf(arr[i - 1], arr[i / 2]) + 1
            else -> arr[i] = arr[i - 1] + 1
        }
    }

    var j = n
    val seq = mutableListOf(n)
    while (j > 0) {
        when {
            j % 3 == 0 && arr[j / 3] + 1 == arr[j] -> j /= 3
            j % 2 == 0 && arr[j / 2] + 1 == arr[j] -> j /= 2
            else -> j -= 1
        }

        seq += j
    }

    return arr[n] to seq.dropLast(1).reversed()

}
