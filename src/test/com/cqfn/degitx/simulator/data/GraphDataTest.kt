package com.cqfn.degitx.simulator.data

import com.cqfn.degitx.simulator.GraphGenerator
import com.google.gson.Gson
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.io.File

class GraphDataTest {

    var graph = GraphGenerator()

    @BeforeSuite
    fun setUp() {
        graph.generate(GraphGenerator.Settings())
    }

    @Test
    fun testTestToString() {
        val resourceName = "src/test/resources/testGraph.json"
        val content = File(resourceName).readText(Charsets.UTF_8)
        var grData = Gson().fromJson(content, GraphData::class.java)
        println(grData.graph)
    }

    @Test
    fun witeStaticGraph() {
        var grData = Gson().toJson(graph)
        println(grData)
    }
}
