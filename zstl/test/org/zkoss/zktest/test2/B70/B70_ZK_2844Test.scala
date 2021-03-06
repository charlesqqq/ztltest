package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2844.zul")
class B70_ZK_2844Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      println(getWebDriver.getWindowHandle)
      //click the left button
      click(jq("button").eq(0))
      waitResponse(true)
      switchTab()
      sleep(2000)
      //click the right button
      click(jq("button").eq(1))
      waitResponse(true)
      //check message in zk.log is "au working"
      verifyEquals("au working\n", getZKLog())
    })
  }
}