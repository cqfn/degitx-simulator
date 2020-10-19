package com.cqfn.degitx.simulator

import java.util.concurrent.ThreadLocalRandom

/**
 * Represents whole network infrastructure between two Servers. Emulates delays and throughput limitations.
 */
class Edge {
    constructor(from: Server, to: Server) {
        this.from = from
        this.to = to
        this.state = State.ACTIVE
    }

    val from: Server

    val to: Server

    /**
     * Current state of Edge
     */
    var state: State

    /**
     * Maximum limit in Mb/sec
     */
    var throughput = 0L

    fun throughput(): Long {
        // TODO: calculate the real numbers based on parameter and some minor random delta.
        return this.throughput
    }
}