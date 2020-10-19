package com.cqfn.degitx.simulator

/**
 * State of physical server or network infrastructure (Edge is the whole way between Node A and Node B)
 */
enum class State {
    ACTIVE, DOWN, SLOW, OUTDATED
}