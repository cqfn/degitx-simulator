package com.cqfn.degitx.simulator.entities

import com.cqfn.degitx.simulator.State

/**
 * Smart hardware router or Server (Node) representation.
 * Able to receive and send requests and ask neighbours about requested address
 */
interface Server {
    /**
     * Unique ID of the Server
     */
    var id: String

    /**
     * Storage if any and one network adapter
     */
    var hardware: Hardware

    /**
     * Current state of server
     */
    var state: State

    /**
     * Logic which must find next recipient when given address in not equals to its.
     */
    fun run(rq: Request)
}