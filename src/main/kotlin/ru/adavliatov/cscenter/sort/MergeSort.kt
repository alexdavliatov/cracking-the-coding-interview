package ru.adavliatov.cscenter.sort

fun main() {
    intArrayOf(7, 6, 5, 4, 3, 2, 1)
        .apply { mergesort() }
        .run { println(contentToString()) }
}

fun IntArray.mergesort(s: Int = 0, f: Int = this.size - 1) {
    if (f - s <= 1) return

    val m = partitionMergesort(s, f)
    quicksort(s, m - 1)
    quicksort(m + 1, f)
}

private fun IntArray.partitionMergesort(s: Int, f: Int): Int {
    val m = r.nextInt(s, f)
    swap(s, m)
    val el = this[s]
    var l = s

    for (i in s + 1..f) {
        if (this[i] > el) continue

        swap(l + 1, i)
        swap(l, ++l)
    }

    return l
}

private fun IntArray.merge(s: Int, m: Int, f: Int) {
    var l = m - 1
    var r = f

    while (l >= 0 && r >= 0) {
        if (this[l] <= this[r]) {
            l++
        } else {
            r++
        }
    }
}