package com.cqfn.degitx.simulator

import org.testng.annotations.Test

import org.testng.Assert.*
import org.testng.annotations.BeforeSuite

class GraphGeneratorTest {

    var graph = GraphGenerator()
    var grIns = DsGraph

    @BeforeSuite
    fun setUp() {
        grIns = graph.generate(GraphGenerator.Settings())
    }

    @Test
    fun testGenerate() {
        assertEquals(DsGraph.nodes.isNotEmpty(), true)
        assertEquals(DsGraph.edges.isNotEmpty(), true)
        assertEquals(DsGraph.nodes.size, 4)
        assertEquals(DsGraph.edges.size, 6)
        assertEquals(DsGraph.outgoingEdges(DsGraph.nodes[0]).size, 1)
        assertEquals(DsGraph.incomingEdges(DsGraph.nodes[0]).size, 3)
    }
}