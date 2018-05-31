/* B50_2989808Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2989808Test extends ZTL4ScalaTestCase {
  @Test
  def testFormat() = {
    var zscript =
      """
		<zk>
			<decimalbox id="d1" format="#####.0##%" value="123.456"/>
			<decimalbox id="d2" format="##0.##%" value="123"/>
			<decimalbox id="d3" width="150px" format="R ##,###,###,###.00%" value="123456"/>
			<decimalbox id="d4" width="150px" format="#,###,###.00%" value="123456"/>			
		</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val d1 = ztl$engine.$f("d1")
    val d2 = ztl$engine.$f("d2")
    val d3 = ztl$engine.$f("d3")
    val d4 = ztl$engine.$f("d4")
    runZTL(zscript, () => {
      verifyEquals("12345.6%", jq(d1).`val`())
      verifyEquals("12300%", jq(d2).`val`());
      verifyEquals("R 12,345,600.00%", jq(d3).`val`())
      verifyEquals("12,345,600.00%", jq(d4).`val`());
      focus(d1);
      blur(d1)
      verifyEquals("12345.6%", jq(d1).`val`());
      focus(d2);
      blur(d2)
      verifyEquals("12300%", jq(d2).`val`());
      focus(d3);
      blur(d3)
      verifyEquals("R 12,345,600.00%", jq(d3).`val`());
      focus(d4);
      blur(d4)
      verifyEquals("12,345,600.00%", jq(d4).`val`());
    })
  }
}



