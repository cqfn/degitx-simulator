package com.cqfn.degitx.simulator

/**
 * Emulates data holder
 */
interface Storage {

    /**
     * @param size - Mb comes
     * @return msec time spent
     */
    fun write(size: Long): Long

    /**
     * @param size - Mb requested
     * @return msec time spent
     */
    fun read(size: Long): Long
}