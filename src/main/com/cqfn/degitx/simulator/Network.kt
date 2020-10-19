package com.cqfn.degitx.simulator

/**
 * Emulator of network adapter.
 */
interface Network {
    /**
     * Adapter address
     */
    var addr: Address

    /**
     * Send request rs to given address.
     * @param addr - address in any format
     * @param rq - request
     */
    fun send(addr: Address, rq: Request)

    /**
     * When Node Address is the same as mentioned, this method be called by Network adapter
     */
    fun receive(rq: Request)
}