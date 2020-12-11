package com.cqfn.degitx.simulator.randomengine

import org.testng.Assert.*
import org.testng.annotations.Test

class GUIDTest {
    @Test
    fun testGUID() {
        var guid = GUID().guid
        assertEquals(guid.length.toLong(), GUIDLength)
    }
}