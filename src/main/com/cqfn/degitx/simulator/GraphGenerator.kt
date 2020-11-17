package com.cqfn.degitx.simulator

import java.util.*

class GraphGenerator{

    var nodes = emptyArray<Server>()
    var edges = emptyArray<Edge>()
    
    /**
     * Internal default settings to check it
     */
    class Settings {
        var nodeNumber : Int = 3
        var routersNumber: Int = 1
        var edgesNumber: Int = 7
    }

    /**
     * Dummy algorithm to generate simple directed graph
     */
    fun generate(settings: Settings) : DsGraph {
        for (i in 1..settings.nodeNumber) {
            var node = Node(NodeHardware(SATAStorage(),
                    BasicNetwork(Address("node"+i), LinkedList(), 1L)),
                    State.ACTIVE)
            nodes = nodes.plus(node)
        }
        for (i in 1..settings.routersNumber) {
            var router = Router(NodeHardware(SATAStorage(),
                    BasicNetwork(Address("node"+(settings.nodeNumber+i).toString()), LinkedList(), 1L)),
                    State.ACTIVE)
            nodes = nodes.plus(router)
        }

        var edge = Edge(nodes[nodes.size-1], nodes[0])
        edges = edges.plus(edge)
        edge = Edge(nodes[nodes.size-2], nodes[0])
        edges = edges.plus(edge)
        edge = Edge(nodes[nodes.size-3], nodes[0])
        edges = edges.plus(edge)
        edge = Edge(nodes[nodes.size-1], nodes[nodes.size-2])
        edges = edges.plus(edge)
        edge = Edge(nodes[nodes.size-2], nodes[nodes.size-3])
        edges = edges.plus(edge)
        edge = Edge(nodes[nodes.size-3], nodes[nodes.size-4]) // nodes[0]
        edges = edges.plus(edge)

        var graph = DsGraph
        graph.nodes = nodes.toList()
        graph.edges = edges.toList()
        return graph
    }
}