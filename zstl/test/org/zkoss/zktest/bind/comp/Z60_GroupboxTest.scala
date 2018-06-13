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
package org.zkoss.zktest.bind.comp

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_GroupboxTest extends ZTL4ScalaTestCase {
  def testContainer() = {
    val zul = """
    		<include src="bind/comp/groupbox.zul"/>
"""
    runZTL(zul, () => {
    
      //button
      val openStatus = engine.$f("openStatus")
      verifyEquals("false", getText(openStatus));
      click(jq("@groupbox"))
      waitResponse()
      verifyEquals("true", getText(openStatus));
    })
  }
}