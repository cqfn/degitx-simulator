package com.cqfn.degitx.simulator.entities.impl

import com.cqfn.degitx.simulator.DsGraph
import com.cqfn.degitx.simulator.State
import com.cqfn.degitx.simulator.entities.Edge
import com.cqfn.degitx.simulator.entities.Hardware
import com.cqfn.degitx.simulator.entities.Request
import com.cqfn.degitx.simulator.entities.Server
import com.cqfn.degitx.simulator.randomengine.GUID

/**
 * Smart Router representation.
 * As part of global networks connected with other Servers via Edges.
 * Similar to Node, another implementation of Server without GitHub logic, just router.
 *
 * @see Graph
 * @see Edge
 */
class Router(override var hardware: Hardware) : Server {

    override var id = GUID().guid

    override var state = State.ACTIVE

    var processedRqs = mutableSetOf<Int>()

    constructor(id: String, hw: Hardware, state: State): this(hw) {
        this.id = id
        this.state = state
    }


    /**
     * Logic of software or hardware Router
     */
    override fun run(rq: Request) {
        if (this.state == State.ACTIVE) {
            if (rq.id in processedRqs) {
                println("Rq " + rq.id + " is already transmitted through Router " + this.hardware.net.addr.addr)
                return
            }
            this.hardware.net.rqPool.add(rq)
            processRequest()
        } else {
            println("Node with address " + this.hardware.net.addr.addr +
                    " cannot process request as it is " + this.state.toString())
        }
    }

    /**
     * Simple Router internal logic for Request processing - just resend Request to all connected Nodes
     */
    fun processRequest() {
        var rq : Request = this.hardware.net.receive().poll()
        if (rq != null) redirect(rq)
    }

    /**
     * Redirect request according to Node discovery protocol.
     * May be improved to go to API method of Server, if needed.
     */
    fun redirect(rq: Request) {
        var gr = DsGraph
        var edges : List<Edge> = DsGraph.outgoingEdges(this)
        // TODO: Increment rq's timespent. See issue #19
        for (edge in edges) edge.head.run(rq)
    }
}