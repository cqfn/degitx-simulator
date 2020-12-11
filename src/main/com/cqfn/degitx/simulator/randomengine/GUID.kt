package com.cqfn.degitx.simulator.randomengine

import java.util.*
import kotlin.streams.asSequence

const val longSource = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

const val GUIDLength = 8L

class GUID {
    val guid = Random().ints(GUIDLength, 0, longSource.length)
            .asSequence()
            .map(longSource::get)
            .joinToString("")
}
