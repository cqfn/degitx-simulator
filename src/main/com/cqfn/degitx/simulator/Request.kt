package com.cqfn.degitx.simulator

/**
 * Stub for Request sent via Network to Address
 */
class Request {
    constructor(sender: Address, size: Int) {
        this.sender = sender
        this.size = size
    }

    /**
     * Initiator of request
     */
    val sender: Address

    /**
     * Size of body instead of real data. It's enough for Simulation.
     */
    val size: Int
}