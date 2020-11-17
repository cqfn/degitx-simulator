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
        assertEquals(grIns.nodes.isNotEmpty(), true)
        assertEquals(grIns.edges.isNotEmpty(), true)
        assertEquals(grIns.incomingEdges(grIns.nodes[0]).size, 4)
    }
}