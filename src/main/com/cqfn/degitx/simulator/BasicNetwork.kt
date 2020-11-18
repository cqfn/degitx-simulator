package com.cqfn.degitx.simulator

import java.util.*

/**
 * Network implementation as a very common and ideal network adapter.
 * Use in case when network call does not expect any response and does not check the real throughput (unlimited).
 */
class BasicNetwork(override var addr: Address,
                   override var rqPool: Queue<Request>,
                   override var throughput: Long) : Network {

    constructor(addr: Address): this(addr, LinkedList<Request>(), 1L) {}

    override fun send(addr: Address, rq: Request) {
        val graph = DsGraph
        graph.node(addr).run(addr, rq)
    }

    override fun receive(): Queue<Request> {
        return this.rqPool
    }

    override fun throughput(): Long {
        return this.throughput
    }
}