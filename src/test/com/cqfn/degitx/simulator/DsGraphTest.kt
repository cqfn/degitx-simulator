package com.cqfn.degitx.simulator

import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import org.testng.Assert.*
import java.util.*

class DsGraphTest {

    var node1 = Node(NodeHardware(SATAStorage(),
            BasicNetwork(Address("one"), LinkedList(), 1L)),
            State.ACTIVE)
    var node2 = Node(NodeHardware(SATAStorage(),
            BasicNetwork(Address("two"), LinkedList(), 2L)),
            State.ACTIVE)
    var edge1 = Edge(node1, node2)

    var graph = DsGraph

    @BeforeMethod
    fun setUp() {
        graph.nodes = listOf(node1, node2)
        graph.edges = listOf(edge1)
    }

    @AfterMethod
    fun tearDown() {
    }

    @Test
    fun testOutgoingEdges() {
        assertEquals(graph.outgoingEdges(node1)[0], edge1)
    }

    @Test
    fun testIncomingEdges() {
        assertEquals(graph.incomingEdges(node2)[0], edge1)
    }
}