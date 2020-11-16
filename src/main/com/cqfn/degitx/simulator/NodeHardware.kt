package com.cqfn.degitx.simulator

class NodeHardware (override var storage: Storage,
                    override var net: Network): Hardware {

    constructor(): this(SATAStorage(), BasicNetwork(Address()))
}