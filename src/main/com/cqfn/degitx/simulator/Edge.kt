package com.cqfn.degitx.simulator

/**
 * Represents the record in routing table.
 * Global routing table is represented here by Graph class.
 * @see Graph
 */
class Edge {
    constructor(from: Server, to: Server) {
        this.head = from
        this.tail = to
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