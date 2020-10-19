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
           override var rqPool: Queue<Request>,
           override var state: State) : Server {

    constructor(hw: Hardware) {
        this.state = State.ACTIVE
        this.hardware = hw
        this.rqPool = LinkedList<Request>()
    }

    var repos = emptyList<GitRepo>()

    /**
     * Logic of software GitHub Node
     */
    override fun run(addr: Address, rq: Request) {

    }

}