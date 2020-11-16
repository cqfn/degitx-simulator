package com.cqfn.degitx.simulator

import java.util.*

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