package com.cqfn.degitx.simulator

/**
 * Data from benchmark: r500/w150 MB/s
 */
class SATAStorage : Storage {

    override fun write(size: Long): Long {
        return size / 18 * 1000
    }

    override fun read(size: Long): Long {
        return size / 62 * 1000
    }
}