package ru.adavliatov.cracking.sortsearch

fun main() {
    val arr = arrayOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
    println(sparseSearch(arr, "dad"))
    println(sparseSearch(arr, "at"))
    println(sparseSearch(arr, "ball"))
    println(sparseSearch(arr, "bal"))
}


fun sparseSearch(arr: Array<String>, elem: String) = sparseSearch(arr, elem, 0, arr.size)

fun sparseSearch(arr: Array<String>, elem: String, left: Int, right: Int): Int? {
    if (left > right) return null

    val pivot = (left + right) / 2

    return when {
        arr[pivot] == "" -> sparseSearch(arr, elem, left, pivot - 1) ?: sparseSearch(arr, elem, pivot + 1, right)
        arr[pivot] < elem -> sparseSearch(arr, elem, left, pivot - 1)
        arr[pivot] > elem -> sparseSearch(arr, elem, left, pivot - 1)
        else -> pivot
    }
}