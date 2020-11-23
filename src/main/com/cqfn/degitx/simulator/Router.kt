package com.cqfn.degitx.simulator

/**
 * Smart Router representation.
 * As part of global networks connected with other Servers via Edges.
 * Similar to Node, another implementation of Server without GitHub logic, just router.
 *
 * @see Graph
 * @see Edge
 */
class Router(override var hardware: Hardware,
             override var state: State) : Server {

    constructor(hw: Hardware): this(hw, State.ACTIVE)

    /**
     * Logic of software or hardware Router
     */
    override fun run(rq: Request) {
        if (this.state == State.ACTIVE) {
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
        while (rq != null) redirect(rq)
    }

    /**
     * Redirect request according to Node discovery protocol.
     * May be improved to go to API method of Server, if needed.
     */
    fun redirect(rq: Request) {
        var gr = DsGraph
        var edges : List<Edge> = gr.outgoingEdges(this)
        // TODO: Increment rq's timespent. See issue #19
        for (edge in edges) edge.head.run(rq)
    }
}