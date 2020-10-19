package com.cqfn.degitx.simulator

import java.util.*

/**
 * Smart Router representation.
 * As part of global networks connected with other Servers via Edges.
 *
 * @see Graph
 * @see Edge
 */
class Router(override var state: State,
             override var hardware: Hardware,
             override var rqPool: Queue<Request>) : Server {
    /**
     * Logic of software router
     */
    override fun run(addr: Address, rq: Request) {

    }

}