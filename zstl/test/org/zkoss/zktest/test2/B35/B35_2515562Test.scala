/* B35_2515562Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget;

class B35_2515562Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			



<zk>
<style dynamic="true">
.mycss .z-calendar-text {
	font-family: monospace;
	color: yellow;
}
</style>
Click the button. If the font-color of year is yellow, it is correct.
<datebox sclass='mycss'/>
</zk>
		

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq(jq(".z-datebox").toWidget().$n("btn")))
      var color = org.zkoss.ztl.util.ColorVerifingHelper.isEqualColor("yellow", jq(".z-calendar-text").css("color"))
      verifyTrue(color)
    })
  }
}



