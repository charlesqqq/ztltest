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
package org.zkoss.zktest.bind.issue

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0002Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F0002.zul"/>
"""

    runZTL(zul, () => {
      //test property init
      val tb1 = engine.$f("tb1")
      val l1 = engine.$f("l1")
      val tb2 = engine.$f("tb2")
      val l2 = engine.$f("l2")

      verifyEquals("A", getValue(tb1));
      verifyEquals("A", getText(l1));
      verifyEquals("A", getValue(tb2));
      verifyEquals("A", getText(l2));

      //		Assert.assertEquals("A",findWidget("$tb1").getValue());
      //		Assert.assertEquals("A",findWidget("$l1").getValue());
      //		Assert.assertEquals("A",findWidget("$tb2").getValue());
      //		Assert.assertEquals("A",findWidget("$l2").getValue());

      `type`(tb1, "XX")
      sendKeys(tb1, Keys.TAB)
      waitResponse()
      verifyEquals("XX", getValue(tb1));
      verifyEquals("XX", getText(l1));
      verifyEquals("A", getValue(tb2));
      verifyEquals("A", getText(l2));
      //		findWidget("$tb1").clear().keys("XX").tab();
      //		Assert.assertEquals("XX",findWidget("$tb1").getValue());
      //		Assert.assertEquals("XX",findWidget("$l1").getValue());
      //		Assert.assertEquals("A",findWidget("$tb2").getValue());
      //		Assert.assertEquals("A",findWidget("$l2").getValue());

      `type`(tb2, "YY")
      sendKeys(tb2, Keys.TAB)
      waitResponse()
      verifyEquals("XX", getValue(tb1));
      verifyEquals("XX", getText(l1));
      verifyEquals("YY", getValue(tb2));
      verifyEquals("A", getText(l2));
      //		findWidget("$tb2").clear().keys("YY").tab();
      //		Assert.assertEquals("XX",findWidget("$tb1").getValue());
      //		Assert.assertEquals("XX",findWidget("$l1").getValue());
      //		Assert.assertEquals("YY",findWidget("$tb2").getValue());
      //		Assert.assertEquals("A",findWidget("$l2").getValue());

      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("YY", getValue(tb1));
      verifyEquals("YY", getText(l1));
      verifyEquals("YY", getValue(tb2));
      verifyEquals("YY", getText(l2));
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("YY",findWidget("$tb1").getValue());
      //		Assert.assertEquals("YY",findWidget("$l1").getValue());
      //		Assert.assertEquals("YY",findWidget("$tb2").getValue());
      //		Assert.assertEquals("YY",findWidget("$l2").getValue());

      //test form init
      val tb3 = engine.$f("tb3")
      val l31 = engine.$f("l31")
      val l32 = engine.$f("l32")
      waitResponse()
      verifyEquals("B", getValue(tb3));
      verifyEquals("B", getText(l31));
      verifyEquals("B", getText(l32));
      //		Assert.assertEquals("B",findWidget("$tb3").getValue());
      //		Assert.assertEquals("B",findWidget("$l31").getValue());
      //		Assert.assertEquals("B",findWidget("$l32").getValue());

      `type`(tb3, "ZZ")
      sendKeys(tb3, Keys.TAB)
      waitResponse()
      verifyEquals("ZZ", getValue(tb3));
      verifyEquals("B", getText(l31));
      verifyEquals("B", getText(l32));
      //		findWidget("$tb3").clear().keys("ZZ").tab();
      //		Assert.assertEquals("ZZ",findWidget("$tb3").getValue());
      //		Assert.assertEquals("B",findWidget("$l31").getValue());
      //		Assert.assertEquals("B",findWidget("$l32").getValue());

      click(engine.$f("btn2"))
      waitResponse()
      verifyEquals("ZZ", getValue(tb3));
      verifyEquals("ZZ", getText(l31));
      verifyEquals("ZZ", getText(l32));
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("ZZ",findWidget("$tb3").getValue());
      //		Assert.assertEquals("ZZ",findWidget("$l31").getValue());
      //		Assert.assertEquals("ZZ",findWidget("$l32").getValue());

    })
  }
}
