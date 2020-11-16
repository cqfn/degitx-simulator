package com.cqfn.degitx.simulator

import java.util.*

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

    override var rqPool: Queue<Request> = LinkedList<Request>()

    /**
     * Logic of software GitHub Node
     */
    override fun run(addr: Address, rq: Request) {
        // Process incoming requests to THIS node
        var req = rqPool.poll()
        while (req != null) {
           // req.
        }
    }

}