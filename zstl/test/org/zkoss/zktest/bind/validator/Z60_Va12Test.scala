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
package org.zkoss.zktest.bind.validator
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_Va12Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va12.zul"/>
"""

    runZTL(zul, () => {

      val computeButton = engine.$f("computeButton")
      val total = engine.$f("total")
      val quantityABox = engine.$f("quantityABox")
      val quantityBBox = engine.$f("quantityBBox")
      val subtotalA = engine.$f("subtotalA")
      val subtotalB = engine.$f("subtotalB")
      val offBox = engine.$f("offBox")

      click(computeButton);
      waitResponse();
      verifyEquals("30", getText(total));

      `type`(quantityABox, "10");
      click(subtotalA);
      waitResponse();
      verifyEquals("100", getText(subtotalA));

      `type`(quantityBBox, "11");
      click(subtotalB);
      waitResponse();
      verifyEquals("20", getText(subtotalB));

      `type`(quantityBBox, "10");
      click(subtotalB);
      waitResponse();
      verifyEquals("200", getText(subtotalB));

      click(computeButton);
      waitResponse();
      verifyEquals("300", getText(total));

      `type`(offBox.$n("real"), "90");
      click(computeButton);
      waitResponse();
      verifyEquals("270", getText(total));

    })
  }
}