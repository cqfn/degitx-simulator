package com.cqfn.degitx.simulator.entities.impl

import com.cqfn.degitx.simulator.DsGraph
import com.cqfn.degitx.simulator.entities.Address
import com.cqfn.degitx.simulator.entities.Network
import com.cqfn.degitx.simulator.entities.Request
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
        DsGraph.node(addr).run(rq)
    }

    override fun receive(): Queue<Request> {
        return this.rqPool
    }

    override fun throughput(): Long {
        return this.throughput
    }
}