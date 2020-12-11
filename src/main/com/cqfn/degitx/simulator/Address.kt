package com.cqfn.degitx.simulator

import java.util.Random
import kotlin.streams.asSequence

/**
 * Representation of address for emulator
 */

const val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

const val addressLength = 6L

class Address(address : String) {

    /**
     * Multi format address, public property
     */
    val addr = address

    //TODO: Change to call GUID
    companion object {
        val randomAddr = Random().ints(addressLength, 0, source.length)
                .asSequence()
                .map(source::get)
                .joinToString("")
    }

    constructor() : this(randomAddr)

}