/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.form
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F2Test extends ZTL4ScalaTestCase {
  def testArg() = {

    val zul = """
      <include src="/bind/form/F2.zul"/>
"""

    runZTL(zul, () => {

      val quantityABox = engine.$f("quantityABox")
      val quantityBBox = engine.$f("quantityBBox")
      val computeButton = engine.$f("computeButton")
      val subtotalA = engine.$f("subtotalA")
      val subtotalB = engine.$f("subtotalB")
      val total = engine.$f("total")
      val offBox = engine.$f("offBox")

      `type`(quantityABox, "5");
      `type`(quantityBBox, "5");
      click(computeButton);
      waitResponse();
      verifyEquals("50", getText(subtotalA));
      verifyEquals("100", getText(subtotalB));
      verifyEquals("150", getText(total));

      `type`(quantityABox, "11");
      click(computeButton);
      waitResponse();
      verifyEquals("150", getText(total));

      `type`(quantityABox, "5");
      `type`(offBox.$n("real"), "50");
      click(computeButton);
      waitResponse();
      verifyEquals("75", getText(total));
    })

  }
}