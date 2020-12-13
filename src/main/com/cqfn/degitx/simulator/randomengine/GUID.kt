package com.cqfn.degitx.simulator.randomengine

import java.util.*
import kotlin.streams.asSequence

/**
 * Extended set of Symbols to generate alpha-numeric sequences.
 */
const val longSource = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

/**
 * Pre-defined length for Graph entities IDs.
 */
const val GUIDLength = 8L

/**
 * Common class instead of static String util to generate IDs or any Random String sequences.
 * Call w/o parameters: GUID().guid
 */
class GUID {
    val guid = Random().ints(GUIDLength, 0, longSource.length)
            .asSequence()
            .map(longSource::get)
            .joinToString("")
}
