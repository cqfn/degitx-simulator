package com.cqfn.degitx.simulator

const val VERSION = "0.0.1"

fun main() {
    val Sim = Simulator()
    println(Sim.version())
}

class Simulator {
    fun version(): String {
        return "DeGitX Simulator v" + VERSION
    }
    // TODO: Issue #23: Read settings


    // Initiate logs
    // Generate Graph
    // Place repositories to Nodes
    // Run Simulation
    // Stop Simulation
    // Collect logs
    // Export logs in some readable view
}