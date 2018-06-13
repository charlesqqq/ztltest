/* B30_1984643Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 12, 2011 19:29:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1984643.zul,B,E,Window,Button")
class B30_1984643Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <window xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.zkoss.org/2005/zul" xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd" mode="modal" onCancel="self.detach()" onOK="self.detach()" title="listbox" border="normal" width="400px">
        Please select the select-list, and press the "Enter" or "Esc" button, the window should be closed.
        <label value="listbox : "/>
        <listbox id="sb" mold="select">
          <listitem label="item 1"/>
          <listitem label="item 2"/>
        </listbox>
      </window>
    """
    runZTL(zscript, () => {
      var sb: Widget = engine.$f("sb");
      def selectItem(item: String) {
        var doms: JQuery = jq(":contains(" + item + ")");
        var dom: Element = doms.get(doms.length() - 1);
        click(sb.$n());
        click(dom);
        waitResponse();
      }
      // Click on the listbox
      selectItem("item 1");
      waitResponse();

      sendKeys(jq("@select"), Keys.ENTER);
      waitResponse();

      // Verify that the listbox is not visible
      verifyFalse("The Listbox should be invisible", jq("@select").isVisible());

    })
  }
}