package com.cqfn.degitx.simulator

/**
 * Represents server HW layer
 */
interface Hardware {
    public val storage: Storage
    public val net: Network
}