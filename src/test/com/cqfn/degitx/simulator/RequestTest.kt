package com.cqfn.degitx.simulator

import org.testng.annotations.Test

import org.testng.Assert.*
import org.testng.annotations.BeforeClass

class RequestTest {

    lateinit var rq : Request

    @BeforeClass
    fun setUp() {
        rq = Request(Address("sender"), Address("receiver"),
                1, 123L, 0L, Request.Type.WRITE)
    }

    @Test
    fun testTestToString() {
        println(rq.toString())
        assertEquals(Request.Type.WRITE, rq.type)
        assertTrue(rq.toString().startsWith(rq.type.toString()))
    }
}