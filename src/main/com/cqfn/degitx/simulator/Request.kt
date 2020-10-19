package com.cqfn.degitx.simulator

/**
 * Stub for Request sent via Network to Address
 */
class Request {
    constructor(size: Int) {
        this.size = size
    }

    /**
     * Size of body instead of real data. It's enough for Simulation.
     */
    val size: Int
}