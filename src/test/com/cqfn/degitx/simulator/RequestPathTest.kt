package com.cqfn.degitx.simulator

import org.testng.Assert
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test


class RequestPathTest {

    private var graph = GraphGenerator()

    @BeforeTest
    fun setUp() {
        graph.generate(GraphGenerator.Settings())
    }

    @Test
    fun requestGoesToTarget() {
        var rq = Request(Address("node1"), Address("node2"),
                1, 123L, 0L, Request.Type.WRITE)
        graph.nodes[1].run(rq)
        Assert.assertEquals(rq.timespent, 6000)

        rq = Request(Address("node3"), Address("node1"),
                3, 123L, 0L, Request.Type.READ)
        graph.nodes[1].run((rq))
        Assert.assertEquals(rq.timespent, 1000)
    }
}
