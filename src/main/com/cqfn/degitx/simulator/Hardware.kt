package com.cqfn.degitx.simulator

/**
 * Represents server HW layer
 */
interface Hardware {
    /**
     * Data storage hardware
     */
    var storage: Storage

    /**
     * Network adapter
     */
    var net: Network
}