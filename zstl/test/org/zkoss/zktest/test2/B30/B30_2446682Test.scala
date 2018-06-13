/* B30_2446682Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2446682Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<?page id="testZul" title=" New ZUL Title" cacheable="false" 
				language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
			<zk xmlns="http://www.zkoss.org/2005/zul"
				xmlns:h="http://www.w3.org/1999/xhtml" 
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
				xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd">
			<html><![CDATA[
			<ol>
			<li>Press the 'testButton'</li>
			<li>If you see an exception "Illegal event method name(component id not specified or consecutive '$'): onClick$$testButton", then it is correct.</li>
			<li>done</li>
			</ol>
			]]></html>
			<window id="win" title="My First Window" border="normal" width="200px">
			<button id="testButton" label="testButton">
				<attribute name="onClick"><![CDATA[
					Object composer = new org.zkoss.zktest.test2.B2446682();
					//Events.addEventListeners(win, composer);
					Components.addForwards(win, composer);
				]]></attribute>
			</button>
			</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val testZul = ztl$engine.$f("testZul")
    val win = ztl$engine.$f("win")
    val testButton = ztl$engine.$f("testButton")
    runZTL(zscript, () => {
      click(testButton);
      waitResponse()
      verifyTrue(jq(".z-window-modal").exists())
      verifyEquals("Illegal event method name(component id not specified or consecutive '$'): onClick$$testButton", jq(".z-messagebox > span.z-label").text());
    })
  }
}



