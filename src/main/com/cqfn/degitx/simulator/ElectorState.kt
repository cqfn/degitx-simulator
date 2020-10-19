package com.cqfn.degitx.simulator

/**
 * State of node in Election process.
 * @see GitRepo
 */
enum class ElectorState {
    CANDIDATE, FOLLOWER, LEADER
}