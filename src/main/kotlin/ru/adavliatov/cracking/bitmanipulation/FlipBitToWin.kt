package ru.adavliatov.cracking.bitmanipulation

object FlipBitToWin {

    fun handle(n: Int): Int {
        var t = n
        while (t and 1 == 0) t = t shr 1
        var i = 0
        while ((t shr i) and 1 == 1) i++
        t = t or (1 shl i)

        return t
    }
}

@ExperimentalUnsignedTypes
fun main(vararg args: String) {
    println(FlipBitToWin.handle(0b11011101111000).toUInt().toString(2))
}
