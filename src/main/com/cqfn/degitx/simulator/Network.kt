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
     * @param addr - address in multi-address format
     * @param rq - request headers+body
     */
    fun send(addr: Address, rq: Request)

    /**
     * When Node Address is the same as mentioned, this method be called by Network adapter
     */
    fun receive(rq: Request)
}