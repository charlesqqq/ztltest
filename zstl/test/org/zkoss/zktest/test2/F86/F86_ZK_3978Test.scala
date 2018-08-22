package org.zkoss.zktest.test2.F86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3978.zul")
class F86_ZK_3978Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verScroll(jq("@tree"), 50)

      closeZKLog()
      jq(".z-tree-icon").get(0).eval("scrollIntoView()")
      click(jq(".z-tree-icon:eq(0)"))
      waitResponse()

      verifyEquals("OnDataLoading more han once", 1, getZKLog.split("\n").length)
    })
  }
}