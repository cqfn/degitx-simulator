package com.cqfn.degitx.simulator

import java.util.*

/**
 * Emulator of network adapter.
 */
interface Network {
    /**
     * Adapter address.
     */
    var addr: Address

    /**
     * Pool of incoming requests.
     */
    var rqPool: Queue<Request>

    /**
     * Send request rs to given address.
     * @param addr - address in any format
     * @param rq - request
     */
    fun send(addr: Address, rq: Request)

    /**
     * Access to poll of income requests.
     */
    fun receive(): Queue<Request>

    /**
     * Maximum limit in Mb/sec
     */
    var throughput: Long

    /**
     * Calculate the real numbers based on parameter and some minor random delta.
     * Implementation TODO: https://github.com/cqfn/degitx-simulator/issues/19
     */
    fun throughput(): Long
}