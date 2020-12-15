package com.cqfn.degitx.simulator

import com.cqfn.degitx.simulator.entities.Address
import com.cqfn.degitx.simulator.entities.Edge
import com.cqfn.degitx.simulator.entities.Server
import java.util.*

/**
 * Singleton object which represents Routing Table for any Server in Simulated Distributed Network.
 * Used for nodes search and get their outgoing edges to get access to neighbors (Nodes of Routers).
 * @see Edge
 * @see Server
 */
object DsGraph : Graph {

    override var nodes: List<Server> = LinkedList<Server>()

    override var edges: List<Edge> = LinkedList<Edge>()

    fun node(addr: Address) : Server {
        return nodes.filter { it.hardware.net.addr == addr }[0]
    }

    override fun outgoingEdges(tail: Server): List<Edge> {
        return edges.filter { it.tail == tail && it.state == State.ACTIVE }
    }

    override fun incomingEdges(head: Server): List<Edge> {
        return edges.filter { it.head == head && it.state == State.ACTIVE }
    }

}