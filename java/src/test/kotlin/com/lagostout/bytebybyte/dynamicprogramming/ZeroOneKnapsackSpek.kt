package com.lagostout.bytebybyte.dynamicprogramming

import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack.Item.Companion.i
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack._computeWithRecursion1
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack._computeWithRecursion2
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack._computeWithRecursion3
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack._computeWithRecursion4
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack._computeWithRecursion5
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack.computeWithMemoizationBottomUp1
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack.computeWithMemoizationBottomUp2
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack.computeWithRecursion
import com.lagostout.bytebybyte.dynamicprogramming.ZeroOneKnapsack.computeWithRecursionAndMemoization
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on

object ZeroOneKnapsackSpek : Spek({

    val data = listOfNotNull(
            data(emptySet(), 0, 0),
            data(emptySet(), 1, 0),
            data(emptySet(), 1, 0),
            data(setOf(i(1, 1)), 0, 0),
            data(setOf(i(1, 1)), 1, 1),
            data(setOf(i(1, 1)), 2, 1),
            data(setOf(i(1, 2)), 1, 0),
            data(setOf(i(1, 1), i(2, 1)), 1, 2),
            data(setOf(i(1, 1), i(1, 1)), 1, 1),
            data(setOf(i(1, 1), i(1, 1)), 2, 2),
            data(setOf(i(1, 1), i(2, 2)), 1, 1),
            data(setOf(i(1, 1), i(3, 2)), 3, 4),
            data(setOf(i(1, 1), i(3, 2), i(4, 1)), 3, 7),
            data(setOf(i(8, 3), i(3, 2), i(2, 1)), 3, 8),
            data(setOf(i(6, 1), i(10, 2), i(12, 3)), 5, 22),
            null
    ).toTypedArray()

    xdescribe("computeWithRecursion") {
        on("items %s, maxWeight: %s", with = *data) {
            items, maxWeight, expected ->
            it("should return $expected") {
                assertThat(computeWithRecursion(
                    items, maxWeight, ::_computeWithRecursion1)).isEqualTo(expected)
                assertThat(computeWithRecursion(
                    items, maxWeight, ::_computeWithRecursion2)).isEqualTo(expected)
                assertThat(computeWithRecursion(
                    items, maxWeight, ::_computeWithRecursion3)).isEqualTo(expected)
                assertThat(computeWithRecursion(
                    items, maxWeight, ::_computeWithRecursion4)).isEqualTo(expected)
                assertThat(computeWithRecursion(
                    items, maxWeight, ::_computeWithRecursion5)).isEqualTo(expected)
            }
        }
    }

    describe("computeWithRecursionAndMemoization") {
        on("items %s, maxWeight: %s", with = *data) {
            items, maxWeight, expected ->
            it("should return $expected") {
                assertThat(computeWithRecursionAndMemoization(
                        items.toList(), maxWeight)).isEqualTo(expected)
            }
        }
    }

    xdescribe("computeWithMemoizationBottomUp1") {
        on("items %s, maxWeight: %s", with = *data) {
                items, maxWeight, expected ->
            it("should return $expected") {
                assertThat(computeWithMemoizationBottomUp1(
                    items, maxWeight)).isEqualTo(expected)
            }
        }
    }

    xdescribe("computeWithMemoizationBottomUp2") {
        on("items %s, maxWeight: %s", with = *data) {
                items, maxWeight, expected ->
            it("should return $expected") {
                assertThat(computeWithMemoizationBottomUp2(
                    items, maxWeight)).isEqualTo(expected)
            }
        }
    }
})