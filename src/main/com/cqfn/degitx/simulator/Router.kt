package com.cqfn.degitx.simulator

import java.util.*

/**
 * Smart Router representation.
 * As part of global networks connected with other Servers via Edges.
 *
 * @see Graph
 * @see Edge
 */
class Router(override var hardware: Hardware,
             override var state: State,
             override var rqPool: Queue<Request>) : Server {

    constructor(hw: Hardware): this(hw, State.ACTIVE, LinkedList<Request>())

    /**
     * Logic of software router
     */
    override fun run(addr: Address, rq: Request) {
        if (addr == this.hardware.net.addr) {
            System.out.println("Router cannot be an addressee.")
        } else {
            // get neighbors and call them
            var neighbors = DsGraph.outgoingEdges(this)
            var node = neighbors.filter { hardware.net.addr == addr }
            if (node.getOrNull(0) != null) {
                // Got it
                // this.hardware.net.send(node.get(0).hardware.net.addr, rq)
            } else {
                // Loop by neighbors and recursion call

            }

        }
    }

}