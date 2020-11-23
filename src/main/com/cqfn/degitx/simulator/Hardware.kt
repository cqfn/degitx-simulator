package com.cqfn.degitx.simulator

/**
 * Represents server HW layer
 */
interface Hardware {
    /**
     * Data storage hardware
     */
    val storage: Storage?

    /**
     * Network adapter
     */
    val net: Network
}