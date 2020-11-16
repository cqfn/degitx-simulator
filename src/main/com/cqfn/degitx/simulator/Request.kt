package com.cqfn.degitx.simulator

/**
 * Stub for Request sent via Network to Address.
 * Data class.
 */
class Request {
    constructor(sender: Address, id: Int, size: Int, timespent: Long) {
        this.sender = sender
        this.id = id;
        this.size = size
        this.timespent = timespent
    }

    /**
     * Optional ID of request for cases when response is required.
     * Defaut value is 0 = No Response Required.
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

    /**
     * Time spent to process this request. Will go to final log for analysis. Increments all way.
     */
    var timespent: Long
}