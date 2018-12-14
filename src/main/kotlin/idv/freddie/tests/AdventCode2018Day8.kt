/*
 * Copyright (c) 2018 LINE Corporation. All rights Reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package idv.freddie.tests

import java.util.LinkedList
import java.util.Queue

// https://adventofcode.com/2018/day/8
class TreeNode {
    val childs: MutableList<TreeNode> = mutableListOf()
    val metadata: MutableList<Int> = mutableListOf()
    val value: Int
        get() = if (childs.size == 0) {
            metadata.sum()
        } else {
            var sum = 0
            metadata.forEach { ref ->
                if (ref - 1 < childs.size) {
                    sum += childs[ref - 1].value
                }
            }
            sum
        }
}

class AdventCode2018Day8 {

    fun exec(input: List<Int>) {
        val iter = input.iterator()

        val root = createNode(iter)
        root?.let {
            print("sum: ${sumMetaData(it)}\n" )
        }

        print("value of root: ${root?.value}")
    }

    private fun sumMetaData(root: TreeNode): Int {
        var sum = 0
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            node.childs.forEach {
                queue.offer(it)
            }

            sum += node.metadata.sum()
        }
        return sum
    }

    private fun createNode(iter: Iterator<Int>): TreeNode? {
        if (!iter.hasNext()) {
            return null
        }
        val numOfChild = iter.next()
        val numOfMeta = iter.next()
        val node = TreeNode()
        for (i in 0 until numOfChild) {
            val child = createNode(iter)
            child?.let {
                node.childs.add(child)
            }
        }

        for (j in 0 until numOfMeta) {
            if (iter.hasNext()) {
                node.metadata.add(iter.next())
            }
        }

        return node
    }
}
