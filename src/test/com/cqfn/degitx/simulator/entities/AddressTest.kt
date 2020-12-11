package com.cqfn.degitx.simulator.entities

import com.cqfn.degitx.simulator.entities.Address
import org.testng.annotations.Test

import org.testng.Assert.*

class AddressTest {

    @Test
    fun testGetAddr() {
        val tomcatHome = "South Butovo Park"
        var addr = Address(tomcatHome)
        assertEquals(addr.addr, tomcatHome)
    }

    @Test
    fun testGetRandomAddr() {
        var addr = Address()
        assertEquals(addr.addr.length, 6) // See @Address to find this const
    }
}
