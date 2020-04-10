package ru.adavliatov.cscenter

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import ru.adavliatov.cscenter.heap.ListHeap
import kotlin.Int.Companion.MIN_VALUE

class ListHeapTest : BehaviorSpec({
    Given("expected size") {
        When("calculating size") {
            Then("should take nearest 2^x") {
                val heap = ListHeap(10, MIN_VALUE)
                heap.maxSize shouldBe 15
            }
            Then("return itself if 2^x") {
                val heap = ListHeap(32, MIN_VALUE)
                heap.maxSize shouldBe 31
            }
        }
    }

    Given("heap") {
        val heap = ListHeap(32, MIN_VALUE)
        When("calculating parent") {
            heap.parent(0) shouldBe -1
            heap.parent(2) shouldBe 0
            heap.parent(4) shouldBe 1
            heap.parent(5) shouldBe 2
            heap.parent(6) shouldBe 2
        }
        When("calculating children") {
            heap.children(0) shouldBe (1 to 2)
            heap.children(4) shouldBe (9 to 10)
            heap.children(13) shouldBe (27 to 28)
            heap.children(14) shouldBe (29 to 30)
            heap.children(15) shouldBe (-1 to -1)
            heap.children(30) shouldBe (-1 to -1)
        }
    }

    Given("empty heap") {
        val heap = ListHeap(6, Int.MAX_VALUE)

        When("added elements") {
            heap.run {
                insert(20)
                insert(4)
                insert(3)
                insert(30)
                insert(21)
                insert(30)
                insert(5)
            }

            Then("should sort them") {
                heap.extractMin() shouldBe 3
                heap.extractMin() shouldBe 4
                heap.extractMin() shouldBe 5
                heap.extractMin() shouldBe 20
                heap.extractMin() shouldBe 21
                heap.extractMin() shouldBe 30
                heap.extractMin() shouldBe 30
            }
        }
    }

})