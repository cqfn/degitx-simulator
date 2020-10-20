package com.cqfn.degitx.simulator

/**
 * Stub for Request sent via Network to Address.
 */
class Request {
    constructor(sender: Address, id: Int, size: Int) {
        this.sender = sender
        this.id = id;
        this.size = size
    }

    /**
     * Optional ID of request for cases when response is required.
     */
    var id = 0

    /**
     * Initiator of request.
     */
    val sender: Address

    /**
     * Size of body instead of real data. It's enough for Simulation.
     */
    val size: Int
}