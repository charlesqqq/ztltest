package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2010.zul")
class B70_ZK_2010Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2010.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Nov 11, 2013  4:36:57 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<vbox>
<label multiline="true">
	1. select tab2 (B) or 3 (C) in 2nd tabbox, and click the button in the 2nd tabbox, you will see the tabbox kept its selection. (not back to the first tab)
</label>
<tabbox>
	<tabs>
		<tab label="Tab1"></tab>
		<tab label="Tab2"></tab>
	</tabs>
	<tabpanels>
		<tabpanel>Panel 1
		<button label="click me 1" onClick="//do nothing"></button>
		</tabpanel>
		<tabpanel>Panel 2
		<button label="click me 2" onClick="//do nothing"></button>
		</tabpanel>
	</tabpanels>
</tabbox>
<zscript><![CDATA[
ListModelList model = new ListModelList();
model.add("A");
model.add("B");
model.add("C");
model.addToSelection("A");
]]></zscript>
<tabbox model="${model}">
	<template name="model:tab">
		<tab label="${each}"></tab>
	</template>
	<template name="model:tabpanel">
		<tabpanel>Panel ${each}
			<button label="click me ${each}" onClick="//do nothing"></button>
		</tabpanel>
	</template>
</tabbox>

</vbox>
"""
    runZTL(zscript,
      () => {
        var tb = jq(".z-tabbox:eq(1)")
        click(tb.find(".z-tab:eq(1)"))
        waitResponse()
        click(tb.find(".z-tab:eq(2)"))
        waitResponse()
        click(jq(".z-button:contains(me C)"))
        waitResponse()
        verifyTrue("you will see the tabbox kept its selection. (not back to the first tab)", tb.find(".z-tab:eq(2)").hasClass("z-tab-selected"))
      })

  }
}