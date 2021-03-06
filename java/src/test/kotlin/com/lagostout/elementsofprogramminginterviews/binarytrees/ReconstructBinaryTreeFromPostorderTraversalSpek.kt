package com.lagostout.elementsofprogramminginterviews.binarytrees

import org.assertj.core.api.SoftAssertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

object ReconstructBinaryTreeFromPostorderTraversalSpek : Spek({
    describe("reconstructBinaryTreeFromPostorderTraversal") {
        val data = listOf(
                Pair(listOf('A'), listOf('A')),
                Pair(listOf('B','A'), listOf('B','A')),
                Pair(listOf('B','A'), listOf('A','B')),
                Pair(listOf('B','A','C'), listOf('A','B','C')),
                Pair(listOf('D','E','B','C','A'), listOf('E','D','B','C','A')),
                Pair(listOf('D','E','B','A','C'), listOf('E','D','B','C','A')),
                Pair(listOf('D','E','C','B','A'), listOf('C','E','D','B','A')),
                Pair(listOf('D','B','E','A','C'), listOf('D','B','A','E','C')),
                Pair(listOf('D','E','B','A','C'), listOf('E','D','B','C','A')),
                null
        ).filterNotNull()
        data.forEach { (inorder, postorder) ->
            given("inorder: $inorder, postorder: $postorder") {
                it("returns a tree that has the same traversal orders") {
                    reconstructBinaryTreeFromPostorderTraversal(
                            inorder, postorder)?.let {
                        with (SoftAssertions()) {
                            assertThat(postorderTraversal(it).map { it.second })
                                    .`as`("postorder traversal")
                                    .isEqualTo(postorder)
                            assertThat(inorderTraversal(it).map { it.second })
                                    .`as`("inorder traversal")
                                    .isEqualTo(inorder)
                            assertAll()
                        }
                    }
                }
            }
        }
    }
})
