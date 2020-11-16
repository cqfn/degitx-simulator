package com.cqfn.degitx.simulator

import java.util.Random
import kotlin.streams.asSequence

/**
 * Representation of address for emulator
 */
class Address {

    private val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    private val addressLength = 6L

    constructor() {
        this.addr = Random().ints(addressLength, 0, source.length)
                .asSequence()
                .map(source::get)
                .joinToString("")
    }

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