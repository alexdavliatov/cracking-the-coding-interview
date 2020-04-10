package ru.adavliatov.leetcode.challenge.w1

class SingleNumber {
    fun singleNumber(nums: IntArray) = nums.reduceRight { elem, acc -> elem xor acc }
}

fun main() {
    println(SingleNumber().singleNumber(intArrayOf(2,2,1)))
}