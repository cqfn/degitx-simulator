package com.cqfn.degitx.simulator

/**
 * Stub for Request sent via Network to Address.
 * Data class.
 * @param sender Initiator of request.
 * @param id Optional ID of request for cases when response is required. Default value is 0 = No Response Required.
 * @param size Size of body instead of real data. It's enough for Simulation.
 * @param timespent Time spent to process this request. Will go to final log for analysis. Increments all way.
 */
data class Request (val sender: Address, var id : Int = 0, val size: Int, var timespent: Long = 0L)