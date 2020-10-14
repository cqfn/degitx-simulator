package test.com.cqfn.degitx.simulator

import com.cqfn.degitx.simulator.Simulator
import org.testng.Assert
import org.testng.annotations.Test

class SimulatorTest {

    @Test
    fun testVersion() {
        Assert.assertEquals(Simulator().version().startsWith( "DeGitX Simulator v"), true)
    }
}