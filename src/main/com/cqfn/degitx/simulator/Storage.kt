package com.cqfn.degitx.simulator

/**
 * Emulates data holder
 */
interface Storage {

    /**
     * @return msec time spent
     */
    fun write(size: Long): Long

    /**
     * @return msec time spent
     */
    fun read(size: Long): Long
}