package ru.adavliatov.cscenter.heap

import kotlin.Int.Companion.MAX_VALUE

interface Heap<T : Comparable<T>> {
    fun insert(element: T)
    fun remove(element: T)
    fun min(): T = uncheckedMin() ?: throw IllegalArgumentException("No elements to find")
    fun uncheckedMin(): T?
    fun extractMin(): T = uncheckedExtractMin() ?: throw IllegalArgumentException("No elements to extract")
    fun uncheckedExtractMin(): T?
}

class ListHeap<T : Comparable<T>>(
    private val expectedSize: Int,
    private val defaultMaxValue: T
) : Heap<T> {
    init {
        if (expectedSize <= 0) throw IllegalArgumentException("Heap size should be positive")
    }

    val maxSize: Int
        get() {
            var size = 1
            while (size < expectedSize) size = size shl 1

            return size - 1
        }
    private val heap: MutableList<T> = MutableList(maxSize) { defaultMaxValue }
    private var size: Int = 0

    override fun insert(element: T) {
        heap[size] = element
        siftUp(size++)
    }

    override fun remove(element: T) = TODO("To be implemented")

    override fun uncheckedMin(): T? {
        if (size <= 0) return null

        return heap[0]
    }

    override fun uncheckedExtractMin(): T? {
        if (size <= 0) return null

        val min = heap[0]
        heap[0] = heap[--size]
        heap[size] = defaultMaxValue

        siftDown(0)

        return min
    }

    private fun siftUp(position: Int) {
        var current = position
        var parent = parent(current)
        while (parent >= 0 && heap[current] < heap[parent]) {
            heap.swap(current, parent)

            current = parent
            parent = parent(current)
        }
    }

    private fun siftDown(position: Int) {
        var current = position
        var minChild = minChild(current)
        while (minChild >= 0 && heap[minChild] < heap[current]) {
            heap.swap(current, minChild)

            current = minChild
            minChild = minChild(current)
        }
    }

    internal fun parent(child: Int): Int {
        if (child == 0) return -1

        return (child + 1) / 2 - 1
    }

    internal fun minChild(parent: Int): Int {
        val parentPosition = parent + 1
        if (2 * parentPosition > maxSize) return -1

        val (child1, child2) = (parentPosition * 2 - 1) to (parentPosition * 2)
        return if (heap[child1] < heap[child2])
            child1
        else
            child2
    }

    internal fun children(parent: Int): Pair<Int, Int> {
        val parentPosition = parent + 1
        if (2 * parentPosition > maxSize) return -1 to -1

        val (child1, child2) = (parentPosition * 2 - 1) to (parentPosition * 2)
        return if (heap[child1] <= heap[child2])
            child1 to child2
        else
            child2 to child1
    }

    private fun MutableList<T>.swap(i: Int, j: Int) {
        val t = this[i]
        this[i] = this[j]
        this[j] = t
    }

    override fun toString(): String = heap.toString()
}

fun main() {
    val n = readLine()!!.toInt()
    val heap = ListHeap(n, MAX_VALUE)
    for (i in 0 until n) {
        val split = readLine()!!.split(" ")

        when (split[0]) {
            "Insert" -> heap.insert(-split[1].toInt())
            "ExtractMax" -> println(-heap.extractMin())
        }
    }
}

