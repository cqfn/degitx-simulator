package com.cqfn.degitx.simulator

/**
 * Represents Server Hardware, which includes not-null storage and Network adapter.
 * Storage is a sign: it's exists for Nodes and does not exist for Routers (Only network and software logic).
 */
class NodeHardware (override val storage: Storage?,
                    override val net: Network): Hardware {

    constructor(): this(SATAStorage(), BasicNetwork(Address()))
}