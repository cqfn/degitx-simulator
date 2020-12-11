package com.cqfn.degitx.simulator

import org.testng.annotations.Test

import org.testng.Assert.*
import org.testng.annotations.BeforeSuite

class RouterTest {

    var graph = GraphGenerator()

    @BeforeSuite
    fun setUp() {
        graph.generate(GraphGenerator.Settings())
    }

    @Test
    fun testRun() {
        var router = DsGraph.nodes.get(3)
        assertTrue(router.hardware.storage == null)
    }
}