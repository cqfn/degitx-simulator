package com.cqfn.degitx.simulator

/**
 * Stub for Request sent via Network to Address.
 *
 * @param sender Initiator of request.
 * @param addressee Recipient
 * @param id Optional ID of request for cases when response is required. Default value is 0 = No Response Required.
 * @param size Size of body instead of real data. It's enough for Simulation.
 * @param timespent Time spent to process this request. Will go to final log for analysis. Increments all way.
 * @param type Type of request: Internal enum: Read/Write - related to Storage.
 * @see Storage
 */
class Request {
    constructor(sender: Address, addressee: Address, id: Int, size: Long, timespent: Long, type: Request.Type) {
        this.addressee = addressee
        this.sender = sender
        this.id = id;
        this.size = size
        this.timespent = timespent
        this.type = type
    }

    enum class Type {
        READ, WRITE
    }

    val addressee: Address

    /**
     * Type of the request
     */
    val type: Request.Type

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
    val size: Long

    /**
     * Time spent to process this request. Will go to final log for analysis. Increments all way.
     */
    var timespent: Long

    /**
     * Format can be adapted after message designed.
     * @see Issue #6
     */
    override fun toString() : String {
        return type.toString() + " Request id " + id + "\nFrom: " + sender.addr + " To: " + addressee.addr +
        " Size in bytes: " + size + " Spent ms: " + timespent
    }
}