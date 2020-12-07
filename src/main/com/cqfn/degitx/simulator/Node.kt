package com.cqfn.degitx.simulator

/**
 * Physical Server with GitHub repositories (Node) representation.
 * As part of global networks connected with other Nodes via Edges.
 *
 * @see Graph
 * @see Edge
 */
class Node(override var hardware: Hardware,
           override var state: State) : Server {

    var processedRqs = mutableSetOf<Int>()

    constructor(hw: Hardware): this(hw, State.ACTIVE)

    /**
     * Logic of software GitHub Node
     * If current state of the Node allows push Request to process queue.
     */
    override fun run(rq: Request) {
        if (this.state == State.ACTIVE) {
            if (rq.id in processedRqs) {
                println("Rq " + rq.id + " is already processed on node " + this.hardware.net.addr.addr)
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
     * Node internal logic for Request processing
     * Process incoming requests to THIS node here, log it, and redirect others
     */
    fun processRequest() {
        var rq : Request = this.hardware.net.receive().poll()
        if (rq != null) {
            println("Node " + this.hardware.net.addr.addr + " processing...")
            if (rq.addressee.addr.equals(this.hardware.net.addr.addr) && this.hardware.storage != null) {
                when (rq.type) {
                    // TODO: Learn Kotlin better and rewrite it properly. Check isNode before.
                    Request.Type.READ -> rq.timespent += this.hardware?.storage?.read(rq.size) ?: rq.timespent
                    Request.Type.WRITE -> rq.timespent += this.hardware?.storage?.write(rq.size) ?: rq.timespent
                }
                //TODO: Change this log to message send. See issue #6
                println("Request with id " + rq.id + " processed in " + rq.timespent +
                        " msec on the Node with address " + this.hardware.net.addr)
            } else {
                redirect(rq)
            }
        }
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
