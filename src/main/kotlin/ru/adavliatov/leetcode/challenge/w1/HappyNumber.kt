package ru.adavliatov.leetcode.challenge.w1

object HappyNumber {
    private val squares = mutableSetOf<Int>()

    fun isHappy(n: Int): Boolean {
        var current = setOf(1, 10, 100)
        while ((current - squares).isNotEmpty()) {
            squares.plusAssign(current)
            current = all(current)
        }

        if (n < 1000) return n in squares

        var sum = 0
        var nt = n
        while (nt > 0) {
            val d = nt % 10
            sum += d * d
            nt /= 10
        }

        return sum in squares
    }

    fun all(targets: Set<Int>): MutableSet<Int> {
        val res: MutableSet<Int> = mutableSetOf()
        (0..9).map { a ->
            (0..9).map { b ->
                (0..9).map { c ->
                    val square = square(a, b, c)
                    if (square in targets) res.plusAssign(100 * a + 10 * b + c)
                }
            }
        }

        return res
    }

    fun square(a: Int, b: Int, c: Int) = a * a + b * b + c * c
}

fun main() {
    println(HappyNumber.isHappy(68))
}