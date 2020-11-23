package com.cqfn.degitx.simulator

import org.testng.Assert
import org.testng.annotations.Test

import org.testng.Assert.*
import org.testng.annotations.BeforeTest

class RouterTest {

    var graph = GraphGenerator()

    @BeforeTest
    fun setUp() {
        graph.generate(GraphGenerator.Settings())
    }

    @Test
    fun testRun() {
        var router = DsGraph.nodes.get(3)
        assertTrue(router.hardware.storage == null)
    }
}