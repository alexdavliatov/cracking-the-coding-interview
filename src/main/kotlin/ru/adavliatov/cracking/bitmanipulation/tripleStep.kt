package ru.adavliatov.cracking.bitmanipulation

val NumberOf1s = { n: Int ->
    var count = 0
    var t = n
    while (t > 0) {
        if (t and 1 == 1) ++count

        t = t shr 1
    }

    count
}

@ExperimentalUnsignedTypes
fun main(vararg args: String) {
    println(NumberOf1s(0b11011101111001))
}
