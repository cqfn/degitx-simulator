package com.cqfn.degitx.simulator

/**
 * DRAFT: GitRepository replica, placed at some Node
 */
interface GitRepo {

    /**
     * Must be same for all replicas
     */
    val name: String

    var size: Long

    /**
     * Known number of Replicas, needed for Elections
     */
    val totalNodesNumber: Int

    /**
     * Current state of this repository node
     */
    var electorState: ElectorState

    var currentTimeout: Long

    /**
     * Process write operation.
     * @param size - number of bytes to store
     * @return Long - number of msec for delay. Depends on Node's HW and Queue.
     */
    fun push(size: Long): Long
}