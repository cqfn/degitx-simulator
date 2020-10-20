package com.cqfn.degitx.simulator

/**
 * Graph of physical network.
 * Keeps knowledge about all network, but emulates route tables for Nodes and Routers.
 */
interface Graph {

    /**
     * All GitHub Nodes
     * Here String is MAC Address
     */
    var nodes: HashMap<String, Server>

    /**
     * All Edges between Nodes (or Routers)
     */
    var edges: HashMap<String, Edge>

    /**
     * To be used by Routers and Nodes for discovery protocol
     */
    fun outgoingEdges(node: Node): List<Node>

    fun incomingEdges(node: Node): List<Node>
}