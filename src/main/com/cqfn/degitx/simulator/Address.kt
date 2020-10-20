package com.cqfn.degitx.simulator

/**
 * Representation of address for emulator
 */
class Address {
    constructor(addr: String) {
        this.addr = addr
    }

    /**
     * Multi format address
     */
    private val addr: String

    fun addr(): String {
        return addr;
    }
}