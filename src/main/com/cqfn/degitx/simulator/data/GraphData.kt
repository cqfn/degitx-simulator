package com.cqfn.degitx.simulator.data

/**
 * Data class to store, load and save graph structure.
 */
data class GraphData(
    val graph: Graph
)

data class Graph(
    val edges: List<Edge>,
    val nodes: List<Node>
)

data class Edge(
    val head: String,
    val tail: String
)

data class Node(
        val hardware: Hardware,
        val id: String,
        val state: String
)

data class Hardware(
    val net: Net,
    val storage: Storage
)

data class Net(
    val addr: String,
    val throughput: Int
)

data class Storage(
    val r: Int,
    val w: Int
)
