package com.cqfn.degitx.simulator

/**
 * Graph of physical network.
 * Keeps knowledge about all network, but emulates route tables for Nodes and Routers.
 */
interface Graph {

    /**
     * All GitHub Nodes and Routers
     */
    var nodes: List<Server>

    /**
     * All Edges between Nodes
     */
    var edges: List<Edge>

    /**
     * To be used by Routers and Nodes for discovery protocol
     */
    fun outgoingEdges(tail: Server): List<Edge>

    fun incomingEdges(head: Server): List<Edge>
}