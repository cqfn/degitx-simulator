package com.cqfn.degitx.simulator

import com.cqfn.degitx.simulator.randomengine.GUID

/**
 * Represents the record in routing table.
 * Global routing table is represented here by Graph class.
 * @see Graph
 */
class Edge {

    var id = GUID().guid

    constructor(tail: Server, head: Server) {
        this.head = head
        this.tail = tail
        this.state = State.ACTIVE
    }

    /**
     * Destination
     */
    val head: Server

    /**
     * Departure
     */
    val tail: Server

    /**
     * Current state of Edge
     */
    var state: State

}