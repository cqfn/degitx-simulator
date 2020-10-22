package com.cqfn.degitx.simulator

/**
 * Represents the record in routing table.
 * Global routing table is represented here by Graph class.
 * @see Graph
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

}