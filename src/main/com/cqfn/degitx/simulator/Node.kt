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

    constructor(hw: Hardware): this(hw, State.ACTIVE)

    /**
     * Logic of software GitHub Node
     * If current state of the Node allows push Request to process queue.
     */
    override fun run(rq: Request) {
        if (this.state == State.ACTIVE) {
            this.hardware.net.rqPool.add(rq)
            processRequest()
        } else {
            println("Node with address " + this.hardware.net.addr.addr() +
                    " cannot process request as it is " + this.state.toString())
        }
    }

    /**
     * Node internal logic for Request processing
     */
    fun processRequest() {
        var rq : Request = this.hardware.net.receive().poll()
        while (rq != null) {
            if (rq.addressee.equals(this.hardware.net.addr)) {
                // Process incoming requests to THIS node
                when (rq.type) {
                    Request.Type.READ -> rq.timespent += this.hardware.storage.read(rq.size)
                    Request.Type.WRITE -> rq.timespent += this.hardware.storage.write(rq.size)
                }
                // Request is processed successfully, log it.
                //TODO: Change this log to message send. See issue #6
                println("Request with id " + rq.id + " processed in " + rq.timespent +
                        " msec on the Node with address " + this.hardware.net.addr)
            } else { // Redirect this rq to other node
                var gr = DsGraph
                var edges : List<Edge> = gr.outgoingEdges(this)
                // TODO: Increment rq's timespent. See issue #19
                for (edge in edges) edge.head.run(rq)
            } // else - redirect
        }
    }
}